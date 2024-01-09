package org.example.week1;

import java.util.concurrent.RecursiveAction;
import lombok.Getter;

@Getter
public class ASum extends RecursiveAction {
    private final int[] A; // input array
    private final int LO, HI; // subrange
    private double SUM; // return value

    public ASum(int[] a, int lo, int hi) {
        A = a;
        LO = lo;
        HI = hi;
    }

    @Override
    protected void compute() {
        if (LO == HI) SUM = A[LO];
        else if (LO > HI) SUM = 0;
        else {
            int MID = (LO + HI) / 2;
            ASum L = new ASum(A, LO, MID);
            ASum R = new ASum(A, MID + 1, HI);
            L.fork();
            R.compute();
            L.join();
            SUM = L.SUM + R.SUM;
        }
    }
}
