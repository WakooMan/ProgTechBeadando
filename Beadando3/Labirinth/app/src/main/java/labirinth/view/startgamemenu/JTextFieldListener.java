package labirinth.view.startgamemenu;

import java.util.function.Consumer;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Listener for JTextField changes.
 */
public class JTextFieldListener implements DocumentListener {

    private final JTextField textField; // The JTextField to listen to
    private final Consumer<JTextField> textFieldAction; // The action to perform when the text field changes

    /**
     * Constructs a new instance of JTextFieldListener.
     * @param textField The JTextField to listen to.
     * @param textFieldAction The action to perform when the text field changes.
     */
    public JTextFieldListener(JTextField textField, Consumer<JTextField> textFieldAction) {
        this.textField = textField;
        this.textFieldAction = textFieldAction;
    }

    /**
     * Checks the input and performs the specified action.
     */
    public void checkInput() {
        textFieldAction.accept(textField); // Perform the specified action using the provided text field
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        checkInput(); // Called when text is inserted into the text field
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUpdate(DocumentEvent e) {
        checkInput(); // Called when text is removed from the text field
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changedUpdate(DocumentEvent e) {
        checkInput(); // Called when the style or attributes of the text field change
    }
}
