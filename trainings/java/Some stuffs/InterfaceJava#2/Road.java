public class Road implements Runable {
    private int roadLength = 25;
    private int humanRunLimit;

    public Road(int runLimit) {
        humanRunLimit = Math.abs(runLimit);
    }

    public void run(int value) {
        if (value < humanRunLimit) {
            System.out.println("Слишком далеко!");
        } else {
            if (value > roadLength) {
                System.out.println("Преодолел!");
            } else
                System.out.println("Не преодолел!");

        }
    }
}