public class MapPrefab {
    GameTile[][] structure;
    MapPrefab(int type){
        switch (type) {
            case 1:
                drawRoom(20, 10, 1, 2);
                break;
        
            default:
                break;
        }
    }

    GameTile[][] drawRoom(int x, int y, int wall, int floor){
        GameTile[][] structure = new GameTile[x][y];
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[0].length; j++) {
                structure[j][i] = new GameTile(floor);
            }
        }
        for (int i = 0; i < structure.length; i++) {
            structure[0][i] = new GameTile(wall);
            structure[x][i] = new GameTile(wall);
        }
        for (int i = 0; i < structure[0].length; i++) {
            structure[i][0] = new GameTile(wall);
            structure[i][x] = new GameTile(wall);
        }
        return structure;
    }
}
