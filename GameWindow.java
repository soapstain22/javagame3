import java.awt.Frame;

public class GameWindow extends Frame{
    Title t;
    GameWindow(boolean title){
        t = new Title();
        this.setSize(730, 470);
        this.add(t);
        this.setVisible(true);
        }
    void gameTime(){
        remove(t);
        Game.gameCamera.setLocation(0, 0);
        this.add(Game.gameCamera);
        this.add(Game.chatblob);
        this.setVisible(true);
    }
}
