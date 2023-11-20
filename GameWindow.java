import java.awt.Frame;

public class GameWindow extends Frame{
    GameWindow(){
        this.setSize(730, 470);
        Game.gameCamera.setLocation(0, 0);
        this.add(Game.gameCamera);
        this.add(Game.chatblob);
        this.setVisible(true);
    } 
}
