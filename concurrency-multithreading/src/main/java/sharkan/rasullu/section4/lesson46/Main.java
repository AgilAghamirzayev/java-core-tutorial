package sharkan.rasullu.section4.lesson46;

public class Main {
    public static void main(String[] args) {
        MyProducer p = new MyProducer();
        MyConsumer m1 = new MyConsumer("Ali");
        MyConsumer m2 = new MyConsumer("Vali");
        MyConsumer m3 = new MyConsumer("Tom");
        MyConsumer m4 = new MyConsumer("Jerry");
        MyConsumer m5 = new MyConsumer("Artul");

        p.start();
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
    }
}
