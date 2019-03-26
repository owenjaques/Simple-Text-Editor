/*
 * Made by Owen Jaques
 * 2019/03/23
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.DefaultEditorKit;
import java.util.Stack;

public class TextEditor {
	//TODO add getters setters for these two
	public static File file = null;
	public static int textSize = 14;

	public static void main(String [] args){
		JFrame window = new JFrame("new.txt - Simple Text Editor");
		Font font = new Font("Calibri", Font.PLAIN, textSize);
		ImageIcon icon = new ImageIcon("icon.png");//cat image
		Stack<String> undoStack = new Stack<String>();

		JTextArea textArea = new JTextArea();
		KeyListener keyListener = new MyKeyListener(textArea, undoStack);
		textArea.addKeyListener(keyListener);
		textArea.setTabSize(4);
		textArea.setFont(font);

		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu("File");
		
		JMenuItem fileNew = new JMenuItem("New");
		fileNew.addActionListener(new NewFile(textArea, window));
		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));

		JMenuItem fileSave = new JMenuItem("Save");
		fileSave.addActionListener(new Save(textArea, window));
		fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

		JMenuItem fileSaveAs = new JMenuItem("Save As...");
		fileSaveAs.addActionListener(new SaveAs(textArea, window));

		JMenuItem fileOpen = new JMenuItem("Open...");
		fileOpen.addActionListener(new Open(textArea, window));
		fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));

		JMenuItem fileExit = new JMenuItem("Exit");
		fileExit.addActionListener(new Exit());

		menuFile.add(fileNew);
		menuFile.add(fileOpen);
		menuFile.add(fileSave);
		menuFile.add(fileSaveAs);
		menuFile.add(fileExit);

		JMenu menuEdit = new JMenu("Edit");

		JMenuItem editUndo = new JMenuItem("Undo");
		editUndo.addActionListener(new Undo(textArea, undoStack));
		editUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));

		JMenuItem editCut = new JMenuItem("Cut");
		editCut.addActionListener(new DefaultEditorKit.CutAction());
		editCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));

		JMenuItem editCopy = new JMenuItem("Copy");
		editCopy.addActionListener(new DefaultEditorKit.CopyAction());
		editCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));

		JMenuItem editPaste = new JMenuItem("Paste");
		editPaste.addActionListener(new DefaultEditorKit.PasteAction());
		editPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));

		menuEdit.add(editUndo);
		menuEdit.add(editCut);
		menuEdit.add(editCopy);
		menuEdit.add(editPaste);

		JMenu menuFormat = new JMenu("Format");

		JMenu formatFont = new JMenu("Fonts");
		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String [] fonts = g.getAvailableFontFamilyNames();
		JList<String> fontList = new JList<String>(fonts);
		JScrollPane pane = new JScrollPane(fontList);
		pane.setSize(new Dimension(60, 80));
		formatFont.add(pane);
		fontList.addListSelectionListener(new Fonts(fontList, textArea));

		menuFormat.add(formatFont);

		JMenu menuView = new JMenu("View");
		JMenu viewZoom = new JMenu("Zoom");

		//TODO fix the accelerator
		JMenuItem zoomIn = new JMenuItem("Zoom In");
		zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		zoomIn.addActionListener(new ZoomIn(textArea));

		JMenuItem zoomOut = new JMenuItem("Zoom Out");
		zoomOut.addActionListener(new ZoomOut(textArea));
		zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));

		viewZoom.add(zoomIn);
		viewZoom.add(zoomOut);

		menuView.add(viewZoom);

		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuFormat);
		menuBar.add(menuView);

		window.getContentPane().setPreferredSize(new Dimension(600, 400));
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.add(textArea);
		window.add(new JScrollPane(textArea));
		window.setJMenuBar(menuBar);
		window.setIconImage(icon.getImage());
		window.setVisible(true);

		Open tmp = new Open(textArea, window);
		tmp.open();
	}

}
