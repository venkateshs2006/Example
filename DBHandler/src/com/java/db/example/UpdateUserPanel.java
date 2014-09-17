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

public class UpdateUserPanel extends JPanel implements ActionListener {
	private JButton submitButton,cancelButton;
	private JLabel lblUserID, lblUserName, lblPassword, lblEmail, lblHeader, lblEmpty;
	private JTextField txtUserID, txtUserName, txtPassword, txtEmail;
	public UpdateUserPanel() {
		// TODO Auto-generated constructor stub
		lblHeader=new JLabel("Update User");
		lblHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpty=new JLabel("");
		lblUserID=new JLabel("User ID");
		lblUserName=new JLabel("UserName");
		lblPassword=new JLabel("Password");
		lblEmail=new JLabel("Email Address");
		txtUserID=new JTextField(20);
		txtUserName=new JTextField(20);
		txtPassword=new JTextField(20);
		txtEmail=new JTextField(20);
		submitButton=new JButton("Submit");
		cancelButton=new JButton("Cancel");
		setSize(400,400);
		setLayout(new GridLayout(6,2));
		add(lblHeader);
		add(lblEmpty);
		add(lblUserID);
		add(txtUserID);
		add(lblUserName);
		add(txtUserName);
		add(lblPassword);
		add(txtPassword);
		add(lblEmail);
		add(txtEmail);
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
			user.setUserId(Integer.parseInt(txtUserID.getText()));
			user.setUserName(txtUserName.getText());
			user.setPassword(txtPassword.getText());
			user.setEmail(txtEmail.getText());
			if(mySQLAccess.updateUser(user)){
				JOptionPane.showMessageDialog(null, "User Details Updated Successfully");		
				txtUserID.setText("");
				txtUserName.setText("");
				txtPassword.setText("");
				txtEmail.setText("");
			}
			else{
				JOptionPane.showMessageDialog(null, "Please Check the user Details. Database Updation Failed");
			}
		}
	}
}
