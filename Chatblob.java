import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;

public class Chatblob extends Panel{
    static ChatInput chatInput;
    static ChatBrick chatBrick;
    Chatblob() {
        setLayout(null);
        chatInput = new ChatInput();
        chatBrick = new ChatBrick();
        Button chatButton = new Button("Send");

        chatButton.addActionListener((ActionEvent e) -> {
            if (chatInput.getText() != "") {
               chatBrick.setText(chatBrick.getText()+chatInput.getText()+"\n");
            }
            chatInput.setText("");
        });

        chatButton.setVisible(true);
        chatButton.setLocation(480+180,400);
        chatButton.setSize(70,40);
        this.add(chatInput);
        this.add(chatBrick);
        this.add(chatButton);
        this.setVisible(true);
    }
}