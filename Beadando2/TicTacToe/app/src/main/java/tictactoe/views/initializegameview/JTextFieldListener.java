package tictactoe.views.initializegameview;
import java.util.function.Consumer;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class JTextFieldListener implements DocumentListener {

    private final JTextField textField;
    private final Consumer<JTextField> textFieldAction;
    
    public JTextFieldListener(JTextField textField, Consumer<JTextField> textFieldAction)
    {
        this.textField = textField;
        this.textFieldAction = textFieldAction;
    }
            
    public void checkInput() {
        textFieldAction.accept(textField);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkInput();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkInput();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkInput();
    }
    
}
