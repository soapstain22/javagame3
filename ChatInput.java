import java.awt.TextField;

import org.junit.internal.TextListener;

public class ChatInput extends TextField{
    String theContents = "burp";
    TextListener textListener;
    ChatInput(){
        this.setSize(300, 100);
        this.setVisible(true);
    }
}
