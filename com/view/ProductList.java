package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProductList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField productNameTxt;
	private JTextField productPriceTxt;
	private int pid;
	private JTextField searchTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList frame = new ProductList();
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
	public ProductList() {
		setTitle("Product List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 413);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 128, 128));
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 50, 476, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Price", "Company"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Product List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(298, 16, 183, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "select any row!");
					return;
				}
				
				int srow = table.getSelectedRow();
				int pid = (int) table.getModel().getValueAt(srow, 0);
				
				ProductService service = new ProductServiceImpl();
				service.deleteProduct(pid);
				JOptionPane.showMessageDialog(null, "deleted success!");
				displayData();
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(690, 302, 85, 29);
		contentPane.add(btnNewButton);
		
		JLabel productName = new JLabel("Name");
		productName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productName.setForeground(new Color(255, 255, 255));
		productName.setBounds(28, 54, 104, 24);
		contentPane.add(productName);
		
		productNameTxt = new JTextField();
		productNameTxt.setBounds(105, 50, 168, 35);
		contentPane.add(productNameTxt);
		productNameTxt.setColumns(10);
		
		JLabel productPrice = new JLabel("Price\r\n");
		productPrice.setForeground(Color.WHITE);
		productPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productPrice.setBounds(28, 98, 104, 24);
		contentPane.add(productPrice);
		
		productPriceTxt = new JTextField();
		productPriceTxt.setColumns(10);
		productPriceTxt.setBounds(105, 95, 168, 35);
		contentPane.add(productPriceTxt);
		
		JLabel productCompany = new JLabel("Company");
		productCompany.setForeground(Color.WHITE);
		productCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productCompany.setBounds(28, 147, 104, 24);
		contentPane.add(productCompany);
		
		JComboBox productCompanyCmb = new JComboBox();
		productCompanyCmb.setForeground(new Color(64, 128, 128));
		productCompanyCmb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		productCompanyCmb.setModel(new DefaultComboBoxModel(new String[] {"---select---", "apple", "redmi", "nokia", "cg"}));
		productCompanyCmb.setBounds(105, 144, 168, 35);
		contentPane.add(productCompanyCmb);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product p = new Product();
				p.setId(pid);
				p.setName(productNameTxt.getText());
				p.setPrice(Integer.parseInt(productPriceTxt.getText()));
				p.setCompany(productCompanyCmb.getSelectedItem().toString());
				
				ProductService service = new ProductServiceImpl();
				service.updateProduct(p);
				JOptionPane.showMessageDialog(null, "update success!");
				displayData();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setForeground(new Color(64, 128, 128));
		btnNewButton_1.setBounds(182, 193, 91, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "select any row!");
					return;
				}
				
				int srow = table.getSelectedRow();
				pid = (int) table.getModel().getValueAt(srow, 0);
				productNameTxt.setText(table.getModel().getValueAt(srow, 1).toString());
				productPriceTxt.setText(table.getModel().getValueAt(srow, 2).toString());
				productCompanyCmb.setSelectedItem(table.getModel().getValueAt(srow, 3));
			}
		});
		btnEdit.setForeground(new Color(64, 128, 128));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBounds(595, 302, 85, 29);
		contentPane.add(btnEdit);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(507, 16, 73, 18);
		contentPane.add(lblNewLabel_1);
		
		searchTxt = new JTextField();
		searchTxt.setBounds(563, 16, 161, 24);
		contentPane.add(searchTxt);
		searchTxt.setColumns(10);
		
		displayData();
	}
	
	// displaly data in jTable
	private void displayData() {
		ProductService service = new ProductServiceImpl();
		List<Product> plist = service.getAllProducts();
		
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0); // table data reset
		
		for(Product prod: plist) {
			tmodel.addRow(new Object[] {prod.getId(), prod.getName(), prod.getPrice(), prod.getCompany()});
		}
	}
}
