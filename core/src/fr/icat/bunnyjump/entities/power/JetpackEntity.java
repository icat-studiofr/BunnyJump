package fr.icat.bunnyjump.entities.power;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.JetpackData;
import fr.icat.bunnyjump.entities.asset.FlameEntity;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.listeners.transform.MoveListener;

/**
 * Created by Romain on 11/04/2016.
 */
public final class JetpackEntity extends Entity {

    public JetpackEntity(){

        final TransformComponent transformComponent
                = new TransformComponent(this, JetpackData.Z, JetpackData.SIZE.JETPACK);
        transformComponent.moveSignal.add(MoveListener.inst());

        this.add(new TextureComponent(MyRegions.jetpack.getRegion()))
                .add(transformComponent)
                .add(new TransportableComponent(this, JetpackData.TRANSPORTABLE.JETPACK));

        final TransporterComponent transporter = new TransporterComponent(this);
        transporter.add(JetpackData.TRANSPORTER.FLAME1,
                Mapper.Transportable.get(new FlameEntity(JetpackData.TRANSPORTABLE.FLAME1)));
        transporter.add(JetpackData.TRANSPORTER.FLAME2,
                Mapper.Transportable.get(new FlameEntity(JetpackData.TRANSPORTABLE.FLAME2)));

        this.add(transporter);
    }

}
