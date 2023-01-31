package abstraction.abstractc.first;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AbstractClassDemo {
    public static void main(String[] args) {
        Fruit mango = new Mango(Color.YELLOW, true); // mango is seasonal
        Fruit banana = new Banana(Color.YELLOW, false);

        List<Fruit> platter = new ArrayList<>();
        platter.add(mango);
        platter.add(banana);
        serve(platter);

    }

    public static void serve(Collection<Fruit> fruits) {
        System.out.println("Preparing fruits to serve");
        for (Fruit f : fruits) {
            f.prepare();
        }
    }

}
