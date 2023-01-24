class Cat implements Runable, Jumpable {
    Cat() {
    }

    public void run() {
        System.out.println("Cat running...");
    }

    public void jump() {
        System.out.println("Cat jumping...");
    }
}