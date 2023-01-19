class threads {
    public static void main(String... args) {
        Thread th = new Thread(new MyThreads());
        th.start();
        System.out.println("Main finished");
    }
}

class NewThreads implements Runnable {
    public void run() {
        System.out.println("Test thread");
    }
}
