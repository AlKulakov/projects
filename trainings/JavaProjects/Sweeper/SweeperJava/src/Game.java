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
    void pressLeftButton(Coord coord) {
        if (isGameOver())
            return;
        openBox(coord);
        checkWinner();
    }
    void pressRightButton(Coord coord){
        if (isGameOver())
            return;
        flag.toggleFlagedToBox(coord);
    }
    private boolean isGameOver(){
        if (GameState.PLAYED != state){
            start();
            return true;
        }
        return false;
    }
    private void openBox(Coord coord){
        switch (flag.get(coord)){
            case OPENED: setOpenedToClosedBoxesAroundNumber(coord);break;
            case FLAGED: break;
            case CLOSED:
                switch(bomb.get(coord)){
                    case ZERO: openBoxesAroundZero(coord); break;
                    case BOMB: openBombs(coord); break;
                    default: flag.setOpenedToBox(coord); break;
                }
        }
    }

    private void setOpenedToClosedBoxesAroundNumber(Coord coord) {
        if(Box.BOMB != bomb.get(coord))
            if(bomb.get(coord).getNumber() == flag.getCountOfFlagedBoxesAround(coord))
                for (Coord around : Range.getCoordsAround(coord))
                    if(flag.get(around) == Box.CLOSED)
                        openBox(around);
    }

    private void openBombs(Coord bombedCoord){
        flag.setBombedToBox(bombedCoord);
        for (Coord coord : Range.getAllCoords())
            if(bomb.get(coord)==Box.BOMB)
                flag.setOpenedToClosedBox(coord);
            else
                flag.setNoBombToFlagedBox(coord);
        state = GameState.BOMBED;
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
