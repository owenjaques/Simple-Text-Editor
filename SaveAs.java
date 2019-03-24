import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SaveAs extends AbstractAction {
	JTextArea textArea;
	JFrame window;

	public SaveAs(JTextArea textArea, JFrame window){
		this.textArea = textArea;
		this.window = window;
	}
	
	public void actionPerformed(ActionEvent e){
		saveAs();
	}

	public void saveAs(){
		try {
			JFileChooser fc = new JFileChooser();
			fc.setFocusable(true);
			fc.showSaveDialog(window);
			File tmpFile = TextEditor.file;
			TextEditor.file = fc.getSelectedFile();
			//checks to see if cancel was pressed avoids infinite loop
			if(TextEditor.file != null){
				Save tmp = new Save(textArea, window);
				tmp.save();
				window.setTitle(TextEditor.file.getName() + " - Simple Text Editor");
			}
			else {
				//triggered if the user hit cancel so the current file is not null
				TextEditor.file = tmpFile;
			}
		} catch(HeadlessException e){
			System.out.println("damn");
		}
	}
}