import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Box extends JPanel {
    /*
     * Данный класс отвечает за боксы и их отображение
     */
    Cell cell;

    public Box(int x, int y) {
        /*
         * DOCSTRING: Конструктор класса бокса, отвечающий за отображение ячейки и ее
         * функционал
         * INPUT: Координаты ячейки
         * OUTPUT: Нет
         */
        super();
        cell = new Cell();
        setBounds(x * Config.size, y * Config.size, Config.size, Config.size);
        setBackground(Config.get_color(Status.NONE));
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                /*
                 * DOCSTRING: Метод, благодаря которому при клике начинается жизнь в точке
                 * INPUT: -
                 * OUTPUT: Нет
                 */
                cell.turn();
            }
        });
    }

    public void set_color() {
        /*
         * DOCSTRING: Устанавливает цвет бокса
         * INPUT: Нет
         * OUTPUT: Нет
         */
        setBackground(Config.get_color(cell.status));
    }

    public void prepare() {
        /*
         * DOCSTRING: Подготавливающий ячейку к рождению
         * INPUT: Нет
         * OUTPUT: Нет
         */
        cell.prepare();
        set_color();
    }

    public void ready() {
        /*
         * DOCSTRING: Метод, обозначающий готовность ячейки к смерти
         * INPUT: Нет
         * OUTPUT: Нет
         */
        cell.ready();
        set_color();
    }
}
