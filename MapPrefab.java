public class MapPrefab {

    static GameTile[][] drawRoom(int x, int y, TileType wall, TileType floor){
        GameTile[][] structure = new GameTile[x][y];
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[0].length; j++) {
                if(i == 0 | i == structure.length){
                structure[i][j] = new GameTile(wall);

                }
                else
                structure[i][j] = new GameTile(floor);
            }
        }

        return structure;
    }
}
