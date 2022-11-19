import java.util.ArrayList;

public class Cell {
    /*
     * Класс, отвечающий за ячейки
     */
    ArrayList<Cell> near;
    Status status;

    public Cell() {
        /*
         * DOCSTRING: Конструктор класса, объявляющий список ближайших ячеек
         * INPUT: Нет
         * OUTPUT: Нет
         */
        status = Status.NONE;
        near = new ArrayList<>();
    }

    void add_near(Cell cell) {
        /*
         * DOCSTRING: Метод, добавляющий ближайшую ячейку в список
         * INPUT: Ячейка
         * OUTPUT: Нет
         */
        near.add(cell);
    }

    void prepare() {
        /*
         * DOCSTRING: Метод, подготавливающий к рождению ближайшие клетки
         * INPUT: Нет
         * OUTPUT: Нет
         */
        int around = count_near_cells();
        status = status.prepare(around);
    }

    void ready() {
        /*
         * DOCSTRING: Метод, бподготавливающий к смерти ближайшие ячейки
         * INPUT: Нет
         * OUTPUT: Нет
         */
        int around = count_near_cells();
        status = status.ready(around);
    }

    int count_near_cells() {
        /*
         * DOCSTRING: Метод, считающий кол-во ближайших ячеек, которые живы
         * INPUT: Нет
         * OUTPUT: Нет
         */
        int count = 0;
        for (Cell cell : near) {
            if (cell.status.is_alive()) {
                count++;
            }
        }
        return count;
    }

    void turn() {
        /*
         * DOCSTRING: Метод, оживляющий ячейки в выбранной области при помощи ЛКМ
         * INPUT: Нет
         * OUTPUT: Нет
         */
        for (Cell cell : near)
            cell.status = cell.status.is_alive() ? Status.NONE : Status.LIVE;
    }
}
