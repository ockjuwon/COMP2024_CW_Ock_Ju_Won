package frogger.model;

import javafx.scene.image.ImageView;
// resize displayed image
// an event indicating a user input
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * A class inherits ImageView.
 * has many helper methods.
 */
public abstract class Actor extends ImageView{

    /**
     * it moves using dx and dy.
     * abstracted method using getter and setter.
     * @param dx delta x
     * @param dy delta y
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }


    /**
     * @return world
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * @return width
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * @return height
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * get Intersecting objects, return as List.
     * @param cls Class
     * @param <A> Generic Type
     * @return intersecting List of class A
     */
    public <A extends Actor> List<A> getIntersectingObjects(Class<A> cls){
        var objects = getWorld().getObjects(cls);
        var filtered = objects.stream().filter(actor -> actor != this && actor.intersects(this.getBoundsInLocal()));
        ArrayList<A> someArray = filtered.collect(Collectors
                .toCollection(ArrayList::new));
        return someArray;
    }

    /**
     * get first Intersecting object of type A
     * @param cls Class
     * @param <A> Generic Type
     * @return intersecting first element of type A
     */
    public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    /**
     * loop method.
     * @param now time
     */
    public abstract void act(long now);

}
