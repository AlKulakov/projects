public class Matrix {
    private Box[][] matrix;
    Matrix(Box box) {
        matrix = new Box [Range.getSize().x][Range.getSize().y];
        for(Coord coord : Range.getAllCoords()){
            matrix[coord.x][coord.y] = box;
        }
    }
    Box get (Coord coord){
        if(Range.inRange(coord))
            return matrix[coord.x][coord.y];
        else return null;
    }
    void set(Coord coord, Box box){
        if(Range.inRange(coord))
            matrix[coord.x][coord.y] = box;
    }
}
