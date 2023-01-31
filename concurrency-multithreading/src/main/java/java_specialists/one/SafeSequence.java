package java_specialists.one;

public  class SafeSequence {
    private int value;

    public synchronized int getNext() {
        return value++;
    }
}
