package sorting_algorithims;

public class BubbleSort {
    public void bubbleSort(int[] numbers) {
        boolean numberSwitched;

        do {
            numberSwitched = false;
            for (int i = 1; i < numbers.length - 1; i++) {
                if (numbers[i - 1] < numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = temp;
                    numberSwitched = true;
                }
            }
        } while (numberSwitched);
    }
}
