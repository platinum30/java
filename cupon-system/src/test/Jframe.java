package test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Jframe extends JFrame {
	private static Jframe instance;

	public static void main(String[] args) {
		getInstance().setVisible(true);
	}

	public static Jframe getInstance() {
		if (instance == null) {
			instance = new Jframe();
		}
		return instance;
	}

	private Jframe() {
		super("Tzah");
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/coupon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel labelICon = new JLabel();
		labelICon.setAlignmentX(20);
		labelICon.setAlignmentY(1000);
		labelICon.setSize(200, 200);

		Image dimg = img.getScaledInstance(labelICon.getWidth(), labelICon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(dimg);
		labelICon.setIcon(icon);
		this.setBounds(0, 0, 400, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		JTextField emailTF = new JTextField(20);
		JTextField passwordTF = new JTextField(20);
		JButton loginBTN = new JButton("Login");
		loginBTN.setBounds(100, 1, 200, 30);
		loginBTN.addActionListener(e -> {
			getInstance().setSize(400, 400);
		});
		add(labelICon);
		// add(emailTF);
		// add(passwordTF);
		add(loginBTN);
	}

}
