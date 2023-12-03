import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;

public class GamePanel extends Frame{
    Button connect = new Button();
    Button spawn = new Button();
    List items = new List();
    GamePanel(){

        spawn.addActionListener((ActionEvent e) -> {
            ItemType itemType;
            switch (items.getSelectedIndex()) {
                case 1:
                    itemType = ItemType.stick;
                    break;
                case 2:
                    itemType = ItemType.sword;
                    break;            
                case 3:
                    itemType = ItemType.mug;
                    break;
                case 4:
                    itemType = ItemType.lighter;
                    break;
                case 5:
                    itemType = ItemType.soda;
                    break;
                case 6:
                    itemType = ItemType.dodgeball;
                    break;
                case 7:
                    itemType = ItemType.dollar;
                    break;
                case 8:
                    itemType = ItemType.nickel;
                    break;
                case 9:
                    itemType = ItemType.penny;
                    break;
                case 10:
                    itemType = ItemType.quarter;
                    break;
                case 11:
                    itemType = ItemType.pot;
                    break;
                case 13:
                    itemType = ItemType.pan;
                    break;
                case 12:
                    itemType = ItemType.knife;
                    break;
                case 14:
                    itemType = ItemType.knife;
                    break;
                                    default:

                    itemType = ItemType.quarter;
                    break;
            }
            Game.gameMap.spawn(itemType);
        });

        this.setSize(400,560);
        this.setVisible(true);
        this.add(spawn);
        this.add(items);
        items.setSize(100,100);  
        items.setLocation(0,100);
        items.setVisible(true);      
        spawn.setSize(100,30);
        spawn.setVisible(true);
        spawn.setLocation(0,70);
        items.add("stick");
        items.add("sword");
        items.add("mug");
        items.add("lighter");
        items.add("soda");
        items.add("dodgeball");
        items.add("dollar");
        items.add("nickel");
        items.add("penny");
        items.add("quarter");
        items.add("pot");
        items.add("pan");
        items.add("knife");
        items.add("hammer");
        items.add("shovel");
        items.add("screwdriver");
        items.add("wrench");
        items.add("rock");
        items.add("brick");

    }
    
}
