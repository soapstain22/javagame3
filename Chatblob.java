import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.TextListener;

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
class ChatBrick extends TextArea {
    ChatBrick(){
        this.setSize(250,400);
        this.setLocation(480, 0);
        this.setEditable(false);
    }
    
}
class Chat {
    static void send(){
        Chatblob.chatBrick.append(Chatblob.chatInput.getText());
        
    }
    static void recieve(String msg, Player sender){

    }
}

class ChatInput extends TextField{
    String theContents = "burp";
    TextListener textListener;
    ChatInput(){
        this.setSize(180,40);
        this.setLocation(480, 400);
    }
}
