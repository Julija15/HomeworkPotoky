public class JoinRunnable extends Thread {
    private String name;
    boolean valueSet = false;

    public JoinRunnable(String name) {
        super(name);
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThreadName + " is running!" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(currentThreadName + " completed");
    }

    public synchronized String get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Пoлyчeнo: " + name);
        valueSet = false;
        notify();
        return getName();
    }
}

