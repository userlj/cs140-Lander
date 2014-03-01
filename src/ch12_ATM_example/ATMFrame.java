package ch12_ATM_example;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
   A frame displaying the components of an ATM.
 */
public class ATMFrame extends JFrame {  
	private static final long serialVersionUID = -2761560096023000333L;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 300;

	private JButton aButton;
	private JButton bButton;
	private JButton cButton;

	private KeyPad pad;
	private JTextArea display;

	private ATM theATM;

	/**
      Constructs the user interface of the ATM frame.
	 */
	public ATMFrame(ATM anATM) {  
		theATM = anATM;

		// Construct components
		pad = new KeyPad();

		display = new JTextArea(4, 20);

		aButton = new JButton("  A  ");
		aButton.addActionListener(new AButtonListener());

		bButton = new JButton("  B  ");
		bButton.addActionListener(new BButtonListener());

		cButton = new JButton("  C  ");
		cButton.addActionListener(new CButtonListener());

		// Add components

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(aButton);
		buttonPanel.add(bButton);
		buttonPanel.add(cButton);

		setLayout(new FlowLayout());
		add(pad);
		add(display);
		add(buttonPanel);
		showState();

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	/** 
      Updates display message.
	 */
	public void showState() {  
		State state = theATM.getState();
		pad.clear();
		display.setText(state.getMessage(theATM));
	}

	class AButtonListener implements ActionListener {  
		public void actionPerformed(ActionEvent event) {  
			State state = theATM.getState();
			state.doActionA(theATM, pad);
			showState();
		}
	}

	class BButtonListener implements ActionListener {  
		public void actionPerformed(ActionEvent event) {  
			State state = theATM.getState();
			state.doActionB(theATM, pad);
			showState();
		}
	}

	class CButtonListener implements ActionListener	{  
		public void actionPerformed(ActionEvent event) {  
			State state = theATM.getState();
			state.doActionC(theATM, pad);
			showState();
		}
	}
}
