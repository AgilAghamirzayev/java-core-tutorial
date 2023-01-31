package abstraction.abstractc.first;

import java.awt.*;

abstract class Fruit {
    private Color color;
    private boolean seasonal;

    public Fruit(Color color, boolean seasonal) {
        this.color = color;
        this.seasonal = seasonal;
    }

    public abstract void prepare();

    public Color getColor() {
        return color;
    }

    public boolean isSeasonal() {
        return seasonal;
    }
}

