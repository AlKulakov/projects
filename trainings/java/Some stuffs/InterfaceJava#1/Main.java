public class Main {
    public static void main(String[] args) {
        Jumpable[] entities = {
                new Human(), new Robot(), new Cat()
        };
        for (Jumpable entity : entities) {
            entity.jump();
        }
    }
}