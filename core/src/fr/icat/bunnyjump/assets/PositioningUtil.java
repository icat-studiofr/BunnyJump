package fr.icat.bunnyjump.assets;

import com.badlogic.gdx.math.Vector2;

import fr.icat.bunnyjump.enums.MyPositions;

/**
 * Renvoi un vecteur de position pour une taille et une position demandée
 */
public final class PositioningUtil {

    private static final Vector2 temp = new Vector2(0,0);

    public static Vector2 getFor(final Vector2 areaSize, final Vector2 entitySize, final MyPositions pos){

        if(entitySize.x > areaSize.x || entitySize.y > areaSize.y) {
            throw new RuntimeException("TmpEntity ne peut être contenu dans tmpArea");
        }

        Vector2 res = new Vector2();

        if(pos.equals(MyPositions.TOP)){
            res.x = areaSize.x / 2 - entitySize.x / 2;
        }
        else if(pos.equals(MyPositions.TOP_RIGHT)){
            res.x = areaSize.x - entitySize.x;
        }
        else if(pos.equals(MyPositions.RIGHT)){
            res.x = areaSize.x - entitySize.x;
            res.y = areaSize.y / 2 - entitySize.y / 2;
        }
        else if(pos.equals(MyPositions.BOTTOM_RIGHT)){
            res.x = areaSize.x - entitySize.x;
            res.y = areaSize.y - entitySize.y;
        }
        else if(pos.equals(MyPositions.BOTTOM)){
            res.x = areaSize.x / 2 - entitySize.x / 2;
            res.y = areaSize.y - entitySize.y;
        }
        else if(pos.equals(MyPositions.BOTTOM_LEFT)){
            res.y = areaSize.y - entitySize.y;
        }
        else if (pos.equals(MyPositions.LEFT)){
            res.y = areaSize.y / 2 - entitySize.y / 2;
        }
        else if(pos.equals(MyPositions.CENTER)){
            res.x = areaSize.x / 2 - entitySize.x / 2;
            res.y = areaSize.y / 2 - entitySize.y / 2;
        }

        return res;
    }

    /*public static Vector2 getStartMovablePos(Vector3 pos, VelocityComponent vComponent){

        if(vComponent.velo.x > 0 || vComponent.velo.y > 0) {
            return getMovablePos(pos, vComponent, -1);
        } else {
            return getAlternativeMovablePos(pos, vComponent, 1);
        }
    }

    public static Vector2 getActualMovablePos(Vector3 pos, VelocityComponent vComponent){

        if(vComponent.velo.x > 0 || vComponent.velo.y > 0) {
            return getMovablePos(pos, vComponent, 1);
        } else {
            return getAlternativeMovablePos(pos, vComponent, -1);
        }
    }

    private static Vector2 getMovablePos(Vector3 pos, VelocityComponent vComponent, int ratio){

        temp.x = pos.x;
        temp.y = pos.y;

        if(vComponent != null && vComponent.distance != null){

            if(vComponent.velo.x > 0){
                temp.x += vComponent.distance.getTemp() * ratio;
            } else if(vComponent.velo.x < 0){
                temp.x += (vComponent.distance.distance - vComponent.distance.getTemp()) * ratio;
            }

            if(vComponent.velo.y > 0){
                temp.y += (vComponent.distance.getTemp()) * ratio;
            } else if(vComponent.velo.y < 0){
                temp.y += (vComponent.distance.distance - vComponent.distance.getTemp()) * ratio;
            }
        }

        return temp;
    }

    private static Vector2 getAlternativeMovablePos(Vector3 pos, VelocityComponent vComponent, int ratio){

        temp.x = pos.x;
        temp.y = pos.y;

        if(vComponent != null && vComponent.distance != null){

            if(vComponent.velo.x > 0){
                temp.x += (vComponent.distance.distance - vComponent.distance.getTemp()) * ratio;
            } else if(vComponent.velo.x < 0){
                temp.x += vComponent.distance.getTemp() * ratio;
            }

            if(vComponent.velo.y > 0){
                temp.y += (vComponent.distance.distance - vComponent.distance.getTemp()) * ratio;
            } else if(vComponent.velo.y < 0){
                temp.y += (vComponent.distance.getTemp()) * ratio;
            }
        }

        return temp;
    }*/
}
