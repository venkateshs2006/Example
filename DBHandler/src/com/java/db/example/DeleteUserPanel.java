package com.java.db.example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeleteUserPanel extends JPanel implements ActionListener {
	private JButton submitButton,cancelButton;
	private JLabel lblUserID, lblHeader, lblEmpty;
	private JTextField txtUserID;
	public DeleteUserPanel() {
		// TODO Auto-generated constructor stub
		lblHeader=new JLabel("Delete User");
		lblHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpty=new JLabel("");
		lblUserID=new JLabel("User ID");
		txtUserID=new JTextField(20);
		submitButton=new JButton("Submit");
		cancelButton=new JButton("Cancel");
		setSize(400,400);
		setLayout(new GridLayout(3,2));
		add(lblHeader);
		add(lblEmpty);
		add(lblUserID);
		add(txtUserID);
		add(submitButton);
		add(cancelButton);
		setVisible(false);
		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MySQLAccess mySQLAccess=new MySQLAccess();
		User user=new User();
		if(e.getSource()==cancelButton){
			setVisible(false);
		}
		if(e.getSource()==submitButton){
			if(mySQLAccess.deleteUser(Integer.parseInt(txtUserID.getText()))){
				JOptionPane.showMessageDialog(null, "User Details removed from database.");		
				txtUserID.setText("");
			}
			else{
				JOptionPane.showMessageDialog(null, "Please Check the user Details. Database Updation Failed");
			}
		}
	}
}
