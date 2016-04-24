package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.collision.AbsCollisionComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.GrouperData;
import fr.icat.bunnyjump.data.WorldData;
import fr.icat.bunnyjump.utils.builder.iBuilderPack;
import fr.icat.bunnyjump.utils.generator.iGenerator;
import fr.icat.bunnyjump.utils.grouper.iGrouper;
import fr.icat.bunnyjump.utils.range.iRange;

/**
 *
 */
public final class SpawnerSystem extends EntitySystem {

    iGrouper<iGenerator<iBuilderPack>> GENERATORS = GrouperData.GENERATORS;

    public ObjectMap<ComponentMapper, Float> higherEntity = new ObjectMap<ComponentMapper, Float>(){{
        put(Mapper.PlatformCollision, (float)WorldData.SIZE.H);
        put(Mapper.Platform, (float)WorldData.SIZE.H);
    }};

    /**
     * Spawner properties
     */
    ObjectMap<Integer, Array<Integer>> spawnablePos = new ObjectMap<Integer, Array<Integer>>();
    Array<Rectangle> secureZoneArray = new Array<Rectangle>();
    Array<Rectangle> badZones = new Array<Rectangle>();
    Rectangle grid = new Rectangle();
    Vector2 startPos = new Vector2();

    /**
     * BuilderPack properties
     */
    Vector2 selectedPos = new Vector2();
    ComponentMapper target;
    Rectangle secureZone;
    Entity entity;
    iRange range;

    /**
     * Components
     */
    TransporterComponent transporterComponent;
    AbsCollisionComponent collisionComponent;
    TransformComponent transformComponent;
    VelocityComponent velocityComponent;
    ComponentMapper mapper;
    Component component;

    // --

    iGenerator<iBuilderPack> gen;

    boolean init = true;

    private boolean exec(){
        return -30 < higherEntity.get(Mapper.PlatformCollision);
    }

    @Override
    public void update(float deltaTime) {

        //Gdx.app.error("time", String.valueOf(deltaTime));

        while(exec()){

            gen = GENERATORS.exec();

            for (iGrouper<iBuilderPack> grp :
                    gen.getGroupers()) {
                spawn(grp.exec());
            }
        }

        if(init) init = false;
    }

    private void spawn(iBuilderPack builderPack) {

        if(builderPack == null) { return; }

        range = builderPack.getRanges().get();
        secureZone = builderPack.getSecureZone();
        entity = builderPack.getBuilder().build();

        getTarget(builderPack.getTarget());

        this.updateGridV1();                             // Create Grid with target & range
        this.updateBadZones();                          // Occupied areas
        this.updateGridV2();

        if(grid.height < 0 || grid.width < 0) {
            Gdx.app.error("STOP", "GRID");
            return;
        }

        this.initSpawnablePos();                        // Init matrix
        this.updateSpawnablePos();                      // Delete occupied positions

        if(spawnablePos.size == 0) {
            Gdx.app.error("STOP", "SPAWN POS");
            Gdx.app.error("STOP", String.valueOf(entity.getClass()));
            return;
        }

        this.initComponent();                           // Components initialisation
        this.selectPos();                               // Select spawn position
        this.updateEntity();                            // Entity position update
        this.updateHigherPos(builderPack.getSaveTargetList());
        this.getEngine().addEntity(entity);
    }

    private void getTarget(ComponentMapper target){

        if(higherEntity.get(target) - range.getMin() < 0){
            this.target = target;
        } else {
            this.target = Mapper.PlatformCollision;
        }
    }

    private void updateGridV1(){

        grid.x = 0;
        grid.y = this.higherEntity.get(this.target) - range.getMax();
        grid.width = WorldData.SIZE.W;
        grid.height = (range.getMax() - range.getMin());
    }

    private void updateBadZones(){

        badZones.clear();

        for (int i = secureZoneArray.size - 1; i >= 0; i--)
        {
            if(!init && secureZoneArray.get(i).y > 0){
                secureZoneArray.removeIndex(i);
            } else if(secureZoneArray.get(i).overlaps(grid)) {
                badZones.add(secureZoneArray.get(i));
            }
        }
    }

    private void updateGridV2(){
        grid.width -= this.secureZone.width;
        grid.height -= this.secureZone.height;
    }

