import java.awt.event.*;
import javax.swing.AbstractAction;

public class Exit extends AbstractAction {

	public void actionPerformed(ActionEvent e){
		System.exit(0);
	}
}