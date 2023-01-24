class Main {
    public static void main(String... args) {
        Runable firstRunner = new Road(30);
        firstRunner.run(35);
        Jumpable firstJumper = new Wall(20);
        firstJumper.jump(15);
    }
}