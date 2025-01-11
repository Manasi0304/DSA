import java.util.concurrent.Semaphore;
import java.util.*;

public class Que11 {
    static class Philosopher extends Thread {
        private final int id;
        private final Semaphore leftFork;
        private final Semaphore rightFork;

        public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        private void think() throws InterruptedException {
            System.out.println("Philosopher " + id + " is thinking.");
            Thread.sleep((int) (Math.random() * 100));
        }

        private void eat() throws InterruptedException {
            System.out.println("Philosopher " + id + " is eating.");
            Thread.sleep((int) (Math.random() * 100));
        }

        @Override
        public void run() {
            int eatCount = 0;
            int maxEatCount = 3; 

            while (eatCount < maxEatCount) {
                try {
                    think();

                    if (id % 2 == 0) {
                        leftFork.acquire();
                        System.out.println("Philosopher " + id + " picked up left fork.");
                        rightFork.acquire();
                        System.out.println("Philosopher " + id + " picked up right fork.");
                    } else {
                        rightFork.acquire();
                        System.out.println("Philosopher " + id + " picked up right fork.");
                        leftFork.acquire();
                        System.out.println("Philosopher " + id + " picked up left fork.");
                    }

                    eat();
                    eatCount++;

                    // Put down forks
                    leftFork.release();
                    System.out.println("Philosopher " + id + " put down left fork.");
                    rightFork.release();
                    System.out.println("Philosopher " + id + " put down right fork.");

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Philosopher " + id + " was interrupted.");
                }
            }
            System.out.println("Philosopher " + id + " has finished eating.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of philosophers : ");
        int numPhilosophers = sc.nextInt();
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Semaphore[] forks = new Semaphore[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }

        for (int i = 0; i < numPhilosophers; i++) {
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i + 1) % numPhilosophers];
            philosophers[i] = new Philosopher(i, leftFork, rightFork);
            philosophers[i].start();
        }
    }
}
