package a;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameExample {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JFrame Example");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("JFrame By Example");
		JButton button = new JButton();
		button.setText("Button");
		panel.add(label);
		panel.add(button);
		frame.add(panel);
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
