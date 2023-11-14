import java.awt.geom.Point2D;

public class ObjectTree {
    ObjectTree root;
    Point2D ref;
    GameObject go;
    ObjectTree left;
    ObjectTree right;
    void add(Point2D g){
        switch (Double.compare(g.getX(), ref.getX())) {
            case -1:
                right.position(g, left);
                break;
            case 0:
                
                break;
            case 1:
                right.position(g, right);
                break;
            default:
                break;
        }
    }
    private void position(Point2D g, ObjectTree t){
        switch (Double.compare(g.getY(), ref.getY())) {
            case -1:
                t.left.add(g);

                break;
            case 0:
                
                break;
            case 1:
                t.right.add(g);

                break;
            default:
                break;
        }
    }
    ObjectTree(Player p){
        add(p);
    }
    GameObject getNearest(Point2D x){
        //root.left.ref;
        //root.right.ref;
        return null;
    }
}
