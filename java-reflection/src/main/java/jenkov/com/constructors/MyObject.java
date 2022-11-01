package jenkov.com.constructors;

public class MyObject {
    private final String street;

    public MyObject(String street) {
        this.street = street;
    }


    @Override
    public String toString() {
        return String.format("MyObject [street: %s]", street);
    }
}
