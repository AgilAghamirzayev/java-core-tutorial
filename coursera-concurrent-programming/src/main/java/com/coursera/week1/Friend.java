package com.coursera.week1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Friend {
    private final Lock lock = new ReentrantLock();
    private final String name;

    public boolean impendingBow(Friend bower) {
        boolean myLock = Boolean.FALSE;
        boolean yourLock = Boolean.FALSE;

        try {
            myLock = lock.tryLock();
            yourLock = bower.lock.tryLock();
        } finally {
            if (!(myLock && yourLock)) {
                if (myLock) lock.unlock();
                if (yourLock) bower.lock.unlock();
            }
        }
        return myLock && yourLock;
    }

    public synchronized void bow(Friend bower) {
        if (impendingBow(bower)) {
            try {
                System.out.format("%s: %s  has bowed to me!%n", this.name, bower.getName());
                bower.bowBack(this);
            } finally {
                lock.unlock();
                bower.lock.unlock();
            }
        } else {
            System.out.format("%s: %s started  to bow to me, but saw that  I was already bowing to  him.%n",
                    this.name, bower.getName());
        }
    }

    public synchronized void bowBack(Friend bower) {
        System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
    }
}