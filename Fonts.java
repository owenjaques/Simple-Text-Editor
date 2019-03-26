import java.awt.Font;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Fonts implements ListSelectionListener {
	JList<String> fontList;
	JTextArea textArea;

	public Fonts(JList<String> fontList, JTextArea textArea) {
		this.fontList = fontList;
		this.textArea = textArea;
	}

	public void valueChanged(ListSelectionEvent e) {
		textArea.setFont(new Font(fontList.getSelectedValue(), Font.PLAIN, 14));
	}

}