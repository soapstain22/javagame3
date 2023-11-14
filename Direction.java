public abstract class Direction {

    public final static int[][] spriteMatrix={
        {1,0,7}, //sorry its unreadable, its to make the sprites easier to index for directions
        {2,8,6},
        {3,4,5}
    };
    static int toInt(int x, int y){
        System.out.println(spriteMatrix[x]);
        return spriteMatrix[x][y];
    }
}