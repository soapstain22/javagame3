import java.util.Arrays;

public class Noize {
    int[][] noise;

    Noize(int size) {
        // Create a 2D array to store the noise values.
        noise = new int[size][size];

        // Generate the noise values.
        for (int i = 0; i < noise.length; i++) {
            for (int j = 0; j < noise[i].length; j++) {
                noise[i][j] = generateNoise(i, j);
            }
        }
    }
    // Print the noise values.

    public static int generateNoise(int x, int y) {
        // Get the four corner coordinates of the current cell.
        int corner1 = x + (x % 256);
        int corner2 = x + (x % 256) + (x / 2);
        int corner3 = x + (x % 256) + (x / 2) + (x / 4);
        int corner4 = x + (x % 256) + (x / 2) + (x / 4) + (x / 8);

        // Calculate the three gradient vectors.
        int grad1 = (corner3 - corner1) / 6;
        int grad2 = (corner4 - corner2) / 6;
        int grad3 = (corner3 - corner1) / 6;
        int grad4 = (corner4 - corner2) / 6;

        // Calculate the noise value

        return grad1 + grad2 + grad3 + grad4;

    }

}
