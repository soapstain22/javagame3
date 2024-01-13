public class MapGen {
    boolean[][] p1;
    boolean[][] p2;
    boolean[][] p3;
    int[] generate(){
        p1 = new boolean[32][32];
        p2 = new boolean[16][16];
        p3 = new boolean[8][8];
        int p1p = 0;
        int p2p = 0;
        int p3p = 0;
        fill(p1);
        fill(p2);
        fill(p3);
        int[][] f = new int[32][32];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                if (condition) {
                    
                }
            }
        }
        return f;

    }
    static void fill(boolean[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = (Math.random() > 0.5);
            }
        }
    }
}
