package lab04;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Book2GUIListBuilder {
	private JFrame frame = new JFrame("Book Data");
	private JTextField titleFld = new JTextField(25);
	private JTextField numPgs = new JTextField(25);
	private Vector<String> books = new Vector<String>();
	private JList<String> bookList = new JList<String>(books);
	private JCheckBox check = new JCheckBox("Check here ");
	private JTextField bookmarkPage = new JTextField(25);
	private JScrollPane bookScroller;
	private FileOutputStream outfile; 
	private PrintWriter output;

	public Book2GUIListBuilder () {
		try {
			outfile = new FileOutputStream("books1.txt", true);
			output = new PrintWriter(outfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		JPanel entryPanel = new JPanel();
		entryPanel.setLayout(new BorderLayout());
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(0,1));
		JPanel rightPanel = new JPanel();
		JPanel reqdPanel  = new JPanel();
		rightPanel.setLayout(new GridLayout(0,1));
		leftPanel.add(new JLabel(" Book Title: ", JLabel.RIGHT));
		leftPanel.add(new JLabel(" Number of Pages: ", JLabel.RIGHT));
		leftPanel.add(new JLabel(" Required: ", JLabel.RIGHT));
		leftPanel.add(new JLabel(" Bookmark Page: ", JLabel.RIGHT));
		entryPanel.add(leftPanel);

		rightPanel.add(titleFld);
		rightPanel.add(numPgs);
		rightPanel.add(reqdPanel);
		reqdPanel.add(check);
		rightPanel.add(bookmarkPage);
		entryPanel.add(rightPanel, BorderLayout.LINE_END);

		JButton button = new JButton("Add Book");
		button.addActionListener(new EnterBookListener());

		frame.add(entryPanel, BorderLayout.PAGE_START);
		bookScroller = new JScrollPane(bookList);
		frame.add(bookScroller);
		frame.add(button, BorderLayout.PAGE_END);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new OutputClosingListener());
		frame.setSize(450, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Book2GUIListBuilder();
			}
		});
	}

	class EnterBookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String title = titleFld.getText().trim();
			String numPgsString = numPgs.getText().trim();
			boolean reqd = check.isSelected();
			String bookMarkString = bookmarkPage.getText().trim();
			int numPgsInt = 0;
			int bookMarkInt = 0;
			// do error processing
			StringBuilder error = new StringBuilder();
			int numErrors = 0;
			if (title.length() == 0) {
				error.append("You have provided a blank title!\n");
				numErrors++;
			}
			Scanner scan = new Scanner(numPgsString);
			if(!scan.hasNextInt()) {
				error.append("The number of pages is not an integer!\n");
				numErrors++;
			} else {
				numPgsInt = scan.nextInt();
				if(numPgsInt <= 0) {
					error.append("A book must have at least one page!\n" +
							"you cannot put " + numPgsString + "\n");
					numErrors++;				
				}
			}
			scan.close();
			scan = new Scanner(bookMarkString);
			// the bookMark is allowed to be blank so only analyze if
			// there is some input
			if(bookMarkString.length() > 0) {
				if(!scan.hasNextInt()) {
					error.append("The book mark page is not an integer.\n");
					numErrors++;
				} else {
					bookMarkInt = scan.nextInt();
					if(bookMarkInt < 0) {
						error.append("The book mark cannot be negative!\n" +
								"you cannot put " + bookMarkString + "\n");
						numErrors++;				
					}				
				}
			}
			scan.close();
			// report an error
			String errorTitle = "ERROR";
			if(numErrors > 1) {
				errorTitle = "ERRORS";
			} 
			if(numErrors > 0) {
				JOptionPane.showMessageDialog(frame, error.toString(), 
						errorTitle, JOptionPane.WARNING_MESSAGE);
			} else { // the input is acceptable
				Book2 book = new Book2(title, numPgsInt, reqd, bookMarkInt);
				books.add(book.toString());
				bookList = new JList<String>(books);
				bookScroller.setViewportView(bookList);
				output.println(book.outputLine());
				System.out.println(book.outputLine());
			}
		}

	}
	private class OutputClosingListener extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent arg0) {
			output.close();
			System.exit(0);
		}

	}
}
