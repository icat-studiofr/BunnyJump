package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.components.CameraComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.WorldData;

/**
 * Created by Romain on 20/03/2016.
 */
public final class ClearSystem extends IteratingSystem{

    OrthographicCamera camera;

    public ClearSystem(OrthographicCamera camera) {
        super(Family.all(TransformComponent.class)
                .exclude(TransportableComponent.class).get());
        this.camera = camera;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        if(!checkRecursiveEntity(entity)){
            if(Mapper.Bunny.has(entity)){
                Mapper.Life.get(entity).removeLifePoint(1);
            } else {
                getEngine().removeEntity(entity);
            }
        }
    }

    private boolean checkRecursiveEntity(Entity entity){
        final TransporterComponent porter = Mapper.Transporter.get(entity);
        boolean check = checkEntity(entity);

        if(check){ return true; }

        if(porter != null){

            final Array<TransportableComponent> portables = porter.transportables.values().toArray();
            int i = 0, max = portables.size;

            while (!check && i < max){
                check = checkRecursiveEntity(portables.get(i).parent);
                i++;
            }
        }

        return check;
    }

    /**
     * Retourne false si l'entité doit etre clear
     * @param entity
     * @return
     */
    private boolean checkEntity(Entity entity){
        final TransformComponent transform = Mapper.Transform.get(entity);

        boolean notClear = true;

        if(transform.pos.y > camera.position.y + WorldData.SIZE.H / 2
                || transform.pos.x + transform.size.x < 0
                || transform.pos.x > WorldData.SIZE.W){
            notClear = false;
        }

        if(notClear
                && Mapper.Carrot.has(entity)
                && transform.pos.y + transform.size.y < camera.position.y - WorldData.SIZE.H / 2
        ){
            notClear = false;
        }

        return notClear;
    }
}
