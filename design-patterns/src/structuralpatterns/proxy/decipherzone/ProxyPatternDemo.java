package structuralpatterns.proxy.decipherzone;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Video video = new ProxyVideo("test.mp4");

        video.display();
        System.out.println();

        video.display();
    }
}
