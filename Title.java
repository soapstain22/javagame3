import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Panel;

import javax.swing.JCheckBox;

public class Title extends Panel {

    int state = 0;
    Panel multiplayerConnect;
    Panel multiplayerHost;
    Panel settingsPanel;
    Panel newGamePanel;
    Panel load;

    Title() {
        multiplayerConnect = multiplayerConnectPanel();
        multiplayerHost = multiplayerHostPanel();
        settingsPanel = settingsPanel();
        newGamePanel = newGamePanel();
        load = new Panel();
        this.add(mainMenu());
        this.setSize(730, 470);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(GameCache.splash, 0, 0, this);
        g.drawImage(GameCache.title, 200, 100, this);

        super.paint(g);
    }

    void menu(int i) {
        switch (i) {
            case 1:
                multiplayerConnect.setVisible(true);
                break;
            case 2:
                Game.gw.gameTime();
                break;
            case 3:
                load.setVisible(true);
                break;
            case 4:
                multiplayerConnect.setVisible(true);
                break;
            case 5:
                multiplayerConnect.setVisible(true);
                break;
            default:
                break;
        }

    }

    Panel settingsPanel() {
        Panel p = new Panel();
        Checkbox cb = new Checkbox("shit self");
        p.add(cb);
        cb.setVisible(true);
        return p;

    }

    Panel newGamePanel() {
        
        return load;

    }

    Panel multiplayerHostPanel() {
        Panel p = new Panel();
        List availableServers = new List(4);
        availableServers.setSize(500, 500);
        NetCon.getServers();
        return p;
    }

    Panel multiplayerConnectPanel() {
        return load;

    }

    Panel mainMenu() {
        Panel p = new Panel();
        Button newGame;
        Button loadGame;
        Button joinMultiplayer;
        Button hostMultiplayer;
        Button settings;
        joinMultiplayer = new Button();
        joinMultiplayer.setSize(40, 20);
        joinMultiplayer.setLabel("Join");
        joinMultiplayer.addActionListener(e -> menu(1));
        joinMultiplayer.setLocation(10, 30);
        newGame = new Button();
        newGame.setSize(40, 20);
        newGame.setLabel("New Game");
        newGame.addActionListener(e -> menu(2));
        newGame.setLocation(10, 30);
        loadGame = new Button();
        loadGame.setSize(40, 20);
        loadGame.setLabel("Load Game");
        loadGame.addActionListener(e -> menu(3));
        loadGame.setLocation(10, 50);
        settings = new Button();
        settings.setSize(40, 20);
        settings.setLabel("Settings");
        settings.addActionListener(e -> menu(4));
        settings.setLocation(10, 70);
        hostMultiplayer = new Button();
        hostMultiplayer.setSize(40, 20);
        hostMultiplayer.setLabel("Host Game");
        hostMultiplayer.addActionListener(e -> menu(5));
        hostMultiplayer.setLocation(10, 90);
        p.add(newGame);
        newGame.setVisible(true);
        p.add(loadGame);
        loadGame.setVisible(true);
        p.add(joinMultiplayer);
        joinMultiplayer.setVisible(true);
        p.add(hostMultiplayer);
        hostMultiplayer.setVisible(true);
        p.add(settings);
        settings.setVisible(true);
        return p;

    }
    Panel loadGame(){
        Panel p = new Panel();
        List l;
        if (GameCache.saves!= null) {
            l = (List) GameCache.saves;
            p.add(l);
        }
        return p;
    }
}
