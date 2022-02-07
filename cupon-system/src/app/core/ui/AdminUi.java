package app.core.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import app.core.beans.Company;
import app.core.beans.Customer;
import app.core.dao.db.CompaniesDBDAO;
import app.core.dao.db.CustomersDBDAO;
import app.core.exceptions.CouponRTException;
import app.core.exceptions.CouponSuccess;
import app.core.facade.AdminFacade;

public class AdminUi {
	private static ImageIcon xIcon = new ImageIcon("src/images/X.png");
	private static ImageIcon vIcon = new ImageIcon("src/images/V.png");
	private static AdminUi instance;
	private static JFrame adminFr = new JFrame("Coupon system - Admin menu");
	private static ArrayList<Company> companies;
	private static ArrayList<Customer> customers;
	private static String[][] CompaniesData;
	private static String[][] CustomersData;
	// frame
	private static JFrame f = new JFrame();
	// Table
	private static JTable companiesTable;
	private static JTable customersTable;

	private static void updateCompaniesTable() {
		// Data to be displayed in the JTable
		CompaniesData = new String[companies.size()][3];
		int counter = 0;
		for (Company company : companies) {
			String[] string = new String[3];
			string[0] = "" + company.getId();
			string[1] = company.getName();
			string[2] = company.getEmail();
			CompaniesData[counter] = string;
			counter++;
		}
	}

	private static void updateCustomersTable() {
		// Data to be displayed in the JTable
		CustomersData = new String[customers.size()][4];
		int counter = 0;
		for (Customer customer : customers) {
			String[] string = new String[4];
			string[0] = "" + customer.getId();
			string[1] = customer.getFirstName();
			string[2] = customer.getLastName();
			string[3] = customer.getEmail();
			CustomersData[counter] = string;
			counter++;
		}
	}

	private static void popUp(boolean success, String message, JFrame target) {
		if (success)
			JOptionPane.showMessageDialog(target, message, "Success", JOptionPane.INFORMATION_MESSAGE, vIcon);
		else
			JOptionPane.showMessageDialog(target, message, "Error", JOptionPane.INFORMATION_MESSAGE, xIcon);
	}

	private AdminUi() {
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setTitle("Coupon System - Manage compaines");

	}

	public static void main(String[] args) {
		try {
			refreshCompanies();
			refreshCustomers();
			// editCompanyUi(3);
			adminFrame();
		} catch (Exception e) {
			popUp(false, e.getMessage(), f);
		}

	}

	public static AdminUi getInstance() {
		if (instance == null)
			instance = new AdminUi();
		return instance;
	}

