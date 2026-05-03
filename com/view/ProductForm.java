package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProductForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField productName;
	private JTextField productPrice;
	private JComboBox<String> productCompany;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm frame = new ProductForm();
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
	public ProductForm() {
		setTitle("Product Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 364);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 128, 128));
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Product");
		lblNewLabel.setBackground(new Color(64, 128, 128));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 28, 252, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 73, 120, 29);
		contentPane.add(lblNewLabel_1);
		
		productName = new JTextField();
		productName.setForeground(new Color(64, 128, 128));
		productName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productName.setBounds(161, 73, 180, 28);
		contentPane.add(productName);
		productName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Product Price");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 129, 120, 29);
		contentPane.add(lblNewLabel_2);
		
		productPrice = new JTextField();
		productPrice.setForeground(new Color(64, 128, 128));
		productPrice.setBounds(161, 132, 180, 27);
		contentPane.add(productPrice);
		productPrice.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Product Company");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(20, 186, 131, 35);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get values from productForm and set to product object.
				Product p = new Product();
				
				p.setName(productName.getText());
				p.setPrice(Integer.parseInt(productPrice.getText()));
				p.setCompany(productCompany.getSelectedItem().toString());
				
				ProductService service = new ProductServiceImpl();
				service.addProduct(p);
				
				JOptionPane.showMessageDialog(null, "added success!");
			}
		});
		btnNewButton.setForeground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(161, 249, 99, 29);
		contentPane.add(btnNewButton);
		
		productCompany = new JComboBox<>();
		productCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productCompany.setModel(new DefaultComboBoxModel(new String[] {"select", "Dell", "CG", "Samsung", "Apple"}));
		productCompany.setForeground(new Color(64, 128, 128));
		productCompany.setBounds(161, 188, 185, 35);
		contentPane.add(productCompany);

	}
}
