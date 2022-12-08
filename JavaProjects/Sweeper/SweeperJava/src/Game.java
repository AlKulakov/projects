public class Game {
    private Bomb bomb;
    Matrix bombMap;
    private Flag flag;
    private GameState state;
    public GameState getState() {
        return state;
    }
    
    public Game (int cols, int rows, int bombCount) {
        Range.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombCount);
        flag = new Flag();
    }
    public void start(){
        bomb.start();
        flag.start();
        state = GameState.PLAYED;
    }
    public Box getBox(Coord coord){
        if (Box.OPENED == flag.get(coord))
            return bomb.get(coord);
        else return flag.get(coord);
    }
    void pressLeftButton(Coord coord){
        openBox(coord);
        checkWinner();
    }
    void pressRightButton(Coord coord){
        flag.toggleFlagedToBox(coord);
    }
    private void openBox(Coord coord){
        switch (flag.get(coord)){
            case OPENED: break;
            case FLAGED: break;
            case CLOSED:
                switch(bomb.get(coord)){
                    case ZERO: openBoxesAroundZero(coord); break;
                    case BOMB: break;
                    default: flag.setOpenedToBox(coord); break;
                }
        }
    }
    private void openBoxesAroundZero(Coord coord){
        flag.setOpenedToBox(coord);
        for(Coord around : Range.getCoordsAround(coord)){
            openBox(around);
        }
    }
    public int getTotalBombs(){
        return bomb.getTotalBombs();
    }
    public int getTotalFlaged(){
        return flag.getTotalFlaged();
    }
    private void checkWinner(){
        if(state == GameState.PLAYED){
            if (flag.getTotalClosed() == bomb.getTotalBombs()){
                state = GameState.WINNER;
                flag.setFlagedToLastClosedBoxes();
            }
        }
    }
}
