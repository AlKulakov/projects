public class Game {
    private Bomb bomb;
    Matrix bombMap;
    private Flag flag;
    public Game (int cols, int rows, int bombCount) {
        Range.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombCount);
        flag = new Flag();
    }
    public void start(){
        bomb.start();
        flag.start();
    }
    public Box getBox(Coord coord){
        if (Box.OPENED == flag.get(coord))
            return bomb.get(coord);
        else return flag.get(coord);
    }
    void pressLeftButton(Coord coord){
        flag.setOpenedToBox(coord);
    }
    void pressRightButton(Coord coord){
        flag.toggleFlagedToBox(coord);
    }
}
