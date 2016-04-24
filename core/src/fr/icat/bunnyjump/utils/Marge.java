package fr.icat.bunnyjump.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Romain on 21/03/2016.
 */
public final class Marge {

    public int left, top, right, bottom;

    public Marge(){
        this(0, 0, 0, 0);
    }

    public Marge(int left, int top, int right, int bottom){
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public Rectangle merge(final Rectangle rectangle){
        Rectangle merge = new Rectangle(rectangle);
        return privMerge(merge);
    }

    public Rectangle merge(final Vector3 pos, final Vector2 size) {
        Rectangle merge = new Rectangle(pos.x, pos.y, size.x, size.y);
        return privMerge(merge);
    }

    private Rectangle privMerge(final Rectangle merge){
        merge.x -= this.left;
        merge.y -= this.top;
        merge.width += this.left + this.right;
        merge.height += this.top + this.bottom;
        return merge;
    }

}
