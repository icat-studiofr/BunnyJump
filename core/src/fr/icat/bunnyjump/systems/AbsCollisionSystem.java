package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Rectangle;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.collision.AbsCollisionComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 *
 */
public abstract class AbsCollisionSystem extends IteratingSystem{

    private ComponentMapper<? extends AbsCollisionComponent> activeMapper;
    private ComponentMapper<? extends AbsCollisionComponent> passiveMapper;

    ImmutableArray<Entity> passiveEntities;

    TransformComponent activeTransformComponent;
    AbsCollisionComponent activeCollisionComponent;
    Rectangle activeArea;

    TransformComponent passiveTransformComponent;
    AbsCollisionComponent passiveCollisionComponent;
    Rectangle passiveArea;

    public AbsCollisionSystem(
            Family family,
            ComponentMapper<? extends AbsCollisionComponent> activeMapper,
            ComponentMapper<? extends AbsCollisionComponent> passiveMapper)
    {
        super(family);
        this.activeMapper = activeMapper;
        this.passiveMapper = passiveMapper;
        this.activeArea = new Rectangle();
        this.passiveArea = new Rectangle();
    }

    public abstract boolean collision(Entity aEntity, Entity pEntity);
    public abstract void init();

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        activeTransformComponent = Mapper.Transform.get(entity);
        activeCollisionComponent = activeMapper.get(entity);
        setArea(activeArea, activeTransformComponent, activeCollisionComponent);

        for (Entity passiveEntity :
                passiveEntities) {

            if(entity == passiveEntity){ continue; }

            passiveTransformComponent = Mapper.Transform.get(passiveEntity);
            passiveCollisionComponent = passiveMapper.get(passiveEntity);
            setArea(passiveArea, passiveTransformComponent, passiveCollisionComponent);

            if(activeArea.overlaps(passiveArea)){

                init();
                if(collision(entity, passiveEntity)) {
                    activeCollisionComponent.bag.e2 = passiveEntity;
                    activeCollisionComponent.collisionSignal.dispatch(activeCollisionComponent.bag);

                    passiveCollisionComponent.bag.e2 = entity;
                    passiveCollisionComponent.collisionSignal.dispatch(passiveCollisionComponent.bag);
                }
            }
        }
    }

    /**
     * Update un rectangle avec le rectangle absolue du TransformComponent et le rectangle relatif
     * du CollisionComponent
     * @param area
     * @param transformComponent
     * @param collisionComponent */
    private void setArea(
            Rectangle area,
            TransformComponent transformComponent,
            AbsCollisionComponent collisionComponent)
    {
        area.set(
                (int) (transformComponent.pos.x + collisionComponent.area.x),
                (int) (transformComponent.pos.y + collisionComponent.area.y),
                (int) (collisionComponent.area.width),
                (int) (collisionComponent.area.height)
        );
    }
}
