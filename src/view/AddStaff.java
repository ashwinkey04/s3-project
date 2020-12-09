package view;

import javax.swing.*;

import DBHelpers.StaffSQL;
import model.Staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AddStaff extends BaseFrame {

	static AddStaff frame;
	JLabel title, staff_id, staff_name, salary, join_date;
	JTextField tstaff_id, tstaff_name, tsalary, tjoin_date;
	JButton btn1, btn2;

	AddStaff() {
		setLayout(null);
		setResizable(false);
		setSize(600, 400);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

		setTitle("Registration Form ");
		title = new JLabel("Enter Staff Details", JLabel.CENTER);
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(100, 15, 400, 20);
		add(title);

		staff_id = new JLabel("Staff ID:");
		tstaff_id = new JTextField();
		staff_id.setFont(new Font("Arial", Font.PLAIN, 20));
		staff_id.setBounds(150, 70, 200, 30);
		tstaff_id.setBounds(300, 70, 200, 30);
		add(staff_id);
		add(tstaff_id);

		staff_name = new JLabel("Name:");
		tstaff_name = new JTextField();
		staff_name.setFont(new Font("Arial", Font.PLAIN, 20));
		staff_name.setBounds(150, 110, 200, 30);
		tstaff_name.setBounds(300, 110, 200, 30);
		add(staff_name);
		add(tstaff_name);

		salary = new JLabel("Salary");
		tsalary = new JTextField();
		salary.setFont(new Font("Arial", Font.PLAIN, 20));
		salary.setBounds(150, 150, 200, 30);
		tsalary.setBounds(300, 150, 200, 30);
		add(salary);
		add(tsalary);

		join_date = new JLabel("Joining Date");
		tjoin_date = new JTextField();
		join_date.setFont(new Font("Arial", Font.PLAIN, 20));
		join_date.setBounds(150, 190, 200, 30);
		tjoin_date.setBounds(300, 190, 200, 30);
		add(join_date);
		add(tjoin_date);

		btn1 = new JButton("Submit");
		btn1.setBounds(175, 275, 100, 30);
		add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tstaff_id.getText() == null || tstaff_name.getText() == null || tsalary.getText() == null
						|| tjoin_date.getText() == null) {
					JOptionPane.showMessageDialog(frame, "No empty values allowed ");
				} else {
					String name = tstaff_name.getText();
					String id = tstaff_id.getText();
					int sal = -1;
					sal = Integer.parseInt(tsalary.getText());
					Date join_date = Date.valueOf(tjoin_date.getText());

					Staff staff = new Staff(id, name, sal, join_date);
					try {
						StaffSQL.insert(staff);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Added Staff " + name + " successfully!");
				}

			}

		});

		btn2 = new JButton("Back");
		btn2.setBounds(300, 275, 100, 30);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminDash.main(new String[] {});
			}
		});
		add(btn2);
		setVisible(true);
	}

	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
