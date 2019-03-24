import javax.swing.*;
import java.awt.event.*;

public class NewFile extends AbstractAction {
	JTextArea textArea;
	JFrame window;

	public NewFile(JTextArea textArea, JFrame window){
		this.textArea = textArea;
		this.window = window;
	}

	public void actionPerformed(ActionEvent e){
			TextEditor.file = null;
			textArea.setText("");
			window.setTitle("new.txt" + " - Simple Text Editor");
	}
}