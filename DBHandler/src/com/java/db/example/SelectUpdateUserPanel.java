package com.java.db.example;

	import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

	public class SelectUpdateUserPanel extends JPanel implements ActionListener,ItemListener {
		private JButton submitButton,cancelButton;
		private JLabel lblUserID, lblUserName, lblPassword, lblEmail, lblHeader, lblEmpty;
		private JTextField  txtUserName, txtPassword, txtEmail;
		private JComboBox<String> jcUserID;
		MySQLAccess sqlAccess=new MySQLAccess();
		List<User> userList=new ArrayList<User>();
		public SelectUpdateUserPanel() {
			// TODO Auto-generated constructor stub
			lblHeader=new JLabel("Update User");
			lblHeader.setHorizontalAlignment(SwingConstants.RIGHT);
			lblEmpty=new JLabel("");
			lblUserID=new JLabel("User ID");
			lblUserName=new JLabel("UserName");
			lblPassword=new JLabel("Password");
			lblEmail=new JLabel("Email Address");
			userList=sqlAccess.selectAllUser();
			jcUserID=new JComboBox<String>();
			for (User user : userList) {
				jcUserID.addItem(user.getUserId()+"");
			}		
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
			add(jcUserID);
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
			jcUserID.addItemListener(this);
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
				user.setUserId(Integer.parseInt(jcUserID.getSelectedItem().toString()));
				user.setUserName(txtUserName.getText());
				user.setPassword(txtPassword.getText());
				user.setEmail(txtEmail.getText());
				if(mySQLAccess.updateUser(user)){
					JOptionPane.showMessageDialog(null, "User Details Updated Successfully");		
					jcUserID.setSelectedIndex(0);
					txtUserName.setText("");
					txtPassword.setText("");
					txtEmail.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Check the user Details. Database Updation Failed");
				}
			}
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				int userid=Integer.parseInt(jcUserID.getSelectedItem().toString());
				User viewUserResult=sqlAccess.viewUser(userid);
				txtUserName.setText(viewUserResult.getUserName());
				txtPassword.setText(viewUserResult.getPassword());
				txtEmail.setText(viewUserResult.getEmail());
			}
		}
		
	}


