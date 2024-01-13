public enum TileType{
        water(false,0,3),
        sand(false,1,1),
        dirt(false,2,0),
        silt(false,3,0),
        clay(false,4,0),
        stone(true,5,4),
        grass(false,6,2),
        longgrass(false,8,2),
        asphalt(false,7,4),
        wood(false,9,5),
        pavement(true,10,4),
        chess(false,11,4),
        log(false,12,5),
        glass(false,12,5);

        private final boolean solid;
        private final int sprite;
        private final int sound;
        private final boolean dense;

        TileType(boolean solid, int sprite,int sound){
            this.solid = solid;
            this.sound = sound;
            this.sprite = sprite;
            this.dense = true;
        }
        TileType(boolean solid, int sprite,int sound, boolean isVisible){
            this.solid = solid;
            this.sound = sound;
            this.sprite = sprite;
            this.dense = isVisible;
        }
        public int getSound() {
            return sound;
        }
        public int getSprite() {
            return sprite;
        }
        public boolean isSolid() {
            return solid;
        }
        public boolean getDense(){
            return dense;
        }
    }
