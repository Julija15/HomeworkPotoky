public class Main {
    public static void main(String[] args) {
        JoinRunnable t1 = new JoinRunnable("A");
        JoinRunnable t2 = new JoinRunnable("B");
        JoinRunnable t3 = new JoinRunnable("C");

        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        t1.start();
    }

}