class Human implements Runable, Jumpable {
    Human() {
    }

    public void run() {
        System.out.println("Human running...");
    }

    public void jump() {
        System.out.println("Human jumping...");
    }
}