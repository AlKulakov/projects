public class Flag {
    private Matrix flagMap;



    private int totalFlaged;



    private int totalClosed;


    int totalFlags;
    int countOfClosedBoxes;

    int getTotalFlaged() {
        return totalFlaged;
    }
    int getTotalClosed() {
        return totalClosed;
    }
    void setFlagedToLastClosedBoxes(){
        for(Coord coord : Range.getAllCoords()){
            if(Box.CLOSED == flagMap.get(coord))
                setFlagedToBox(coord);
        }
    }
    void start(){
        Coord coord = new Coord(4,4);
        flagMap = new Matrix(Box.CLOSED);
        totalFlaged = 0;
        totalClosed = Range.getSquare();

    }
    Box get(Coord coord){
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        totalClosed--;
    }

    private void setFlagedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGED);
        totalFlaged++;
    }
    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
        totalFlaged--;
    }
    public void toggleFlagedToBox(Coord coord) {
        switch (flagMap.get(coord)){
            case FLAGED: setClosedToBox(coord); break;
            case CLOSED: setFlagedToBox(coord); break;
        }
    }


}
