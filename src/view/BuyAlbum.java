package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DBHelpers.MusicianSQL;

public class BuyAlbum extends BaseFrame{

	private static final long serialVersionUID = 1L;

	static BuyAlbum frame;
	JLabel Id, title;
	JTextField tid;
	JButton btn, btn2;

	BuyAlbum() {
		setLayout(null);
		setResizable(false);
		setSize(600, 400);

		setTitle("Buy Album");
		title = new JLabel("Choose Album", JLabel.CENTER);
		title.setFont(SwingHelper.customFont(20));
		title.setBounds(100, 15, 400, 40);
		add(title);

		

	    String alb[]={"Nature","Disco Deewane","Vande mataram","Vaazhkai","25"};        
	    final JComboBox cb=new JComboBox(alb);    
	    cb.setBounds(200, 120, 200, 30);
	    add(cb);


		btn2 = new JButton("Back");
		btn2.setBounds(300, 250, 100, 30);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BuyerSpace.main(new String[] {});
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
		
		add(btn);
		add(btn2);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BuyAlbum();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}