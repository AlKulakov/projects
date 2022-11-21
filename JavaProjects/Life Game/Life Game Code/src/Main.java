import java.io.*;

public class Main {
    /*
     * Главный класс Main, являющийся лаунчером игры
     */
    public static void main(String[] args) throws IOException {
        /*
         * DOCSTRING: Главный метод main, запускающий окно и проверяет/создает файл
         * конфигурации
         * INPUT: -
         * OUTPUT: Нет
         */
        File f = new File("conf.ini");
        if (!(f.exists() || f.isDirectory())) {
            PrintWriter writer = new PrintWriter(new FileWriter(f, true));
            writer.println("size = 20");
            writer.println("width = 40");
            writer.println("height = 60");
            writer.println("interval = 1000");
            writer.close();
        }
        Window window = new Window();
        javax.swing.SwingUtilities.invokeLater(window);
    }
}