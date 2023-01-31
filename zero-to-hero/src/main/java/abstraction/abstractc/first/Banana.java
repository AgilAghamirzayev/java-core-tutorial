package abstraction.abstractc.first;

import java.awt.*;

class Banana extends Fruit {
    public Banana(Color color, boolean seasonal) {
        super(color, seasonal);
    }

    @Override
    public void prepare() {
        System.out.println("Peal the Banana");
    }
}