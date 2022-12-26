package structuralpatterns.proxy.decipherzone;

public class RealVideo implements Video{
    private final String fileName;

    public RealVideo(String fileName) {
        this.fileName = fileName;
        loadFromDisc(fileName);
    }

    private void loadFromDisc(String fileName) {
        System.out.println("Loading " + fileName + " ...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName + " ...");
    }
}
