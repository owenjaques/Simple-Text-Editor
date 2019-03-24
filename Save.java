import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.io.BufferedWriter;

public class Save extends AbstractAction {
	JTextArea textArea;
	JFrame window;

	public Save(JTextArea textArea, JFrame window){
		this.textArea = textArea;
		this.window = window;
	}

	public void actionPerformed(ActionEvent e){
		save();
	}

	public void save(){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(TextEditor.file));
			writer.write(textArea.getText());
			writer.close();
		} catch(IOException b){
			System.out.println("shoot");
			b.printStackTrace();
		} catch(NullPointerException c){
			//this will be triggered if the file it is attempting to save does not exist
			SaveAs tmp = new SaveAs(textArea, window);
			tmp.saveAs();
		}
	}
}