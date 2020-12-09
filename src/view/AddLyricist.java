package view;

import javax.swing.*;

import DBHelpers.LyricistSQL;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Lyricist;

public class AddLyricist extends BaseFrame {
	JLabel title, ly_id, ly_name, ly_addr, ly_award, lang;
	JTextField tly_id, tly_name, tly_addr, tly_award, tlang;
	JButton btn1, btn2;
	static AddLyricist frame;

	AddLyricist() {
		setLayout(null);
		setResizable(false);
		setSize(600, 400);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

		setTitle("Registration Form ");
		title = new JLabel("Enter Lyricist Details", JLabel.CENTER);
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(100, 15, 400, 40);
		add(title);

		ly_id = new JLabel("Lyricist ID");
		tly_id = new JTextField();
		ly_id.setFont(new Font("Arial", Font.PLAIN, 20));
		ly_id.setBounds(150, 70, 200, 30);
		tly_id.setBounds(300, 70, 200, 30);
		add(ly_id);
		add(tly_id);

		ly_name = new JLabel("Lyricist Name");
		tly_name = new JTextField();
		ly_name.setFont(new Font("Arial", Font.PLAIN, 20));
		ly_name.setBounds(150, 110, 200, 30);
		tly_name.setBounds(300, 110, 200, 30);
		add(ly_name);
		add(tly_name);

		ly_addr = new JLabel("Lyricist Address");
		tly_addr = new JTextField();
		ly_addr.setFont(new Font("Arial", Font.PLAIN, 20));
		ly_addr.setBounds(150, 150, 200, 30);
		tly_addr.setBounds(300, 150, 200, 30);
		add(ly_addr);
		add(tly_addr);

		ly_award = new JLabel("Awards");
		tly_award = new JTextField();
		ly_award.setFont(new Font("Arial", Font.PLAIN, 20));
		ly_award.setBounds(150, 190, 200, 30);
		tly_award.setBounds(300, 190, 200, 30);
		add(ly_award);
		add(tly_award);

		lang = new JLabel("Language");
		tlang = new JTextField();
		lang.setFont(new Font("Arial", Font.PLAIN, 20));
		lang.setBounds(150, 230, 200, 30);
		tlang.setBounds(300, 230, 200, 30);
		add(lang);
		add(tlang);

		btn1 = new JButton("Submit");
		btn1.setBounds(175, 275, 100, 30);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tly_id.getText() == null || tly_name.getText() == null || tly_addr.getText() == null
						|| tly_award.getText() == null) {
					JOptionPane.showMessageDialog(frame, "No empty values allowed ");
				} else {
					String name = tly_name.getText();
					String id = tly_id.getText();
					String addr = tly_addr.getText();
					String lang = tlang.getText();
					
					int awards = -1;
					awards = Integer.parseInt(tly_award.getText());

					Lyricist lyricist = new Lyricist(id, name, addr, awards, lang);
					try {
						LyricistSQL.insert(lyricist);
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Added Lyricist " + name + " successfully!");
				}

			}

		});
		add(btn1);

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
					frame = new AddLyricist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
