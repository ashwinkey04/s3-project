package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import view.AdminLogin;
import view.BaseFrame;
import view.MusicianLogin;
import view.SwingHelper;

public class ProjectDriver extends BaseFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ProjectDriver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProjectDriver() {
		super(); //Calls BaseFrame's constructor

		JLabel lblProjectDriverManagement = new JLabel("Recording Company Mgmt");
		lblProjectDriverManagement.setFont(SwingHelper.customFont(18));
		lblProjectDriverManagement.setForeground(Color.GRAY);

		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[] {});
				frame.dispose();
			}
		});
		btnAdminLogin.setFont(SwingHelper.customFont(15));

		JButton btnLibrarianLogin = new JButton("Musician Login");
		btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MusicianLogin.main(new String[] {});
			}
		});
		btnLibrarianLogin.setFont(SwingHelper.customFont(15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(64)
								.addComponent(lblProjectDriverManagement))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(140)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnLibrarianLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnAdminLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135,
												Short.MAX_VALUE))))
				.addContainerGap(95, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(lblProjectDriverManagement).addGap(32)
								.addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLibrarianLogin,
										GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(70, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
