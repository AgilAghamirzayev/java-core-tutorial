package udemy_master_class.section_7.three.loaders;

import static udemy_master_class.section_7.three.annotations.Annotations.*;

@ScheduledExecutorClass
public class Cache {

    @ExecuteOnSchedule(periodSeconds = 5)
    @ExecuteOnSchedule(delaySeconds = 10, periodSeconds = 1)
    public static void reloadCache() {
        System.out.println("Reloading cache");
    }
}
