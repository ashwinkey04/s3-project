package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DBHelpers.MusicianSQL;
import model.Musician;

public class AddMusician extends BaseFrame {

	private static final long serialVersionUID = 1L;

	static AddMusician frame;
	JLabel title, name, Id, addres, awards;
	JTextField tname, tid, tadd, tawards;
	JButton btn1, btn2;

	AddMusician() {
		setLayout(null);
		setResizable(false);
		setSize(600, 400);

		setTitle("Registration Form ");
		title = new JLabel("Enter Musician Details", JLabel.CENTER);
		title.setFont(SwingHelper.customFont(20));
		title.setBounds(100, 15, 400, 40);
		add(title);

		name = new JLabel("Name:");
		tname = new JTextField();
		name.setFont(SwingHelper.customFont(18));
		name.setBounds(150, 70, 200, 30);
		tname.setBounds(300, 70, 200, 30);
		add(name);
		add(tname);

		Id = new JLabel("ID:");
		tid = new JTextField();
		Id.setFont(SwingHelper.customFont(18));
		Id.setBounds(150, 110, 200, 30);
		tid.setBounds(300, 110, 200, 30);
		add(Id);
		add(tid);

		addres = new JLabel("Address");
		tadd = new JTextField();
		addres.setFont(SwingHelper.customFont(18));
		addres.setBounds(150, 150, 200, 30);
		tadd.setBounds(300, 150, 200, 30);
		add(addres);
		add(tadd);

		awards = new JLabel("Awards");
		tawards = new JTextField();
		awards.setFont(SwingHelper.customFont(18));
		awards.setBounds(150, 190, 200, 30);
		tawards.setBounds(300, 190, 200, 30);
		add(awards);
		add(tawards);

		btn1 = new JButton("Submit");
		btn1.setBounds(175, 275, 100, 30);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tname.getText() == null || tid.getText() == null || tadd.getText() == null
						|| tawards.getText() == null) {
					JOptionPane.showMessageDialog(frame, "No empty values allowed ");
				} else {
					String name = tname.getText();
					String id = tid.getText();
					String address = tadd.getText();
					int awards = -1;
					awards = Integer.parseInt(tawards.getText());

					Musician addMusician = new Musician(id, name, address, false, awards);
					try {
						MusicianSQL.insert(addMusician);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Added musician " + name + " successfully!");
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

		add(btn1);
		add(btn2);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddMusician();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}