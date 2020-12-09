package view;

import javax.swing.*;

import DBHelpers.AlbumSQL;
import model.Album;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AddAlbum extends BaseFrame {
	static AddAlbum frame;
	JLabel title, alb_id, alb_title, release_date, copyright_date, alb_lang, price, staff_id, studio_id;
	JTextField ttitle, talb_id, talb_title, trelease_date, tcopyright_date, talb_lang, tprice, tstaff_id, tstudio_id;
	JButton btn1, btn2;

	AddAlbum() {
		setLayout(null);
		setResizable(false);
		setSize(600, 500);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

		setTitle("Registration Form ");
		title = new JLabel("Enter Album Details", JLabel.CENTER);
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		talb_title = new JTextField();
		title.setBounds(100, 15, 400, 40);
		talb_title.setBounds(300, 110, 200, 30);
		add(title);

		alb_id = new JLabel("Album ID");
		talb_id = new JTextField();
		alb_id.setFont(new Font("Arial", Font.PLAIN, 20));
		alb_id.setBounds(150, 70, 200, 30);
		add(alb_id);
		add(talb_id);

		alb_title = new JLabel("Title:");

		alb_title.setFont(new Font("Arial", Font.PLAIN, 20));
		alb_title.setBounds(150, 110, 200, 30);
		talb_id.setBounds(300, 70, 200, 30);
		add(alb_title);
		add(talb_title);

		release_date = new JLabel("Release Date");
		trelease_date = new JTextField();
		release_date.setFont(new Font("Arial", Font.PLAIN, 20));
		trelease_date.setBounds(300, 150, 200, 30);
		release_date.setBounds(150, 150, 200, 30);
		add(release_date);
		add(trelease_date);

		copyright_date = new JLabel("Copyright Date");
		tcopyright_date = new JTextField();
		copyright_date.setFont(new Font("Arial", Font.PLAIN, 20));
		copyright_date.setBounds(150, 190, 200, 30);
		tcopyright_date.setBounds(300, 190, 200, 30);
		add(copyright_date);
		add(tcopyright_date);

		alb_lang = new JLabel("Language");
		talb_lang = new JTextField();
		alb_lang.setFont(new Font("Arial", Font.PLAIN, 20));
		alb_lang.setBounds(150, 230, 200, 30);
		talb_lang.setBounds(300, 230, 200, 30);
		add(alb_lang);
		add(talb_lang);

		price = new JLabel("Price");
		tprice = new JTextField();
		price.setFont(new Font("Arial", Font.PLAIN, 20));
		price.setBounds(150, 270, 200, 30);
		tprice.setBounds(300, 270, 200, 30);
		add(price);
		add(tprice);

		staff_id = new JLabel("Staff ID");
		tstaff_id = new JTextField();
		staff_id.setFont(new Font("Arial", Font.PLAIN, 20));
		staff_id.setBounds(150, 310, 200, 30);
		tstaff_id.setBounds(300, 310, 200, 30);
		add(staff_id);
		add(tstaff_id);

		studio_id = new JLabel("Studio ID");
		tstudio_id = new JTextField();
		studio_id.setFont(new Font("Arial", Font.PLAIN, 20));
		studio_id.setBounds(150, 350, 200, 30);
		tstudio_id.setBounds(300, 350, 200, 30);
		add(studio_id);
		add(tstudio_id);

		btn1 = new JButton("Submit");
		btn1.setBounds(175, 400, 100, 30);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (talb_title.getText() == null || trelease_date.getText() == null || tcopyright_date.getText() == null
						|| talb_lang.getText() == null || tprice.getText() == null || tstaff_id.getText() == null) {
					JOptionPane.showMessageDialog(frame, "No empty values allowed ");
				} else {
					String name = talb_title.getText();
					Date release = Date.valueOf(trelease_date.getText());
					Date cpr = Date.valueOf(tcopyright_date.getText());
					String id = talb_id.getText();
					String staff_id = tstaff_id.getText();
					String studio_id = tstudio_id.getText();
					String lang = talb_lang.getText();
					int price = Integer.parseInt(tprice.getText());

					Album album = new Album(id, name, release, cpr, lang, price, staff_id, studio_id);
					try {
						AlbumSQL.insert(album);
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Added Album " + name + " successfully!");
				}

			}

		});
		add(btn1);

		btn2 = new JButton("Back");
		btn2.setBounds(300, 400, 100, 30);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MusicianDash.main(new String[] {});
			}
		});
		add(btn2);

		setVisible(true);
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddAlbum();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}