
public enum Status {
    /*
     * Перечисление различных состояний
     */
    NONE, BORN, LIVE, DIED;

    public Status prepare(int around) {
        /*
         * DOCSTRING: Метод, содержащий условия рождения и смерти
         * INPUT: Клетки вокруг
         * OUTPUT: Состояние
         */
        switch (this) {
            case NONE:
                return (around == 3) ? BORN : NONE;
            case LIVE:
                return (around <= 1 || around > 3) ? DIED : LIVE;
            default:
                return this;
        }
    }

    public Status ready(int around) {
        /*
         * DOCSTRING: Метод, релизующий последвствия состояний рождения и смерти
         * INPUT: Клетки вокруг
         * OUTPUT: Состояние
         */
        switch (this) {
            case BORN:
                return LIVE;
            case DIED:
                return NONE;
            default:
                return this;
        }
    }

    public boolean is_alive() {
        /*
         * DOCSTRING: Метод, проверяющий состояние клетки, жива она или мертва (NONE)
         * INPUT: Нет
         * OUTPUT: Логический результат
         */
        return this == LIVE || this == DIED || this == BORN;
    }
}
