public class Bomb {
    private Matrix bombMap;
    private int totalBombs;
    Bomb(int totalBombs){
        this.totalBombs = totalBombs;
        fixBombsCount();
    }
    public void start(){
        bombMap = new Matrix(Box.ZERO);
        for(int j = 0; j < totalBombs; j++)
            placeBomb();
    }
    Box get(Coord coord){
        return bombMap.get(coord);
    }
    private void placeBomb(){
        while (true) {
            Coord coord = Range.getRandomCoord();
            if (Box.BOMB == bombMap.get(coord))
                continue;
            bombMap.set(coord, Box.BOMB);
            incNumbsAroundBomb(coord);
            break;
        }
    }
    private void fixBombsCount() {
        int maxBombs = Range.getSize().x * Range.getSize().y/2;
        if (totalBombs > maxBombs)
            totalBombs = maxBombs;
    }
    public int getTotalBombs(){
        return totalBombs;
    }
    void incNumbsAroundBomb(Coord coord){
        for (Coord around : Range.getCoordsAround(coord))
            if(Box.BOMB != bombMap.get(around))
                bombMap.set(around, bombMap.get(around).nextNumberBox());
    }
}
