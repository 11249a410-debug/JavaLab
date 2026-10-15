// Ex 5(a): the two ways of creating a thread
class First extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread A : " + i);
        }
    }
}

class Second implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread B : " + i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        First a = new First();
        Thread b = new Thread(new Second());

        a.start();
        b.start();
    }
}

// Ex 5(b): synchronized protects the shared counter
class Counter {
    private int count = 0;

    synchronized void increment() {
        count++;
    }

    int get() {
        return count;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Runnable job = () -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(job);
        Thread t2 = new Thread(job);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count = " + c.get());
    }
}

//case study
class Seats {
    private int available = 10;

    synchronized void book(String counter) {
        if (available > 0) {
            available--;
            System.out.println(
                counter + " booked seat. Left = " + available
            );
        } else {
            System.out.println(counter + " -> HOUSE FULL");
        }
    }
}

public class Booking {
    public static void main(String[] args) throws InterruptedException {
        Seats s = new Seats();

        Thread[] threads = new Thread[3];

        for (int i = 1; i <= 3; i++) {
            String name = "Counter-" + i;

            threads[i - 1] = new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    s.book(name);
                }
            });

            threads[i - 1].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Booking process completed.");
    }
}
