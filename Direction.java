public abstract class Direction {

    public final static int[][] spriteMatrix={
        {1,2,3}, //sorry its unreadable, its to make the sprites easier to index for directions
        {0,0,4},
        {7,6,5}
    };
    static int toInt(int x, int y){
        System.out.println(spriteMatrix[x]);
        return spriteMatrix[x][y];
    }
}