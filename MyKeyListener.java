import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;

public class MyKeyListener implements KeyListener {
	JTextArea textArea;
	Stack<String> undoStack;

	public MyKeyListener(JTextArea textArea, Stack<String> undoStack){
		this.textArea = textArea;
		this.undoStack = undoStack;

	}

	public void keyTyped(KeyEvent e) {
		//checks to make sure the key it is pushing is not a control key
        if((int)e.getKeyChar() >= 32)
			undoStack.push(textArea.getText());
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {

	}
}