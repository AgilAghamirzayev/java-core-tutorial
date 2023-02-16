package oop.abstraction.abstractc.first;

import java.awt.*;

class Mango extends Fruit {
    public Mango(Color color, boolean seasonal) {
        super(color, seasonal);
    }

    @Override
    public void prepare() {
        System.out.println("Cut the Mango");
    }
}

