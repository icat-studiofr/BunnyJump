package fr.icat.bunnyjump.entities.monsters;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.MonsterComponent;

/**
 * Created by Romain on 24/03/2016.
 */
public abstract class AbsMonsterEntity extends Entity{

    public AbsMonsterEntity(){
        init();
    }

    private void init(){

        this.add(new MonsterComponent());
    }

}