    private void initSpawnablePos(){

        spawnablePos.clear();

        for (int i = (int)grid.y, n = (int)(grid.y + grid.height); i <= n; i++)
        {
            spawnablePos.put(i, new Array<Integer>());

            for (int j = 0, m = (int)(grid.x + grid.width); j <= m; j++) {
                spawnablePos.get(i).add(j);
            }
        }
    }

    private void updateSpawnablePos(){

        for (Rectangle badZone :
            badZones) {

            int xMin = (int)(badZone.x - secureZone.width) + 1;
            int xMax = (int)(badZone.x + badZone.width) - 1;
            int yMin = (int)(badZone.y - secureZone.height) + 1;
            int yMax = (int)(badZone.y + badZone.height) - 1;

            xMin = xMin < grid.x ? (int)grid.x : xMin;
            xMax = xMax > grid.x + grid.width ? (int)(grid.x + grid.width) : xMax;
            yMin = yMin < grid.y ? (int)grid.y : yMin;
            yMax = yMax > grid.y + grid.height ? (int)(grid.y + grid.height) : yMax;

            for (int i = yMin; i <= yMax; i++) {

                for (int j = xMin; j <= xMax; j++) {

                    if(spawnablePos.containsKey(i) && spawnablePos.get(i).contains(j, false)) {
                        spawnablePos.get(i).removeValue(j, false);
                    }
                }

                if(spawnablePos.containsKey(i) && spawnablePos.get(i).size == 0){
                    spawnablePos.remove(i);
                }
            }
        }
    }

    private void selectPos() {

        final Array<Integer> keys = new Array<Integer>(spawnablePos.keys().toArray());
        final int y = keys.get(MathUtils.random(0, keys.size - 1));

        final Array<Integer> values = new Array<Integer>(spawnablePos.get(y).toArray());
        final int x = values.get(MathUtils.random(0, values.size - 1));

        selectedPos.set(x, y);
    }

    private void initComponent() {
        transporterComponent = Mapper.Transporter.get(entity);
        transformComponent = Mapper.Transform.get(entity);
        velocityComponent = Mapper.Velocity.get(entity);
    }

    private void updateEntity(){
        startPos.set(selectedPos).sub(secureZone.x, secureZone.y);
        transformComponent.addVelo(startPos);
        secureZoneArray.add(
                new Rectangle()
                        .setPosition(selectedPos)
                        .setSize(secureZone.width, secureZone.height));

        if(velocityComponent == null){ return; }

        if(velocityComponent.getDistanceX() != null){
            velocityComponent.getDistanceX().update(startPos.x);
        }

        if(velocityComponent.getDistanceY() != null){
            velocityComponent.getDistanceY().update(startPos.y);
        }
    }

    private void updateHigherPos(Array<ComponentMapper> targetArray){

        if(targetArray == null || transformComponent == null) { return; }

        Array<Entity> entities = new Array<Entity>();
        entities.add(entity);
        float y, reely;

        if(transporterComponent != null) {
            for (TransportableComponent transportable :
                    transporterComponent.transportables.values()) {
                entities.add(transportable.parent);
            }
        }

        for (Entity e :
                entities) {

            transformComponent = Mapper.Transform.get(e);
            velocityComponent = Mapper.Velocity.get(e);

            for (ComponentMapper mapper :
                    targetArray) {

                if(!mapper.has(e)) { continue; }

                component = mapper.get(e);
                y = higherEntity.get(mapper);

                if(velocityComponent != null && velocityComponent.getDistanceY() != null){
                    reely = velocityComponent.getDistanceY().start;
                } else {
                    reely = transformComponent.pos.y;
                }

                if(component instanceof AbsCollisionComponent){
                    collisionComponent = (AbsCollisionComponent)component;
                    if(collisionComponent.area.y + reely < y){
                        this.higherEntity.put(mapper,
                                (collisionComponent.area.y + reely));
                    }
                } else {
                    if(reely < y){
                        this.higherEntity.put(mapper, reely);
                    }
                }
            }
        }
    }

    /**
     * Met à jour les secureZone et les HigherPos lors du déplacement en arrière plan des
     * entités
     * @param veloY
     */
    public void updateVeloY(float veloY){

        for (ComponentMapper mapper :
                higherEntity.keys()) {
            higherEntity.put(mapper, higherEntity.get(mapper) + veloY);
        }

        for (Rectangle secZone :
                secureZoneArray) {
            secZone.y += veloY;
        }
    }
}
