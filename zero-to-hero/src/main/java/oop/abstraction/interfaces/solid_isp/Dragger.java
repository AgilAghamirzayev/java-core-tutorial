package oop.abstraction.interfaces.solid_isp;

public class Dragger {
    public void drag(Draggable draggable) {
        draggable.drag();
        System.out.println("Dragging done!");
    }
}
