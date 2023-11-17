import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;

public class Chatblob extends Panel{
    Chatblob() {
        setLayout(null);
        ChatInput chatInput = new ChatInput();
        ChatBrick chatBrick = new ChatBrick();
        Button chatButton = new Button("Send");
        chatButton.setVisible(true);
        chatButton.setLocation(480+180,400);
        chatButton.setSize(70,40);
        this.add(chatInput);
        this.add(chatBrick);
        this.add(chatButton);
        this.setVisible(true);
    }
}