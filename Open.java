import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Open extends AbstractAction {
	JTextArea textArea;
	JFrame window;

	public Open(JTextArea textArea, JFrame window){
		this.textArea = textArea;
		this.window = window;
	}
	
	public void actionPerformed(ActionEvent e){
		open();
	}

	public void open(){
		try {
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(window);
			TextEditor.file = fc.getSelectedFile();
			if(TextEditor.file != null)
				window.setTitle(TextEditor.file.getName() + " - Simple Text Editor");
			BufferedReader reader = new BufferedReader(new FileReader(TextEditor.file));
			String str = reader.readLine();
			textArea.setText("");
			while (str != null) {
				textArea.append(str);
				str = reader.readLine();
				if(str != null)
					textArea.append("\n");
			}
			reader.close();
		} catch(HeadlessException b){
			System.out.println("error");
			b.printStackTrace();
		} catch(FileNotFoundException c){
			System.out.println("!!file not found!!");
		} catch(IOException d){
			System.out.println("error");
			d.printStackTrace();
		} catch(NullPointerException f){
			//this gets triggered if the user hits cancel
		}
	}

}