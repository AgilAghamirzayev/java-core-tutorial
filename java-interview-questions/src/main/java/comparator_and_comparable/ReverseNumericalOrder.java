package comparator_and_comparable;

import java.util.Comparator;

public class ReverseNumericalOrder implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }

}
