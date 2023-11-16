import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Comparator;
public abstract class GameObject extends Point2D implements Comparator<Point2D>{
    public static GameObject[][] world;
    double x;
    double y;
    double xinertia;
    double yinertia;
    int direction = 0;
    int spriteIndex =0;
    int maxDir = 1;
    int maxSpr = 1;
    BufferedImage[] face;
    final long uuid;
    static long validKeys = 0;
    void place(int x, int y){
        System.out.println("GameObject.place()");
        this.setLocation(x, y);
        Game.gameMap.addObject(this);
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
        // TODO Auto-generated method stub
        this.x = x;
        this.y = y;
        //GameMap.map[(int) x][(int) y];
    }
    public void push(int ax, int ay){
        xinertia += ax;
        yinertia += ay;
  
    }
    void update(){
        x += xinertia;
        y += yinertia;
    }
    void spriteUpdate(){
        spriteIndex +=1;
    }
    GameObject(int x, int y) throws IOException{
    this.setLocation(x, y);
        uuid = validKeys;
        validKeys +=1; 
    }
    
}
