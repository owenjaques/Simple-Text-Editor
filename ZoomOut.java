import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

//currently works with font bit funky

public class ZoomOut extends AbstractAction {
	JTextArea textArea;

	public ZoomOut(JTextArea textArea){
		this.textArea = textArea;
	}
	
	public void actionPerformed(ActionEvent e){
		textArea.setFont(new Font(textArea.getFont().toString(), Font.PLAIN, TextEditor.textSize -= 2));
	}
}