import java.awt.TextArea;
import java.awt.TextField;

import org.junit.internal.TextListener;

public class ChatInput extends TextField{
    String theContents = "burp";
    java.awt.event.TextListener textListener;
    ChatInput(){
        this.setSize(300, 100);
        this.setVisible(true);
        this.addTextListener(textListener);
    }

    
}
