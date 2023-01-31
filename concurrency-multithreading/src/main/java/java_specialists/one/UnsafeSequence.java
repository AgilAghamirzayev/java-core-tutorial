package java_specialists.one;

public class UnsafeSequence {

    private int value;
    public int getNext() {
        return value++;
    }
}
