import java.util.Arrays;
import java.util.Random;

public class Noize {
    int[][] noise;
    int size = 30;
    int crazy = 0;
    Noize(int size) {
        noise = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                noise[i][j] = doubleOrNothing(crazy);
            }
        }
    }
    int doubleOrNothing(int i){
        return doubleOrNothing(i,1);
    }
    int doubleOrNothing(int i, int j){
        if (((int)Math.random() + 0.5) >= 1) {
            return doubleOrNothing(i,j+1);
        }
        return j;
    }
}