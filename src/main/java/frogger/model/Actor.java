package frogger.model;

import javafx.scene.image.ImageView;
// resize displayed image
// an event indicating a user input
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public abstract class Actor extends ImageView{

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends Actor> List<A> getIntersectingObjects(Class<A> cls){
        var objects = getWorld().getObjects(cls);
        var filtered = objects.stream().filter(actor -> actor != this && actor.intersects(this.getBoundsInLocal()));
        ArrayList<A> someArray = filtered.collect(Collectors
                .toCollection(ArrayList::new));
        return someArray;
    }

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

    public abstract void act(long now);

}
