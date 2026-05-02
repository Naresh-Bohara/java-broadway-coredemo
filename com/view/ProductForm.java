package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProductForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField productName;
	private JTextField productPrice;
	private JTextField productCompany;

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
		
		productCompany = new JTextField();
		productCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productCompany.setForeground(new Color(64, 128, 128));
		productCompany.setBounds(161, 191, 180, 29);
		contentPane.add(productCompany);
		productCompany.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Product");
		btnNewButton.setForeground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(161, 249, 99, 29);
		contentPane.add(btnNewButton);

	}
}
