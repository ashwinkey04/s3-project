package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.ProjectDriver;

public class AdminDash extends BaseFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminDash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminDash() {
		super(); // Calls BaseFrame's constructor
		setMinimumSize(new Dimension(200,540));
		setTitle("Admin dashboard");
		JLabel lblAdminSection = new JLabel("Admin Dash");
		lblAdminSection.setFont(SwingHelper.customFont(20));
		lblAdminSection.setForeground(Color.GRAY);

		JButton btnAddMusician = new JButton("Add Musician");
		btnAddMusician.setFont(SwingHelper.customFont(15));
		btnAddMusician.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMusician.main(new String[] {});
				frame.dispose();
			}
		});

		JButton btnLicenseMusician = new JButton("License Musician");
		btnLicenseMusician.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LicenseMusician.main(new String[] {});
				frame.dispose();
			}
		});
		btnLicenseMusician.setFont(SwingHelper.customFont(15));

		JButton btnDeleteMusician = new JButton("Delete Musician");
		btnDeleteMusician.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteMusician.main(new String[] {});
				frame.dispose();
			}
		});
		btnDeleteMusician.setFont(SwingHelper.customFont(15));

		JButton btnAddLyricist = new JButton("Add Lyricist");
		btnAddLyricist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLyricist.main(new String[] {});
				frame.dispose();
			}
		});
		btnAddLyricist.setFont(SwingHelper.customFont(15));

		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaff.main(new String[] {});
				frame.dispose();
			}
		});
		btnAddStaff.setFont(SwingHelper.customFont(15));

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProjectDriver.main(new String[] {});
				frame.dispose();
				JOptionPane.showMessageDialog(frame, "Logged out" + " successfully!");
			}
		});
		btnLogout.setFont(SwingHelper.customFont(15));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane
								.createSequentialGroup().addContainerGap(150, Short.MAX_VALUE)
								.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 151,
										GroupLayout.PREFERRED_SIZE)
								.addGap(123))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(134)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDeleteMusician, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLicenseMusician, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAddMusician, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAddStaff, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAddLyricist, GroupLayout.PREFERRED_SIZE, 181,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(109, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(11)
				.addComponent(btnAddMusician, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnLicenseMusician, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnAddStaff, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnAddLyricist, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnDeleteMusician, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(21, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
