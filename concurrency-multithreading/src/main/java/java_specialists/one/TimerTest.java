package java_specialists.one;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000, 1000);
    }
}
