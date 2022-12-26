package sharkan.rasullu.section4.lesson46;

public class MyConsumer extends Thread {
    private final String name;

    public MyConsumer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            int lastIndex = Base.list.size() - 1;
            System.out.println("Last index: " + lastIndex);
            if (lastIndex > 0) {
                String removedElement = Base.list.remove(lastIndex);
                System.out.println("Removed element: " + removedElement);
            }
        }
    }
}
