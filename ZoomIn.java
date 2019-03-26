import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

//currently works with font bit funky

public class ZoomIn extends AbstractAction {
	JTextArea textArea;

	public ZoomIn(JTextArea textArea){
		this.textArea = textArea;
	}
	
	public void actionPerformed(ActionEvent e){
		textArea.setFont(new Font(textArea.getFont().toString(), Font.PLAIN, TextEditor.textSize += 2));
	}
}