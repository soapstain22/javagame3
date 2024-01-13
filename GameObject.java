import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
public abstract class GameObject extends Point2D{
    double x;
    double y;
    byte subx;
    byte suby;
    double xinertia;
    double yinertia;
    int direction = 0;
    int spriteIndex = 0;
    int maxDir = 1;
    int maxSpr = 1;
    int hp = 50;
    int maxhp = 50;
    GameAction interactBehavior;
    final long uuid;
    static long validKeys = 0;
    void place(int x, int y){
        System.out.println("GameObject.place()");
        this.setLocation(x, y);
    }
    @Override
    public double getX() {
        return this.x;
    }
    @Override
    public double getY() {
        return this.y;
    }
    @Override
    public void setLocation(double x, double y) {
        Game.gameMap.getTile(x, y).objs.push(this);
        Game.gameMap.getTile(this.x, this.y).objs.remove(this);
        this.x = x;
        this.y = y;
        //GameMap.map[(int) x][(int) y];
    }
    public void push(int ax, int ay){
        subx += ax;
        suby += ay;
    }
    void update(){
        subx += xinertia;
        suby += yinertia;
        int ud = 0;
        int lr = 0;
        if (subx <16) {
            lr = 1;
        }
        if (subx >-16) {
            lr = -1;
        }
        if (suby <16) {
            ud = 1;
        }
        if (suby >-16) {
            ud = -1;
        }
        if (ud != 0 | lr != 0) {
            Game.gameMap.getTile(this.x, this.y).objs.remove(this);
            GameTile t = Game.gameMap.getTile(this.x + lr, this.y + ud);
            t.objs.add(this);
        }
        this.y += yinertia;
        this.x += xinertia;
    }
    void spriteUpdate(){
        spriteIndex +=1;
    }
    GameObject(){
        uuid = validKeys;
        validKeys +=1; 
    }
    GameObject(int x, int y){
        this();
        this.setLocation(x, y);

    }
    void Speak(String s){
        
    }
    enum ObjectType{
        tree("tree","it grows", 0),
        a("tree","it grows", 0);
        ObjectType(String name, String desc, int n){
        }
        int get(){
            return 3;
        }
    }
    public Image getImage() {
        return GameCache.items[this.spriteIndex];
    }
    protected boolean attacked(int i) {
        this.hp -= i;
        if (this.hp < 0){
            destroy();
            return true;
        }
        return false;
    }
    private void destroy(){
        Game.gameMap.getTile(this.x, this.y).objs.remove(this);
    }
}
