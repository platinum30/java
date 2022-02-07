package a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DictionaryUi {
	public static void main(String[] args) {
		DictionaryUi ui = new DictionaryUi();
		ui.creatAndShowView();
	}

	// model - business logic
	private Dictionary dictionary = new Dictionary();

	public void creatAndShowView() {
		JFrame fr = new JFrame("Dictionary");// create window form
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setBounds(100, 100, 500, 300);// create the window and set location and size
		fr.setLayout(null);// we will set components size and location

		JTextField tfEntry = new JTextField();// create text field
		tfEntry.setBounds(10, 10, 200, 25);
		fr.add(tfEntry);

		JTextArea tfDef = new JTextArea(5, 200);// create text Area
		tfDef.setBounds(10, 50, 200, 50);
		tfDef.setLineWrap(true);
		fr.add(tfDef);

		JButton btAdd = new JButton("Add Entry");
		btAdd.setBounds(250, 10, 200, 25);

		btAdd.addActionListener(new ActionListener() {// button click event
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				System.out.println("clicked");
				String entry = tfEntry.getText();
				System.out.println(entry);
				String definition = tfDef.getText();
				dictionary.addEntery(entry, definition);
				System.out.println("Added");
				System.out.println(dictionary.getMap());

			}
		});
		fr.add(btAdd);

		JButton btShow = new JButton("Show definition");
		btShow.setBounds(250, 50, 200, 25);
		btShow.addActionListener(new ActionListener() {// button click event
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				String entry = tfEntry.getText();

				try {
					String def = dictionary.getDefinition(entry);
					JOptionPane.showMessageDialog(fr, def);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(fr, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		fr.add(btShow);

		fr.setVisible(true);// "draw the window"
	}

}
