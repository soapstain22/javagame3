import java.awt.TextField;
import java.awt.event.TextListener;

public class ChatInput extends TextField{
    String theContents = "burp";
    TextListener textListener;
    ChatInput(){
        this.setSize(180,40);
        this.setLocation(480, 400);
    }
}
