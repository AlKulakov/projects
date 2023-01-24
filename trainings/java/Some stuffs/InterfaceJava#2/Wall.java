public class Wall implements Jumpable {
    private int wallHeight = 20;
    private int humanJumpLimit;

    public Wall(int jumpLimit) {
        humanJumpLimit = Math.abs(jumpLimit);
    }

    public void jump(int value) {
        if (value < humanJumpLimit) {
            System.out.println("Слишком высоко!");
        } else {
            if (value > wallHeight) {
                System.out.println("Перепрыгнул!");
            } else
                System.out.println("Не перепрыгнул!");

        }
    }
}
