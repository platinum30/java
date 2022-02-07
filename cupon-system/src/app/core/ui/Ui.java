package app.core.ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app.core.beans.ClientType;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;
import app.core.facade.ClientFacade;
import app.core.facade.LoginManager;

public class Ui {
	public static ImageIcon vIcon = new ImageIcon("src/images/V.png");
	private static ImageIcon xIcon = new ImageIcon("src/images/X.png");
	private static ClientFacade facade;

	public static void main(String[] args) {
		loginFrame();
	}

	public static void loginFrame() {
		JFrame fr = new JFrame("Coupon system - Login");// create window form
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setBounds(100, 100, 240, 320);// create the window and set location and size
		fr.setLayout(null);// we will set components size and location
		fr.setResizable(false);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/images/logo.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel labelICon = new JLabel();
		labelICon.setBounds(0, 0, 225, 127);

		Image dimg = img.getScaledInstance(labelICon.getWidth(), labelICon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(dimg);
		labelICon.setIcon(icon);
		fr.add(labelICon);

		JLabel emailLbl = new JLabel();
		emailLbl.setText("Email");
		emailLbl.setBounds(10, 100, 200, 25);
		fr.add(emailLbl);

		JTextField emailField = new JTextField();
		emailField.setBounds(10, 120, 200, 25);
		fr.add(emailField);

		JLabel passLbl = new JLabel();
		passLbl.setText("Password");
		passLbl.setBounds(10, 140, 200, 25);
		fr.add(passLbl);

		JTextField passField = new JTextField();
		passField.setBounds(10, 160, 200, 25);
		fr.add(passField);

		JLabel loginAsLbl = new JLabel();
		loginAsLbl.setText("Login as");
		loginAsLbl.setBounds(10, 180, 200, 25);
		fr.add(loginAsLbl);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 200, 200, 25);
		comboBox.addItem("Customer");
		comboBox.addItem("Company");
		comboBox.addItem("Admin");

		fr.add(comboBox);

		JButton btAdd = new JButton("Login");
		btAdd.setBounds(10, 230, 200, 40);

		btAdd.addActionListener(new ActionListener() {// button click event
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				String loginAs = comboBox.getSelectedItem().toString();
				String email = emailField.getText();
				String password = passField.getText();
				ClientType clientType;
				switch (loginAs) {
				case "Admin":
					clientType = ClientType.ADMINISTRATOR;
					break;
				case "Company":
					clientType = ClientType.COMPANY;
					break;
				case "Customer":
					clientType = ClientType.CUSTOMER;
					break;
				default:
					clientType = ClientType.CUSTOMER;
				}

				try {
					facade = LoginManager.getInstance().login(email, password, clientType);
				} catch (CouponRTException e1) {
					JOptionPane.showMessageDialog(fr, e1.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE, xIcon);
				} catch (CouponSuccess e1) {
					JOptionPane.showMessageDialog(fr, e1.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE,
							vIcon);
				}

				if (facade != null) {
					JOptionPane.showMessageDialog(fr, "Logged in successfully", "Login",
							JOptionPane.INFORMATION_MESSAGE, vIcon);
					if (clientType.equals(ClientType.ADMINISTRATOR)) {
						fr.setVisible(false);
						AdminUi.getInstance().adminFrame();
					}
				}

			}
		});
		fr.add(btAdd);
		fr.setVisible(true);// "draw the window"
	}
}
