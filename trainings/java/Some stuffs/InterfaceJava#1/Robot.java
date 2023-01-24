class Robot implements Runable, Jumpable {
    Robot() {
    }

    public void run() {
        System.out.println("Robot running...");
    }

    public void jump() {
        System.out.println("Robot jumping...");
    }
}