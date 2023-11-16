import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;

public class Chatblob extends Panel{
    Chatblob() {
        super(new GridLayout(3,3));
        setVisible(true);
        ChatInput chatInput = new ChatInput();
        ChatBrick chatBrick = new ChatBrick();
        Button chatButton = new Button("Send");
        chatButton.setVisible(true);
        chatButton.setLocation(480+180,400);
        chatButton.setSize(50,40);
        chatInput.setSize(180,40);
        chatInput.setLocation(480, 400);
        chatBrick.setSize(250,400);
        chatBrick.setLocation(480, 0);
        this.add(chatInput);
        this.add(chatBrick);
        this.add(chatButton);
        this.setLayout(null);
    }
}