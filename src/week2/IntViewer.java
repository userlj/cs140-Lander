package week2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntViewer {
	private static final int INT_BITS = 32;
	private static final int LONG_BITS = 64;
	private static final int BIGGER_BITS = 100;
	private JFrame frame = new JFrame("Int/Long/BigInteger value of factorial(0)");
	private JPanel panel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JTextField[] intBits = new JTextField[128];
	private JTextField[] longBits = new JTextField[128];
	private JTextField[] bigBits = new JTextField[128];
	private JButton buttonUp = new JButton("Click to show next factorial");
	private JButton buttonDown = new JButton("Click to previous factorial");
	private int currentNum = 0;

	/**
	 * Compute the factorial of the input value as an int if the
	 * input is positive or zero. If the input is negative the    
	 * function returns the <em>erroneous</em> value 1.
	 * The code uses a loop with the invariant:
	 * retVal = (count-1)!
	 * @param input positive or 0 value to compute factorial
	 * @return the int value of the factorial of the input
	 */
	public static int factorial1(int input) {
		int retVal = 1;
		int count = 1;
		while (count <= input) {
			retVal = count * retVal;
			count = count + 1;
		}
		return retVal;
	}

	/**
	 * Compute the factorial of the input value as a long if the
	 * input is positive or zero. If the input is negative the
	 * function returns the <em>erroneous</em> value 1.
	 * The code uses a loop with the invariant:
	 * retVal = (count-1)!
	 * The code uses abbreviated operators "*=" and "++".
	 * @param input positive or 0 value to compute factorial
	 * @return the long value of the factorial of the input
	 */
	public static long factorial2(int input) {
		long retVal = 1;
		int count = 1;
		while (count <= input) {
			retVal *= count;
			count++;
		}
		return retVal;
	}

	/**
	 * Compute the factorial of the input value as a BigInteger if the
	 * input is positive or zero. If the input is negative the
	 * function returns the <em>erroneous</em> value 1.
	 * The code uses a loop with the invariant:
	 * retVal = (count-1)!
	 * @param input positive or 0 value to compute factorial
	 * @return the BigInteger value of the factorial of the input
	 */
	public static BigInteger factorial3(int input) {
		BigInteger retVal = BigInteger.ONE;
		int count = 1;
		while (count <= input) {
			retVal = retVal.multiply(BigInteger.valueOf(count));
			count++;
		}
		return retVal;
	}

	public IntViewer() {
		panel.setLayout(new GridLayout(3,128));
		buttonPanel.setLayout(new GridLayout(1,0));
		frame.add(panel);
		frame.add(buttonPanel, BorderLayout.PAGE_END);
		for(int i = 0; i < BIGGER_BITS; i++) {
			intBits[i] = new JTextField(" ");
			if(i > BIGGER_BITS - INT_BITS - 1) {
				intBits[i].setText("0");
				intBits[i].setBackground(Color.YELLOW);
			}
			panel.add(intBits[i]);
		}
		intBits[BIGGER_BITS-1].setText("1");
		for(int i = 0; i < BIGGER_BITS; i++) {
			longBits[i] = new JTextField(" ");
			if(i > BIGGER_BITS - LONG_BITS - 1) {
				longBits[i].setText("0");
				longBits[i].setBackground(Color.YELLOW);
			}
			panel.add(longBits[i]);
		}
		longBits[BIGGER_BITS-1].setText("1");
		for(int i = 0; i < BIGGER_BITS; i++) {
			bigBits[i] = new JTextField("0");
			bigBits[i].setBackground(Color.YELLOW);
			panel.add(bigBits[i]);
		}
		bigBits[BIGGER_BITS-1].setText("1");
		buttonPanel.add(buttonUp);
		buttonPanel.add(buttonDown);
		buttonUp.addActionListener(new UpListener());
		buttonDown.addActionListener(new DownListener());
		buttonDown.setEnabled(false);				
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new IntViewer(); 
			}
		});		
	}

	public class UpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			currentNum++;
			buttonDown.setEnabled(true);				
			frame.setTitle("Int/Long/BigInteger value of factorial(" + 
					currentNum + ")");
			String str = Integer.toBinaryString(factorial1(currentNum));
			for(int i = BIGGER_BITS - INT_BITS; i < BIGGER_BITS; i++) {
				intBits[i].setText("0");
			}
			for(int i = 0; i < str.length(); i++) {
				intBits[BIGGER_BITS - str.length() + i].setText(""+str.charAt(i));
			}
			str = Long.toBinaryString(factorial2(currentNum));
			for(int i = BIGGER_BITS - LONG_BITS; i < BIGGER_BITS; i++) {
				longBits[i].setText("0");
			}
			for(int i = 0; i < str.length(); i++) {
				longBits[BIGGER_BITS - str.length() + i].setText(""+str.charAt(i));
			}
			str = factorial3(currentNum).toString(2);
			for(int i = 0; i < BIGGER_BITS; i++) {
				bigBits[i].setText("0");
			}
			for(int i = 0; i < str.length(); i++) {
				if(BIGGER_BITS - str.length() + i >= 0) {
					bigBits[BIGGER_BITS - str.length() + i].setText(""+str.charAt(i));
				} else {
					System.out.println(str);
					System.out.println(factorial3(currentNum));					
				}
			}
		}
	}

	public class DownListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			currentNum--;
			if(currentNum == 0) {
				buttonDown.setEnabled(false);
			} else {
				buttonDown.setEnabled(true);				
			}
			frame.setTitle("Int/Long/BigInteger value of factorial(" + 
					currentNum + ")");
			String str = Integer.toBinaryString(factorial1(currentNum));
			for(int i = BIGGER_BITS - INT_BITS; i < BIGGER_BITS; i++) {
				intBits[i].setText("0");
			}
			for(int i = 0; i < str.length(); i++) {
				intBits[BIGGER_BITS - str.length() + i].setText(""+str.charAt(i));
			}
			str = Long.toBinaryString(factorial2(currentNum));
			for(int i = BIGGER_BITS - LONG_BITS; i < BIGGER_BITS; i++) {
				longBits[i].setText("0");
			}
			for(int i = 0; i < str.length(); i++) {
				longBits[BIGGER_BITS - str.length() + i].setText(""+str.charAt(i));
			}
			str = factorial3(currentNum).toString(2);
			for(int i = 0; i < BIGGER_BITS; i++) {
				bigBits[i].setText("0");
			}
			for(int i = 0; i < str.length(); i++) {
				if(BIGGER_BITS - str.length() + i >= 0) {
					bigBits[BIGGER_BITS - str.length() + i].setText(""+str.charAt(i));
				} else {
					System.out.println(str);
					System.out.println(factorial3(currentNum));					
				}
			}
		}
	}

}
