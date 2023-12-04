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
    stick("Stick", "brown and sticky", 10, 1, 100, 5,0),
    dollar("Dollar", "100 cents",10, 1, 100, 5,1),
    penny("Penny", "1 cent", 10, 1, 100, 5,2),
    dime("Dime", "10 cents", 10, 1, 100, 5,3),
    quarter("Quarter", "25 cents", 10, 1, 100, 5,4),
    nickel("Nickel", "5 cents", 10, 1, 100, 5,6),
    plantpot("Plant Pot", "plants go in it", 10, 1, 100, 5,7),
    lamp("lamp", "bright!", 10, 1, 100, 5,9),
    dodgeball("Dodgeball", "dodge this", 10, 1, 100, 5,10),
    soda("sodi", "yummy", 10, 1, 100, 5,11),
    pot("pot", "for soup and waters", 10, 1, 100, 5,12),
    pan("pan", "cookin these eggs", 10, 1, 100, 5,13),
    knife("knife", "attack tool", 10, 1, 100, 5,14),
    dirt("pebble", "dirty", 10, 1, 100, 5,15),
    rock("stone", "stoney", 10, 1, 100, 5,16), 
    mug("mug", "very cup", 10, 1, 100, 5,17),
    sword("sword", "SORD!!!", 10, 1, 100, 5,18),
    lighter("lighter", "fire time", 10, 1, 100, 5,19);


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
