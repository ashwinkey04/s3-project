package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DBHelpers.MusicianSQL;

public class DeleteMusician extends BaseFrame {
	private static final long serialVersionUID = 1L;

	static DeleteMusician frame;
	JLabel Id, title;
	JTextField tid;
	JButton btn, btn2;

	DeleteMusician() {
		setLayout(null);
		setResizable(false);
		setSize(600, 400);

		setTitle("Delete Musician");
		title = new JLabel("Enter Musician ID", JLabel.CENTER);
		title.setFont(SwingHelper.customFont(20));
		title.setBounds(100, 15, 400, 40);
		add(title);

		tid = new JTextField();
		tid.setBounds(200, 140, 200, 30);
		
		Id = new JLabel("ID:");
		Id.setFont(SwingHelper.customFont(18));
		Id.setBounds(120, 140, 200, 30);
		

		btn2 = new JButton("Back");
		btn2.setBounds(300, 250, 100, 30);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminDash.main(new String[] {});
			}
		});
		
		btn = new JButton("Submit");
		btn.setBounds(175, 250, 100, 30);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tid.getText() == null) {
					JOptionPane.showMessageDialog(frame, "No empty values allowed ");
				} else {
					String id = tid.getText();
					try {
						MusicianSQL.delete(id);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Deleted musician with id " + id + " successfully!");
				}
			}
		});
		
		add(Id);
		add(tid);
		add(btn);
		add(btn2);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteMusician();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
