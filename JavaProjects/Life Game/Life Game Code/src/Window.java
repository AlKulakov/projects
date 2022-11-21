import javax.swing.*;
import java.awt.event.*;

public class Window implements Runnable {
    /*
     * Класс, отвечающий за содержимое окна
     */
    JFrame frame;
    Box[][] boxes;

    public void run() {
        /*
         * DOCSTRING: Метод, запускающий инициализацию рамки, боксов, таймера
         * INPUT: Нет
         * OUTPUT: Нет
         */
        initilize_frame();
        initilize_boxes();
        initilize_timer();
    }

    void initilize_frame() {
        /*
         * DOCSTRING: Метод, инициализирующий рамку
         * INPUT: Нет
         * OUTPUT: Нет
         */
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.width * Config.size + 25, Config.height * Config.size + 45);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Игра \"Жизнь\"");
        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());
    }

    void initilize_boxes() {
        /*
         * DOCSTRING: Метод, запускающий инициализацию боксов
         * INPUT: Нет
         * OUTPUT: Нет
         */
        boxes = new Box[Config.width][Config.height];
        for (int x = 0; x < Config.width; x++) {
            for (int y = 0; y < Config.height; y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }
        for (int x = 0; x < Config.width; x++)
            for (int y = 0; y < Config.height; y++)
                for (int sx = -1; sx <= +1; sx++)
                    for (int sy = -1; sy <= +1; sy++)
                        if (!(sx == 0 && sy == 0))

                            boxes[x][y].cell
                                    .add_near(boxes[(x + sx + Config.width) % Config.width][(y + sy + Config.height)
                                            % Config.height].cell);

    }

    private void initilize_timer() {
        /*
         * DOCSTRING: Метод, инициализирующий таймер
         * INPUT: Нет
         * OUTPUT: Нет
         */
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(Config.SLEEP_MS, t1);
        timer.start();
    }

    private class TimerListener implements ActionListener {
        /*
         * Вложенный класс, отвечающий за слушатель времени
         */
        boolean flop = false;

        public void actionPerformed(ActionEvent e) {
            /*
             * DOCSTRING: Метод, добавляющий временной интервал между различными состояниями
             * INPUT: -
             * OUTPUT: Нет
             */
            flop = !flop;
            for (int x = 0; x < Config.width; x++)
                for (int y = 0; y < Config.height; y++) {
                    if (flop)
                        boxes[x][y].prepare();
                    else
                        boxes[x][y].ready();
                }
        }
    }
}
