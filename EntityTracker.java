public class EntityTracker {
    int depth = 0;
    static EntityTracker root = new EntityTracker();
    EntityTracker r = new EntityTracker();
    EntityTracker l = new EntityTracker();
    GameObject me;
    boolean dnjojnovfnjofvjnofsvnjodvsjnodsvwnjvsbjnvdsjnodsvjni0sdvo0nsdvoknjvdsjno;

    // i have no idea how anything works and i cant say its my fault. here goes nothing!!!!!!!!!
    void add(GameObject g){
        if(g.x > r.me.x){
            r.add(g,0);;
        }
        if(g.x < r.me.x){
            l.add(g,0);;
        }
    }
    private void add(GameObject g, int i){
        if(g.x > r.me.x){
            r.add(g);;
        }
        if(g.x < r.me.x){
            l.add(g);
        }
    }
}