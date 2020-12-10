package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

import main.ProjectDriver;

public class BuyerSpace extends BaseFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BuyerSpace();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BuyerSpace() {
		super(); // Calls BaseFrame's constructor

		setTitle("Buyer Space");
		JLabel lblMusicianSection = new JLabel("Buyer Space");
		lblMusicianSection.setFont(SwingHelper.customFont(20));
		lblMusicianSection.setForeground(Color.GRAY);

		JButton btnAddAlb = new JButton("Buy Album");
		btnAddAlb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuyAlbum.main(new String[] {});
				frame.dispose();
			}
		});
		btnAddAlb.setFont(SwingHelper.customFont(15));

		JButton btnLogout = new JButton("Back");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProjectDriver.main(new String[] {});
				frame.dispose();
			}
		});
		
		btnLogout.setFont(SwingHelper.customFont(15));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane
								.createSequentialGroup().addContainerGap(150, Short.MAX_VALUE)
								.addComponent(lblMusicianSection, GroupLayout.PREFERRED_SIZE, 151,
										GroupLayout.PREFERRED_SIZE)
								.addGap(123))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(134)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAddAlb, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(109, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblMusicianSection, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnAddAlb, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(21, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
