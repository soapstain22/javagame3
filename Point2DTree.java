import java.awt.geom.Point2D;
import java.util.TreeMap;

public class Point2DTree {
  static Node root;

  class Node {
    GameObject key;
    Node left;
    Node right;
    boolean red;

    Node() {
    }

    void add(GameObject g) {
      add(g, root);
    }

    void add(GameObject g, Node n) {
      if (key.x == g.x) {
        add(n, g);
      }
      if (key.x > g.x) {
        add(g, n.right);
      } else if (key.x < g.x) {
        add(g, n.left);
      }
    }

    void add(Node n, GameObject g) {
      if (key.x > left.key.x) {
        add(g, n.right);
      } else if (key.x < left.key.x) {
        add(g, n.left);
      }
    }

    GameObject getNearest(double distance, GameObject near) {
      return getNearest(distance, near, root);
    }

    GameObject getNearest(double distance, GameObject near, Node n) {
      if (n.key.x > n.right.key.x) {
        getNearest(distance, near, n.right);
      }
      if (n.key.x < n.left.key.x) {
        getNearest(distance, near, n.left);
      }
    }
  }
}