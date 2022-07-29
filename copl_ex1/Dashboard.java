package copl_ex1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	JLabel lbluserT;
	private JTable tableView;
	private JTextField txtStudentNo;
	private JTextField txtStudentName;
	private JTextField txtAddress;
	private JTextField txtSearch;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Dashboard() {
		setTitle("Student Record System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT RECORD SYSTEM");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblNewLabel.setBounds(98, 28, 318, 53);
		contentPane.add(lblNewLabel);
		
		lbluserT = new JLabel();
		lbluserT.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		lbluserT.setBounds(693, 8, 140, 29);
		contentPane.add(lbluserT);
		
		tableView = new JTable();
		tableView.setBounds(447, 76, 386, 294);
		contentPane.add(tableView);
		
		
		
		JButton btnView = new JButton("VIEW");
		btnView.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRecords();
			}
		});
		
		
		
		btnView.setBounds(447, 381, 89, 23);
		contentPane.add(btnView);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(599, 381, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnDelete.setBounds(744, 381, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setBounds(16, 381, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(410, 50, 95, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(515, 48, 318, 20);
		contentPane.add(txtSearch);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\ICONS COPL\\medical-record.png"));
		lblNewLabel_4.setBounds(10, 11, 107, 70);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(16, 110, 400, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Number :");
		lblNewLabel_1.setBounds(6, 23, 134, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name :");
		lblNewLabel_2.setBounds(6, 48, 120, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Address :");
		lblNewLabel_3.setBounds(6, 84, 95, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnAdd.setBounds(145, 166, 89, 23);
		panel.add(btnAdd);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnClear.setBounds(299, 166, 89, 23);
		panel.add(btnClear);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(145, 83, 243, 72);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtStudentName = new JTextField();
		txtStudentName.setBounds(145, 49, 243, 23);
		panel.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		txtStudentNo = new JTextField();
		txtStudentNo.setBounds(145, 21, 243, 23);
		panel.add(txtStudentNo);
		txtStudentNo.setColumns(10);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRecord(); //call to the add method
			}
		});
	}
	
	
	//DB Connection
	static Connection connect() {
		try {
			//set the mysql driver
			String myDriver ="com.mysql.cj.jdbc.Driver";
			//Connection string
			String url = "jdbc:mysql://localhost:3306/copl_db";
			Class.forName(myDriver);
			return (Connection) DriverManager.getConnection(url,"root","");
		}catch(Exception e) {
			System.out.print("Cannot connect to the database...");
		}
		return null;
	}
	
	//ADD record method
	private void addRecord() {
		Connection con = connect();
		Calendar date = Calendar.getInstance();
		java.sql.Date datecreated = new java.sql.Date(date.getTime().getTime());
		
		try {
			String sql = "INSERT INTO student_tbl (student_no, student_name, address, date_created) VALUES(?,?,?,NOW())";
			
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, txtStudentNo.getText());
			ps.setString(2, txtStudentName.getText());
			ps.setString(3, txtAddress.getText());
			//ps.setDate(4, datecreated);
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Record successfully added...");
			clearTextfield();
		}catch(Exception e) {
			System.out.print("Error..." + e);
		}
	}
	
	//VIEW record method
	private void viewRecords(){
		Connection con = connect();
		DefaultTableModel mod = new DefaultTableModel();
		
		mod.addColumn("Number");
		mod.addColumn("Student No");
		mod.addColumn("Student Name");
		mod.addColumn("Address");
		mod.addColumn("Date of Registration");
		
		try {
			String sql = "SELECT * from student_tbl";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				mod.addRow(new Object[]{
					rs.getInt("id"),
					rs.getString("student_no"),
					rs.getString("student_name"),
					rs.getString("address"),
					rs.getString("date_created"),
					
				});
			}
			rs.close();
			st.close();
			con.close();
			
			tableView.setModel(mod);
			tableView.setAutoResizeMode(0);
			tableView.getColumnModel().getColumn(0).setPreferredWidth(10);
			tableView.getColumnModel().getColumn(1).setPreferredWidth(30);
			tableView.getColumnModel().getColumn(2).setPreferredWidth(30);
			tableView.getColumnModel().getColumn(3).setPreferredWidth(30);
			tableView.getColumnModel().getColumn(4).setPreferredWidth(20);
			
		}catch(Exception ex) {
			System.out.print("Error: " + ex);
		}
		
	}
	
	
	
	
	//Clear method
	private void clearTextfield() {
		txtStudentNo.setText("");
		txtStudentName.setText("");
		txtAddress.setText("");
	}
}