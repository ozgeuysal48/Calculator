package paket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Calculator extends JFrame {

	protected static final String Convert = null;
	private JPanel contentPane;
	private JTextField input;
	private double answer, number;
	int operation;
	int minuspos = 1;
	boolean comma = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addinput(String str) {
		
			input.setText(input.getText() + str); 
		
		
	}

	public void hesapla() {
		try {
			switch (operation) {
			case 1:
				answer = number + Double.parseDouble(input.getText());
				input.setText(Double.toString(answer));
				break;
			case 2:
				answer = number - Double.parseDouble(input.getText());
				input.setText(Double.toString(answer));
				break;
			case 3:
				answer = number * Double.parseDouble(input.getText());
				input.setText(Double.toString(answer));
				break;
			case 4:
				answer = number / Double.parseDouble(input.getText());
				input.setText(Double.toString(answer));
				break;
			case 5:
				answer = (number * Double.parseDouble(input.getText())) / 100;
				input.setText(Double.toString(answer));
				break;

			}
		} catch (Exception e) {

			input.setText("Sadece Sayi giriniz!");
		}
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel screen = new JPanel();
		screen.setBounds(10, 11, 364, 60);
		contentPane.add(screen);
		screen.setLayout(null);

		input = new JTextField();
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setFont(new Font("Tahoma", Font.BOLD, 23));
		input.setBounds(0, 22, 364, 38);
		screen.add(input);
		input.setColumns(10);

		JLabel lbl = new JLabel("");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl.setBounds(0, 0, 364, 20);
		screen.add(lbl);

		JPanel control = new JPanel();
		control.setBounds(10, 82, 364, 414);
		contentPane.add(control);

		JButton btnNewButton = new JButton("7");
		btnNewButton.setBackground(SystemColor.textInactiveText);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(0, 138, 91, 69);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});

		JButton btnNewButton_1_4_1_1_1_2_1_1 = new JButton("C");
		btnNewButton_1_4_1_1_1_2_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_4_1_1_1_2_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1_1_2_1_1.setBounds(182, 0, 91, 69);
		btnNewButton_1_4_1_1_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});

		JButton btnNewButton_2 = new JButton("1/x");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(0, 0, 91, 69);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = 1 / Double.parseDouble(input.getText());
				input.setText(Double.toString(result));
			}
		});
		control.setLayout(null);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_2);

		JButton btnNewButton_2_1_1_1 = new JButton("n!");
		btnNewButton_2_1_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1_1.setBounds(91, 0, 91, 69);
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double n = Double.parseDouble(input.getText());
					double result = 1;
					for (int i = 2; i <= n; i++) {
						result *= i;
					}
					input.setText(Double.toString(result));
				} catch (NumberFormatException ex) {
					input.setText("Sadece sayı giriniz!");
				}

			}
		});
		btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_2_1_1_1);
		btnNewButton_1_4_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_4_1_1_1_2_1_1);

		JButton btnNewButton_3_1 = new JButton("\u2190 ");
		btnNewButton_3_1.setBackground(Color.DARK_GRAY);
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = input.getText().length();
				int number = input.getText().length() - 1;
				String depo;

				if (length > 0) {
					StringBuilder back = new StringBuilder(input.getText());
					back.deleteCharAt(number);
					depo = back.toString();
					input.setText(depo);

				}
			}
		});
		btnNewButton_3_1.setBounds(273, 0, 91, 69);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		control.add(btnNewButton_3_1);

		JButton btnNewButton_2_1_1 = new JButton("x\u00B2");
		btnNewButton_2_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setBounds(0, 69, 91, 69);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = Math.pow(Double.parseDouble(input.getText()), 2);
				input.setText(Double.toString(result));
				
			}
		});
		control.add(btnNewButton_2_1_1);

		JButton btnNewButton_2_1 = new JButton("\u221Ax");
		btnNewButton_2_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBounds(91, 69, 91, 69);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = Math.sqrt(Double.parseDouble(input.getText()));
				input.setText(Double.toString(result));
			}
		});
		control.add(btnNewButton_2_1);

		JButton btnNewButton_3 = new JButton("%");
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 5;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
				minuspos = 1;
			}
		});
		btnNewButton_3.setBounds(182, 69, 91, 69);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_3);

		JButton btnNewButton_1_4_1_1_1_2_1_1_1 = new JButton("\u00F7");
		btnNewButton_1_4_1_1_1_2_1_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_4_1_1_1_2_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1_1_2_1_1_1.setBounds(273, 69, 91, 69);
		btnNewButton_1_4_1_1_1_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 4;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
				minuspos = 1;
			}
		});
		btnNewButton_1_4_1_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_4_1_1_1_2_1_1_1);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton);

		JButton btnNewButton_1_1 = new JButton("8");
		btnNewButton_1_1.setBackground(SystemColor.textInactiveText);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBounds(91, 138, 91, 69);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("9");
		btnNewButton_1_2.setBackground(SystemColor.textInactiveText);
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setBounds(182, 138, 91, 69);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton_1_2);

		JButton btnNewButton_1 = new JButton("4");
		btnNewButton_1.setBackground(SystemColor.textInactiveText);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(0, 207, 91, 69);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});

		JButton btnNewButton_1_4_1_1_1_1_1 = new JButton("x");
		btnNewButton_1_4_1_1_1_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_4_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1_1_1_1.setBounds(273, 138, 91, 69);
		btnNewButton_1_4_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 3;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
				minuspos = 1;
			}
		});
		btnNewButton_1_4_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_4_1_1_1_1_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton_1);

		JButton btnNewButton_1_4_1 = new JButton("5");
		btnNewButton_1_4_1.setBackground(SystemColor.textInactiveText);
		btnNewButton_1_4_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1.setBounds(91, 207, 91, 69);
		btnNewButton_1_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});
		btnNewButton_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton_1_4_1);

		JButton btnNewButton_1_4 = new JButton("6");
		btnNewButton_1_4.setBackground(SystemColor.textInactiveText);
		btnNewButton_1_4.setForeground(Color.WHITE);
		btnNewButton_1_4.setBounds(182, 207, 91, 69);
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton_1_4);

		JButton btnNewButton_1_4_1_1_1 = new JButton("1");
		btnNewButton_1_4_1_1_1.setBackground(SystemColor.textInactiveText);
		btnNewButton_1_4_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1_1.setBounds(0, 276, 91, 69);
		btnNewButton_1_4_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});

		JButton btnNewButton_1_3 = new JButton("+");
		btnNewButton_1_3.setBackground(Color.DARK_GRAY);
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setBounds(273, 207, 91, 69);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					number = Double.parseDouble(input.getText());
					operation = 1;
					input.setText("");
					lbl.setText(number + e.getActionCommand());
				} catch (NumberFormatException ex) {
					input.setText("Sadece sayi giriniz!");
				}

			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_3);
		btnNewButton_1_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton_1_4_1_1_1);

		JButton btnNewButton_1_4_1_1_1_2 = new JButton("2");
		btnNewButton_1_4_1_1_1_2.setBackground(SystemColor.textInactiveText);
		btnNewButton_1_4_1_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1_1_2.setBounds(91, 276, 91, 69);
		btnNewButton_1_4_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});
		btnNewButton_1_4_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton_1_4_1_1_1_2);

		JButton btnNewButton_1_4_1_1 = new JButton("3");
		btnNewButton_1_4_1_1.setBackground(SystemColor.textInactiveText);
		btnNewButton_1_4_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1.setBounds(182, 276, 91, 69);
		btnNewButton_1_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});
		btnNewButton_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton_1_4_1_1);

		JButton btnNewButton_1_4_1_1_1_1 = new JButton("-");
		btnNewButton_1_4_1_1_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_4_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1_1_1.setBounds(273, 276, 91, 69);
		btnNewButton_1_4_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 2;
				input.setText("");
				lbl.setText(number + e.getActionCommand());
				minuspos = 1;
			}
		});
		btnNewButton_1_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_4_1_1_1_1);

		JButton btnNewButton_3_1_1_1 = new JButton(",");
		btnNewButton_3_1_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_3_1_1_1.setForeground(Color.WHITE);
		btnNewButton_3_1_1_1.setBounds(0, 345, 91, 69);
		btnNewButton_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(! input.getText().contains(".")) {
					addinput(".");
				}
			}
		});
		control.add(btnNewButton_3_1_1_1);

		JButton btnNewButton_1_4_1_1_1_1_1_1 = new JButton("0");
		btnNewButton_1_4_1_1_1_1_1_1.setBackground(SystemColor.textInactiveText);
		btnNewButton_1_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_4_1_1_1_1_1_1.setBounds(91, 345, 91, 69);
		btnNewButton_1_4_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinput(e.getActionCommand());
			}
		});
		btnNewButton_1_4_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		control.add(btnNewButton_1_4_1_1_1_1_1_1);

		JButton btnNewButton_4 = new JButton("=");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.BLUE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hesapla();
				lbl.setText("");

			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_4.setBounds(273, 345, 91, 69);
		control.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("+/-");
		btnNewButton_5.setBackground(Color.DARK_GRAY);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuspos *= -1;
				if(minuspos == -1) {
					input.setText("-");
				}
			}
		});
		btnNewButton_5.setBounds(182, 345, 91, 69);
		control.add(btnNewButton_5);
	}
}