	public static void editCompanyUi(int companyId) throws CouponRTException, CouponSuccess {
		Company company = CompaniesDBDAO.getInstance().getCompanyById(companyId);
		f.getContentPane().removeAll();// remove all components from companies frame
		f.setSize(300, 350);
		addLogo(20, 300, 130, 231, 130);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		f.add(centerPanel, BorderLayout.CENTER);
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		f.add(bottomPanel, BorderLayout.AFTER_LAST_LINE);

		JLabel titleLbl = new JLabel();
		titleLbl.setText("Edit " + company.getName() + " company (id: " + company.getId() + ")");
		titleLbl.setFont(new Font("Arial", Font.PLAIN, 20));
		centerPanel.add(titleLbl);

		JLabel emailLbl = new JLabel();
		emailLbl.setText("Email");
		centerPanel.add(emailLbl);

		JTextField emailField = new JTextField();
		emailField.setText(company.getEmail());
		centerPanel.add(emailField);

		JLabel passLbl = new JLabel();
		passLbl.setText("Password");
		centerPanel.add(passLbl);

		JTextField passField = new JTextField();
		passField.setText(company.getPassword());
		centerPanel.add(passField);

		JButton saveBtn = new JButton("Save");
		saveBtn.setFocusPainted(false);
		saveBtn.setFont(new Font("Arial", Font.BOLD, 24));
		saveBtn.setBackground(new Color(242, 88, 53));
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				company.setEmail(emailField.getText());
				company.setPassword(passField.getText());
				try {
					AdminFacade.getInstance().updateCompany(company);
				} catch (CouponRTException e1) {
					popUp(false, e1.getMessage(), f);
				} catch (CouponSuccess e1) {
					popUp(true, e1.getMessage(), f);
				}
				companiesFrame();
			}
		});
		JButton cancleBtn = new JButton("Cancel");
		cancleBtn.setFocusPainted(false);
		cancleBtn.setFont(new Font("Arial", Font.BOLD, 24));
		cancleBtn.setBackground(new Color(242, 88, 53));
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				companiesFrame();
			}
		});
		bottomPanel.add(saveBtn);
		bottomPanel.add(cancleBtn);

		f.repaint();// repaint the frame

	}

	public static void editCustomerUi(int customerId) throws CouponRTException, CouponSuccess {
		Customer customer = CustomersDBDAO.getInstance().getCustomerById(customerId);
		f.getContentPane().removeAll();// remove all components from companies frame
		f.setSize(300, 440);
		addLogo(20, 300, 130, 231, 130);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		f.add(centerPanel, BorderLayout.CENTER);
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		f.add(bottomPanel, BorderLayout.AFTER_LAST_LINE);

		JLabel titleLbl = new JLabel();
		titleLbl.setText("Edit " + customer.getFirstName() + " " + customer.getLastName() + "  (customer id: "
				+ customer.getId() + ")");
		titleLbl.setFont(new Font("Arial", Font.PLAIN, 20));
		centerPanel.add(titleLbl);

		JLabel fnameLbl = new JLabel();
		fnameLbl.setText("First name");
		centerPanel.add(fnameLbl);

		JTextField fnameField = new JTextField();
		fnameField.setText(customer.getFirstName());
		centerPanel.add(fnameField);

		JLabel lnameLbl = new JLabel();
		lnameLbl.setText("Last name");
		centerPanel.add(lnameLbl);

		JTextField lnameField = new JTextField();
		lnameField.setText(customer.getLastName());
		centerPanel.add(lnameField);

		JLabel emailLbl = new JLabel();
		emailLbl.setText("Email");
		centerPanel.add(emailLbl);

		JTextField emailField = new JTextField();
		emailField.setText(customer.getEmail());
		centerPanel.add(emailField);

		JLabel passLbl = new JLabel();
		passLbl.setText("Password");
		centerPanel.add(passLbl);

		JTextField passField = new JTextField();
		passField.setText(customer.getPassword());
		centerPanel.add(passField);

		JButton saveBtn = new JButton("Save");
		saveBtn.setFocusPainted(false);
		saveBtn.setFont(new Font("Arial", Font.BOLD, 24));
		saveBtn.setBackground(new Color(242, 88, 53));
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				customer.setFirstName(fnameField.getText());
				customer.setLastName(lnameField.getText());
				customer.setEmail(emailField.getText());
				customer.setPassword(passField.getText());
				try {
					AdminFacade.getInstance().updateCustomer(customer);
				} catch (CouponRTException e1) {
					popUp(false, e1.getMessage(), f);
				} catch (CouponSuccess e1) {
					popUp(true, e1.getMessage(), f);
				}
				customersFrame();
			}
		});
		JButton cancleBtn = new JButton("Cancel");
		cancleBtn.setFocusPainted(false);
		cancleBtn.setFont(new Font("Arial", Font.BOLD, 24));
		cancleBtn.setBackground(new Color(242, 88, 53));
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				companiesFrame();
			}
		});
		bottomPanel.add(saveBtn);
		bottomPanel.add(cancleBtn);

		f.repaint();// repaint the frame

	}

	public static void addLogo(int logoX, int bgWidth, int bgHeight, int logoWidth, int logoHeight) {
		/* LOGO */
		BufferedImage bgImg = null;
		BufferedImage logoImg = null;
		try {
			bgImg = ImageIO.read(new File("src/images/background.jpg"));
			logoImg = ImageIO.read(new File("src/images/logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel bgLblIcon = new JLabel();
		bgLblIcon.setBounds(0, 0, bgWidth, bgHeight);
		JLabel logoLblIcon = new JLabel();
		logoLblIcon.setBounds(logoX, 0, logoWidth, logoHeight);
		Image bgDimg = bgImg.getScaledInstance(bgLblIcon.getWidth(), bgLblIcon.getHeight(), Image.SCALE_AREA_AVERAGING);
		ImageIcon bgIcon = new ImageIcon(bgDimg);
		bgLblIcon.setIcon(bgIcon);
		Image logoDimg = logoImg.getScaledInstance(logoLblIcon.getWidth(), logoLblIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon logoIcon = new ImageIcon(logoDimg);
		logoLblIcon.setIcon(logoIcon);
		f.add(logoLblIcon, BorderLayout.NORTH);
		f.add(bgLblIcon, BorderLayout.NORTH);
		/* END OF LOGO */
	}

	public static void addCompanyUi() {
		Company company = new Company();
		f.getContentPane().removeAll();// remove all components from companies frame
		f.setSize(300, 400);
		addLogo(20, 300, 130, 231, 130);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		f.add(centerPanel, BorderLayout.CENTER);
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		f.add(bottomPanel, BorderLayout.AFTER_LAST_LINE);

		JLabel titleLbl = new JLabel();
		titleLbl.setText("Add new company");
		titleLbl.setFont(new Font("Arial", Font.PLAIN, 20));
		centerPanel.add(titleLbl);

		JLabel nameLbl = new JLabel();
		nameLbl.setText("Company name");
		centerPanel.add(nameLbl);

		JTextField nameField = new JTextField();
		centerPanel.add(nameField);

		JLabel emailLbl = new JLabel();
		emailLbl.setText("Email");
		centerPanel.add(emailLbl);

		JTextField emailField = new JTextField();
		centerPanel.add(emailField);

		JLabel passLbl = new JLabel();
		passLbl.setText("Password");
		centerPanel.add(passLbl);

		JTextField passField = new JTextField();
		centerPanel.add(passField);

		JButton saveBtn = new JButton("Save");
		saveBtn.setFocusPainted(false);
		saveBtn.setFont(new Font("Arial", Font.BOLD, 24));
		saveBtn.setBackground(new Color(242, 88, 53));
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				String name = nameField.getText();
				String email = emailField.getText();
				String pass = passField.getText();
				if (name.equals("") || email.equals("") || pass.equals("")) {
					popUp(false, "Please fill all the form fields", f);
				} else {
					company.setName(name);
					company.setEmail(email);
					company.setPassword(pass);
					try {
						AdminFacade.getInstance().addCompany(company);
					} catch (CouponRTException e1) {
						popUp(false, e1.getMessage(), f);
					} catch (CouponSuccess e1) {
						popUp(true, e1.getMessage(), f);
					}
					companiesFrame();
				}
			}
		});
		JButton cancleBtn = new JButton("Cancel");
		cancleBtn.setFocusPainted(false);
		cancleBtn.setFont(new Font("Arial", Font.BOLD, 24));
		cancleBtn.setBackground(new Color(242, 88, 53));
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				companiesFrame();
			}
		});
		bottomPanel.add(saveBtn);
		bottomPanel.add(cancleBtn);

		f.repaint();// repaint the frame

	}

	public static void addCustomerUi() {
		Customer customer = new Customer();
		f.getContentPane().removeAll();// remove all components from companies frame
		f.setSize(300, 440);
		addLogo(20, 300, 130, 231, 130);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		f.add(centerPanel, BorderLayout.CENTER);
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		f.add(bottomPanel, BorderLayout.AFTER_LAST_LINE);

		JLabel titleLbl = new JLabel();
		titleLbl.setText("Add new customer");
		titleLbl.setFont(new Font("Arial", Font.PLAIN, 20));
		centerPanel.add(titleLbl);

		JLabel fnameLbl = new JLabel();
		fnameLbl.setText("Fist name");
		centerPanel.add(fnameLbl);

		JTextField fnameField = new JTextField();
		centerPanel.add(fnameField);

		JLabel lnameLbl = new JLabel();
		lnameLbl.setText("Last name");
		centerPanel.add(lnameLbl);

		JTextField lnameField = new JTextField();
		centerPanel.add(lnameField);

		JLabel emailLbl = new JLabel();
		emailLbl.setText("Email");
		centerPanel.add(emailLbl);

		JTextField emailField = new JTextField();
		centerPanel.add(emailField);

		JLabel passLbl = new JLabel();
		passLbl.setText("Password");
		centerPanel.add(passLbl);

		JTextField passField = new JTextField();
		centerPanel.add(passField);

		JButton saveBtn = new JButton("Save");
		saveBtn.setFocusPainted(false);
		saveBtn.setFont(new Font("Arial", Font.BOLD, 24));
		saveBtn.setBackground(new Color(242, 88, 53));
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				String fname = fnameField.getText();
				String lname = lnameField.getText();
				String email = emailField.getText();
				String pass = passField.getText();
				if (fname.equals("") || lname.equals("") || email.equals("") || pass.equals("")) {
					popUp(false, "Please fill all the form fields", f);
				} else {
					customer.setFirstName(fname);
					customer.setLastName(lname);
					customer.setEmail(email);
					customer.setPassword(pass);
					try {
						AdminFacade.getInstance().addCustomer(customer);
					} catch (CouponRTException e1) {
						popUp(false, e1.getMessage(), f);
					} catch (CouponSuccess e1) {
						popUp(true, e1.getMessage(), f);
					}
					customersFrame();
				}
			}
		});
		JButton cancleBtn = new JButton("Cancel");
		cancleBtn.setFocusPainted(false);
		cancleBtn.setFont(new Font("Arial", Font.BOLD, 24));
		cancleBtn.setBackground(new Color(242, 88, 53));
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				customersFrame();
			}
		});
		bottomPanel.add(saveBtn);
		bottomPanel.add(cancleBtn);

		f.repaint();// repaint the frame

	}

	public static void resetFrame() {
		Company company = new Company();
		f.getContentPane().removeAll();// remove all components from companies frame
		f.setSize(0, 0);
		f.repaint();// repaint the frame

	}

	private static void refreshCompanies(int... companyId) {
		try {

			if (companyId.length > 0) {
				Company company = AdminFacade.getInstance().getOneCompany(companyId[0]);// get one customer
				companies = new ArrayList<>();
				companies.add(company);
			} else
				companies = AdminFacade.getInstance().getAllCompanies();// refresh / load companies
		} catch (CouponRTException e2) {
			// TODO Auto-generated catch block
			popUp(false, e2.getMessage(), f);
		}
	}

	private static void refreshCustomers(int... customerId) {

		try {
			if (customerId.length > 0) {
				Customer cust = AdminFacade.getInstance().getOneCustomer(customerId[0]);// get one customer
				customers = new ArrayList<>();
				customers.add(cust);
			} else
				customers = AdminFacade.getInstance().getAllCustomers();// refresh / load customers

		} catch (CouponRTException e2) {
			popUp(false, e2.getMessage(), f);
		}
	}

	public static void companiesFrame(int... companyId) {
		if (companyId.length > 0)
			refreshCompanies(companyId[0]);
		else
			refreshCompanies();
		updateCompaniesTable();
		f.getContentPane().removeAll();// remove all components from companies frame
		f.setLayout(new BorderLayout());
		addLogo(220, 685, 130, 231, 130);

		JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		f.add(btnPnl, BorderLayout.SOUTH);
		JButton editBtn = new JButton("Edit");
		editBtn.setFocusPainted(false);
		editBtn.setFont(new Font("Arial", Font.BOLD, 24));
		editBtn.setBackground(new Color(242, 88, 53));
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				int row = companiesTable.getSelectedRow();
				if (row != -1) {
					int companyId = Integer.parseInt(companiesTable.getModel().getValueAt(row, 0).toString());
					try {
						editCompanyUi(companyId);
					} catch (CouponRTException e1) {
						popUp(false, e1.getMessage(), f);
					} catch (CouponSuccess e1) {
						popUp(true, e1.getMessage(), f);
					}
				} else {
					popUp(false, "Please select company first", f);
				}
			}
		});

		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setFocusPainted(false);
		deleteBtn.setFont(new Font("Arial", Font.BOLD, 24));
		deleteBtn.setBackground(new Color(242, 88, 53));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				int row = companiesTable.getSelectedRow();
				if (row != -1) {
					int companyId = Integer.parseInt(companiesTable.getModel().getValueAt(row, 0).toString());
					String companyName = companiesTable.getModel().getValueAt(row, 1).toString();

					int reply = JOptionPane.showConfirmDialog(null,
							"are you sure you wan't to delete " + companyName + " ?", "DELETE",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						try {
							AdminFacade.getInstance().deleteCompany(companyId);
							companies = AdminFacade.getInstance().getAllCompanies();
							updateCompaniesTable();
							f.repaint();
						} catch (CouponRTException e1) {
							popUp(false, e1.getMessage(), f);
						} catch (CouponSuccess e1) {
							f.getContentPane().removeAll();

							popUp(true, e1.getMessage(), f);
							resetFrame();
							companiesFrame();
						}

					}

				} else {
					popUp(false, "Please select company first", f);
				}
			}
		});
		JButton addBtn = new JButton("Add company");
		addBtn.setFocusPainted(false);
		addBtn.setFont(new Font("Arial", Font.BOLD, 24));
		addBtn.setBackground(new Color(242, 88, 53));
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				addCompanyUi();
			}
		});
		JButton getBtn = new JButton("Find company");
		getBtn.setFocusPainted(false);
		getBtn.setFont(new Font("Arial", Font.BOLD, 24));
		getBtn.setBackground(new Color(242, 88, 53));
		getBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				try {
					int input = Integer.parseInt(JOptionPane.showInputDialog("Enter company id:"));
					resetFrame();
					companiesFrame(input);
				} catch (NumberFormatException d) {
					popUp(false, "Numeric value only", f);
				}

			}
		});
		JButton allBtn = new JButton("All");
		allBtn.setFocusPainted(false);
		allBtn.setFont(new Font("Arial", Font.BOLD, 24));
		allBtn.setBackground(new Color(242, 88, 53));
		allBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				resetFrame();
				customersFrame();
			}
		});
		btnPnl.add(editBtn);
		btnPnl.add(deleteBtn);
		btnPnl.add(addBtn);
		btnPnl.add(getBtn);
		btnPnl.add(allBtn);

		// Column Names
		String[] columnNames = { "ID", "Company Name", "Email" };
		updateCompaniesTable();
		companiesTable = new JTable(CompaniesData, columnNames);
		companiesTable.setBounds(0, 0, 200, 300);

		for (int c = 0; c < companiesTable.getColumnCount(); c++) {
			Class<?> col_class = companiesTable.getColumnClass(c);
			companiesTable.setDefaultEditor(col_class, null); // remove editor
		}

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(companiesTable);
		f.add(sp, BorderLayout.CENTER);
		// Frame Size
		f.setSize(700, 600);
		f.setResizable(false);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				adminFr.setVisible(true);
			}
		});
		f.repaint();// repaint the frame
	}

	public static void customersFrame(int... customerId) {
		if (customerId.length > 0)
			refreshCustomers(customerId[0]);
		else
			refreshCustomers();

		updateCustomersTable();
		f.getContentPane().removeAll();// remove all components from companies frame
		f.setLayout(new BorderLayout());
		addLogo(220, 685, 130, 231, 130);

		JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		f.add(btnPnl, BorderLayout.SOUTH);
		JButton editBtn = new JButton("Edit");
		editBtn.setFocusPainted(false);
		editBtn.setFont(new Font("Arial", Font.BOLD, 24));
		editBtn.setBackground(new Color(242, 88, 53));
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				int row = customersTable.getSelectedRow();
				if (row != -1) {
					int customerId = Integer.parseInt(customersTable.getModel().getValueAt(row, 0).toString());
					try {
						editCustomerUi(customerId);
						;
					} catch (CouponRTException e1) {
						popUp(false, e1.getMessage(), f);
					} catch (CouponSuccess e1) {
						popUp(true, e1.getMessage(), f);
					}
				} else {
					popUp(false, "Please select customer first", f);
				}
			}
		});

		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setFocusPainted(false);
		deleteBtn.setFont(new Font("Arial", Font.BOLD, 24));
		deleteBtn.setBackground(new Color(242, 88, 53));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				int row = customersTable.getSelectedRow();
				if (row != -1) {
					int customerId = Integer.parseInt(customersTable.getModel().getValueAt(row, 0).toString());
					String customerName = customersTable.getModel().getValueAt(row, 1).toString();

					int reply = JOptionPane.showConfirmDialog(null,
							"are you sure you wan't to delete " + customerName + " ?", "DELETE",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						try {
							AdminFacade.getInstance().deleteCustomer(customerId);
						} catch (CouponRTException e1) {
							popUp(false, e1.getMessage(), f);
						} catch (CouponSuccess e1) {
							f.getContentPane().removeAll();

							popUp(true, e1.getMessage(), f);
							updateCustomersTable();
							refreshCustomers();
							resetFrame();
							customersFrame();
						}

					}

				} else {
					popUp(false, "Please select customer first", f);
				}
			}
		});
		JButton addBtn = new JButton("Add customer");
		addBtn.setFocusPainted(false);
		addBtn.setFont(new Font("Arial", Font.BOLD, 24));
		addBtn.setBackground(new Color(242, 88, 53));
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				addCustomerUi();
			}
		});

		JButton getBtn = new JButton("Find customer");
		getBtn.setFocusPainted(false);
		getBtn.setFont(new Font("Arial", Font.BOLD, 24));
		getBtn.setBackground(new Color(242, 88, 53));
		getBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				try {
					int input = Integer.parseInt(JOptionPane.showInputDialog("Enter customer id:"));
					resetFrame();
					customersFrame(input);
				} catch (NumberFormatException d) {
					popUp(false, "Numeric value only", f);
				}

			}
		});
		JButton allBtn = new JButton("All");
		allBtn.setFocusPainted(false);
		allBtn.setFont(new Font("Arial", Font.BOLD, 24));
		allBtn.setBackground(new Color(242, 88, 53));
		allBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				resetFrame();
				companiesFrame();
			}
		});

		btnPnl.add(editBtn);
		btnPnl.add(deleteBtn);
		btnPnl.add(addBtn);
		btnPnl.add(getBtn);
		btnPnl.add(allBtn);

		// Column Names
		String[] columnNames = { "ID", "First Name", "Last Name", "Email" };
		updateCustomersTable();
		customersTable = new JTable(CustomersData, columnNames);

		for (int c = 0; c < customersTable.getColumnCount(); c++) {
			Class<?> col_class = customersTable.getColumnClass(c);
			customersTable.setDefaultEditor(col_class, null); // remove editor
		}

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(customersTable);
		f.add(sp, BorderLayout.CENTER);
		// Frame Size
		f.setSize(700, 600);
		f.setResizable(false);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				adminFr.setVisible(true);
			}
		});
		f.repaint();// repaint the frame
	}

	public static void adminFrame() {
		adminFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFr.setBounds(100, 100, 240, 320);// create the window and set location and size
		adminFr.setLayout(null);// we will set components size and location
		adminFr.setResizable(false);

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
		adminFr.add(labelICon);

		JLabel title = new JLabel();
		title.setText("Admin menu");
		title.setBounds(60, 140, 200, 25);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		adminFr.add(title);

		JButton companyBt = new JButton("Manage companies");
		companyBt.setBounds(15, 170, 200, 40);
		companyBt.setFocusPainted(false);
		companyBt.setFont(new Font("Arial", Font.BOLD, 16));
		companyBt.setBackground(new Color(242, 88, 53));
		companyBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				companiesFrame();
				adminFr.setVisible(false);
				f.setVisible(true);
			}
		});
		adminFr.add(companyBt);

		JButton userBt = new JButton("Manage customers");
		userBt.setBounds(15, 220, 200, 40);
		userBt.setFocusPainted(false);
		userBt.setFont(new Font("Arial", Font.BOLD, 16));
		userBt.setBackground(new Color(242, 88, 53));
		userBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// button logic
				customersFrame();
				adminFr.setVisible(false);
				f.setVisible(true);
			}
		});
		adminFr.add(userBt);

		adminFr.setVisible(true);// "draw the window"
	}

}
