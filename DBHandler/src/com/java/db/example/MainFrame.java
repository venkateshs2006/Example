package com.java.db.example;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class MainFrame implements ActionListener {
private JFrame mainFrame;
private JButton addButton, updateButton, deleteButton, viewButton, selectAllButton,selectUpdateButton;
private JPanel actionPanel;
AddUserPanel addUserPanel;
UpdateUserPanel updateUserPanel;
SelectUpdateUserPanel selectUpdateUserPanel;
DeleteUserPanel deleteUserPanel;
ViewUserDetails viewUserDetails;
SelectAllUserPanel selectAllUserPanel;
DefaultTableModel model;
String[] columnNames = { "User ID", "User Name", "Password", "Email" };
MySQLAccess sqlAccess=new MySQLAccess();
List<User> userList=new ArrayList<User>();
MainFrame(){
	initUI();
}
public void initUI(){
	mainFrame =new JFrame();
	addButton=new JButton("ADD User");
	updateButton=new JButton("UserInput Update");
	selectUpdateButton=new JButton("SelectUpdate");
	deleteButton=new JButton("Delete User");
	viewButton=new JButton("Get User");
	selectAllButton=new JButton("Select All User");
	/* JPanel Declaration */
	addUserPanel=new AddUserPanel();
	updateUserPanel=new UpdateUserPanel();
	selectUpdateUserPanel=new SelectUpdateUserPanel();
	deleteUserPanel=new DeleteUserPanel();
	viewUserDetails=new ViewUserDetails();
	selectAllUserPanel=new SelectAllUserPanel();
	mainFrame.setLayout(new FlowLayout());
	actionPanel=new JPanel();
	actionPanel.setLayout(new FlowLayout());
	actionPanel.add(addButton);
	actionPanel.add(updateButton);
	actionPanel.add(selectUpdateButton);
	actionPanel.add(deleteButton);
	actionPanel.add(viewButton);
	actionPanel.add(selectAllButton);
	/* Registering for ActionListener */
	addButton.addActionListener(this);
	updateButton.addActionListener(this);
	selectUpdateButton.addActionListener(this);
	deleteButton.addActionListener(this);
	viewButton.addActionListener(this);
	selectAllButton.addActionListener(this);
	/* Frame Component */
	mainFrame.add(actionPanel);
	mainFrame.add(addUserPanel);
	mainFrame.add(updateUserPanel);
	mainFrame.add(selectUpdateUserPanel);
	mainFrame.add(deleteUserPanel);
	mainFrame.add(viewUserDetails);
	mainFrame.add(selectAllUserPanel);
	/* Frame Properties */
	mainFrame.setSize(700, 500);
	mainFrame.setResizable(false);
	mainFrame.setVisible(true);
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
}

public static void main(String[] args) {
		// TODO Auto-generated method stub
	new MainFrame();
MySQLAccess mySQLAccess=new MySQLAccess();
User user=mySQLAccess.viewUser(1);
System.out.println(user.toString());
List<User> myUserList=mySQLAccess.selectAllUser();
User users=myUserList.get(0);
System.out.println(users.toString());
/*User addUser=new User();
addUser.setUserId(2);
addUser.setUserName("HICT");
addUser.setPassword("HICET");
addUser.setEmail("contact@hct.com");
mySQLAccess.addUser(addUser);*/
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==addButton){
		updateUserPanel.setVisible(false);
		addUserPanel.setVisible(true);
		selectUpdateUserPanel.setVisible(false);
		deleteUserPanel.setVisible(false);
		viewUserDetails.setVisible(false);
		selectAllUserPanel.setVisible(false);
	}
	else if (e.getSource()==updateButton){
		addUserPanel.setVisible(false);
		updateUserPanel.setVisible(true);
		selectUpdateUserPanel.setVisible(false);
		deleteUserPanel.setVisible(false);
		viewUserDetails.setVisible(false);
		selectAllUserPanel.setVisible(false);
	}
	else if(e.getSource()==selectUpdateButton){
		updateUserPanel.setVisible(false);
		addUserPanel.setVisible(false);
		selectUpdateUserPanel.setVisible(true);
		deleteUserPanel.setVisible(false);
		viewUserDetails.setVisible(false);
		selectAllUserPanel.setVisible(false);
	}
	else if(e.getSource()==deleteButton){
		updateUserPanel.setVisible(false);
		addUserPanel.setVisible(false);
		selectUpdateUserPanel.setVisible(false);
		deleteUserPanel.setVisible(true);
		viewUserDetails.setVisible(false);
		selectAllUserPanel.setVisible(false);
	}
	else if(e.getSource()==viewButton){
		updateUserPanel.setVisible(false);
		addUserPanel.setVisible(false);
		selectUpdateUserPanel.setVisible(false);
		deleteUserPanel.setVisible(false);
		viewUserDetails.setVisible(true);
		selectAllUserPanel.setVisible(false);
	}
	else if(e.getSource()==selectAllButton){
		updateUserPanel.setVisible(false);
		addUserPanel.setVisible(false);
		selectUpdateUserPanel.setVisible(false);
		deleteUserPanel.setVisible(false);
		viewUserDetails.setVisible(false);
		selectAllUserPanel.setVisible(true);
		userList=sqlAccess.selectAllUser();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		for (User user : userList) {
			model.addRow(new Object[]{user.getUserId(), user.getUserName(), user.getPassword(), user.getEmail()});
		}		
		selectAllUserPanel.table.setModel(model);
	}
}

}
