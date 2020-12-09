package view;

import javax.swing.*;

import DBHelpers.SongSQL;
import model.Song;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AddSong extends BaseFrame {
	
	static AddSong frame;
	JLabel title, song_id, alb_id, m_id, song_name, singer, duration, genre, ly_id;
	JTextField ttitle, tsong_id, talb_id, tm_id, tsong_name, tsinger, tduration, tgenre, tly_id;
	JButton btn1, btn2;

	AddSong() {
		setLayout(null);
		setResizable(false);
		setSize(600, 500);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

		setTitle("Registration Form ");
		title = new JLabel("Enter Song Details", JLabel.CENTER);
		title.setFont(new Font("Arial", Font.PLAIN, 25));
		title.setBounds(100, 20, 400, 40);
		add(title);

		song_id = new JLabel("Song ID");
		tsong_id = new JTextField();
		song_id.setFont(new Font("Arial", Font.PLAIN, 20));
		song_id.setBounds(150, 70, 200, 30);
		tsong_id.setBounds(300, 70, 200, 30);
		add(song_id);
		add(tsong_id);

		alb_id = new JLabel("Album Id:");
		talb_id = new JTextField();
		alb_id.setFont(new Font("Arial", Font.PLAIN, 20));
		alb_id.setBounds(150, 110, 200, 30);
		talb_id.setBounds(300, 110, 200, 30);
		add(alb_id);
		add(talb_id);

		m_id = new JLabel("Music ID");
		tm_id = new JTextField();
		m_id.setFont(new Font("Arial", Font.PLAIN, 20));
		m_id.setBounds(150, 150, 200, 30);
		tm_id.setBounds(300, 150, 200, 30);
		add(m_id);
		add(tm_id);

		song_name = new JLabel("Song Name");
		tsong_name = new JTextField();
		song_name.setFont(new Font("Arial", Font.PLAIN, 20));
		song_name.setBounds(150, 190, 200, 30);
		tsong_name.setBounds(300, 190, 200, 30);
		add(song_name);
		add(tsong_name);

		singer = new JLabel("Singer");
		tsinger = new JTextField();
		singer.setFont(new Font("Arial", Font.PLAIN, 20));
		singer.setBounds(150, 230, 200, 30);
		tsinger.setBounds(300, 230, 200, 30);
		add(singer);
		add(tsinger);

		duration = new JLabel("Duration ");
		tduration = new JTextField();
		duration.setFont(new Font("Arial", Font.PLAIN, 20));
		duration.setBounds(150, 270, 200, 30);
		tduration.setBounds(300, 270, 200, 30);
		add(duration);
		add(tduration);

		genre = new JLabel("Genre");
		tgenre = new JTextField();
		genre.setFont(new Font("Arial", Font.PLAIN, 20));
		genre.setBounds(150, 310, 200, 30);
		tgenre.setBounds(300, 310, 200, 30);
		add(genre);
		add(tgenre);

		ly_id = new JLabel("Lyricist ID");
		tly_id = new JTextField();
		ly_id.setFont(new Font("Arial", Font.PLAIN, 20));
		ly_id.setBounds(150, 350, 200, 30);
		tly_id.setBounds(300, 350, 200, 30);
		add(ly_id);
		add(tly_id);

		btn1 = new JButton("Submit");
		btn1.setBounds(175, 400, 100, 30);

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tsong_id.getText() == null || talb_id.getText() == null || tm_id.getText() == null
						|| tsong_name.getText() == null || tsinger.getText() == null || tduration.getText() == null) {
					JOptionPane.showMessageDialog(frame, "No empty values allowed ");
				} else {
					String name = tsong_name.getText();
					String albid = talb_id.getText();
					String mid= tm_id.getText();
					String singer = tsinger.getText();
					String songid = tsong_id.getText();
					String duration = tduration.getText();
					String genre = tgenre.getText();
					String ly_id = tly_id.getText();

					Song song = new Song(songid, albid, mid, name, singer, duration,genre,ly_id);
					try {
						SongSQL.insert(song);
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Added Song " + name + " successfully!");
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
					frame = new AddSong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}