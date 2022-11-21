import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    /*
     * Класс, реализующий конфигурацию в виде размера, ширины, высоты и интервала
     * ожидания, а также цвета
     */
    public static int size;
    public static int width;
    public static int height;
    public static int SLEEP_MS;

    static {
        /*
         * DOCSTRING: Статическая версия конструктора, в которой происходит чтение и
         * присвоение параметров конфигурации
         * INPUT: Нет
         * OUTPUT: Нет
         */
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File("conf.ini")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        size = Integer.valueOf(props.getProperty("size", "20"));
        width = Integer.valueOf(props.getProperty("width", "40"));
        height = Integer.valueOf(props.getProperty("height", "30"));
        SLEEP_MS = Integer.valueOf(props.getProperty("interval", "10"));
    }

    public static Color get_color(Status status) {
        /*
         * DOCSTRING: Метод, устанавливающий различные цвета для каждого состояния
         * ячейки
         * INPUT: Состояние
         * OUTPUT: Цвет
         */
        Color brown = new Color(156, 98, 36);
        Color greeny = new Color(25, 120, 11);
        Color lime = new Color(44, 201, 20);
        Color dark_green = new Color(13, 61, 6);

        switch (status) {
            default:
            case NONE:
                return brown;
            case LIVE:
                return greeny;
            case DIED:
                return dark_green;
            case BORN:
                return lime;
        }

    }

}
