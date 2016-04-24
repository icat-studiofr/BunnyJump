package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;

import java.util.Comparator;

public final class RenderSystem extends IteratingSystem {

    Sprite sprite;
    SpriteBatch batch;
    Array<Entity> renderableArray = new Array<Entity>();
    Comparator<Entity> zComparator;
    TransformComponent transformComp;
    TextureComponent textureComp;

    public RenderSystem(SpriteBatch batch){
        super(Family.all(TransformComponent.class, TextureComponent.class).get());
        this.batch = batch;
        this.sprite = new Sprite();

        zComparator = new Comparator<Entity>() {
            @Override public int compare(Entity e1, Entity e2) {
                return (int)Math.signum(Mapper.Transform.get(e1).pos.z
                        - Mapper.Transform.get(e2).pos.z);
            }
        };
    }

    @Override
    public void update(float deltaTime) {

        super.update(deltaTime);

        renderableArray.sort(zComparator);

        batch.begin();

        for (Entity e :
                renderableArray)
        {
            textureComp = Mapper.Texture.get(e);
            transformComp = Mapper.Transform.get(e);

            sprite.setRegion(textureComp.texture);
            sprite.setBounds(
                    transformComp.pos.x,
                    transformComp.pos.y,
                    transformComp.size.x,
                    transformComp.size.y);
            sprite.setRotation(transformComp.rotation);
            sprite.setScale(transformComp.scale.x, transformComp.scale.y);
            sprite.flip(transformComp.flipX, false);


            sprite.draw(batch);
        }

        batch.end();

        renderableArray.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderableArray.add(entity);
    }
}
