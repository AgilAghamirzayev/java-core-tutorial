package sharkan.rasullu.section4.lesson46;

import java.util.UUID;

public class MyProducer extends Thread {
    @Override
    public void run() {
        while (true) {
            Base.list.add(UUID.randomUUID().toString());
        }
    }
}
