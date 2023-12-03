import java.awt.Image;
import java.awt.image.BufferedImage;

public class Item {
 // this is going to be a problem later, as each object will create a new string for a name that already exists
    String desc;
    String name;
    int throwdist;
    int count;
    int type;
    int maxStack;
    int damage;
    int sprite = 0;
    public int yoffset = 0;
    public int xoffset = 0;
    Item(ItemType itemType){
        this.name = itemType.getName();
        this.desc = itemType.getDesc();
        this.throwdist = itemType.getThrowdist();
        this.count = itemType.getCount();
        this.maxStack = itemType.getMaxStack();
        this.damage = itemType.getDamage();
        this.sprite = itemType.getSprite();
    }
}
enum ItemType {
    stick("Stick", "brown and sticky", 10, 1, 100, 5,1),
    dollar("Dollar", "100 cents",10, 1, 100, 5,2),
    penny("Penny", "1 cent", 10, 1, 100, 5,3),
    dime("Dime", "10 cents", 10, 1, 100, 5,4),
    quarter("Quarter", "25 cents", 10, 1, 100, 5,5),
    nickel("Nickel", "5 cents", 10, 1, 100, 5,6),
    plantpot("Plant Pot", "item", 10, 1, 100, 5,7),
    lamp("lamp", "item", 10, 1, 100, 5,9),
    dodgeball("Dodgeball", "item", 10, 1, 100, 5,10),
    soda("sodi", "brown and sticky", 10, 1, 100, 5,11),
    pot("pot", "brown and sticky", 10, 1, 100, 5,12),
    pan("pan", "brown and sticky", 10, 1, 100, 5,13),
    knife("knife", "brown and sticky", 10, 1, 100, 5,14),
    dirt("pebble", "brown and sticky", 10, 1, 100, 5,15),
    rock("stone", "brown and sticky", 10, 1, 100, 5,16), 
    mug("mug", "brown and sticky", 10, 1, 100, 5,17),
    sword("stone", "brown and sticky", 10, 1, 100, 5,18),
    lighter("stone", "brown and sticky", 10, 1, 100, 5,19);


    private final String name;
    private final String desc;
    private final int throwdist;
    private final int count;
    private final int maxStack;
    private final int damage;
    private final int sprite;
    ItemType(String name, String desc, int throwdist, int count, int maxStack, int damage, int sprite) {
        this.desc = desc;
        this.name = name;
        this.throwdist = throwdist;
        this.count = count;
        this.maxStack = maxStack;
        this.damage = damage;
        this.sprite = sprite;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public int getThrowdist() {
        return throwdist;
    }

    public int getCount() {
        return count;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getDamage() {
        return damage;
    }
    public int getSprite() {
        return sprite;
    }
    public BufferedImage getImage() {
        return GameCache.items[sprite];
    }
}
