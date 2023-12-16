import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JCheckBox;
import javax.swing.LayoutStyle;

public class Title extends Panel {

    int state = 0;
    Panel multiplayer;
    Panel settingsPanel;
    Panel newGamePanel;
    Panel load;
    Panel mainMenu;

    Title() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints g = new GridBagConstraints();

        mainMenu = mainMenu();
        mainMenu.setVisible(true);
        this.add(mainMenu);

        multiplayer = multiplayerConnectPanel();
        multiplayer.setVisible(true);
        this.add(multiplayer);

        settingsPanel = settingsPanel();
        settingsPanel.setVisible(false);
        this.add(settingsPanel);

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
                multiplayer.setVisible(true);
                break;
            case 2:
                Game.gw.gameTime();
                break;
            case 3:
                load.setVisible(true);
                break;
            case 4:
                settingsPanel.setVisible(true);
                break;
            default:
                break;
        }

    }

    Panel settingsPanel() {
        Panel p = new Panel();
        Checkbox cb = new Checkbox("shit self");
        Checkbox dev = new Checkbox("shit self");
        Checkbox controls = new Checkbox("shit self");

        p.setVisible(true);
        p.setSize(500, 300);
        p.setLocation(10, 10);
        p.add(cb);
        cb.setVisible(true);
        controls.setVisible(true);

        return p;

    }

    Panel newGamePanel() {

        return load;

    }

    Panel multiplayerHostPanel() {
        Panel p = new Panel();

        return p;
    }

    Panel multiplayerConnectPanel() {
        Button refresh = new Button();
        refresh.setLabel("Refresh");
        Button host = new Button();
        host.setLabel("host");
        TextField serverName = new TextField();
        serverName.setName("server name");
        Panel p = new Panel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.setLocation(200, 200);
        this.setVisible(true);
        List availableServers = new List(4);
        NetCon.getServers();
        availableServers.setVisible(true);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        p.add(host, c);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        p.add(serverName, c);
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        p.add(refresh, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40; // make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        p.add(availableServers, c);
        p.setSize(500, 300);

        return p;
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

    Panel loadGame() {
        Panel p = new Panel();
        List l;

        if (GameCache.saves != null) {
            l = (List) GameCache.saves;
            p.add(l);
        }
        return p;
    }
}
