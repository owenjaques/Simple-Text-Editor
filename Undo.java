import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;

//needs work on the undo for cut and paste

public class Undo extends AbstractAction {
	JTextArea textArea;
	Stack<String> undoStack;

	public Undo(JTextArea textArea, Stack<String> undoStack){
		this.textArea = textArea;
		this.undoStack = undoStack;
	}
	
	public void actionPerformed(ActionEvent e){
		if(!undoStack.isEmpty()){
			textArea.setText(undoStack.pop());
		}
	}
}