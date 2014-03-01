package lab05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuSetup {
    private static Model model;
     
    public static void setupBar(JMenuBar menuBar, Model model) {
        MenuSetup.model = model;
        MenuListener suspender = new Suspender();

        JMenu pattern = new JMenu("Pattern");
        pattern.setMnemonic(KeyEvent.VK_P);
        menuBar.add(pattern);
        populatePattern(pattern);   
        pattern.addMenuListener(suspender);
       
        JMenu dimensions = new JMenu("Dimensions");
        menuBar.add(dimensions);
        //set the mnemonic to KeyEvent.VK_D
        //call a method populateDimensions
        //add the listener "suspender" as above
       
        //UNDER DIMENSION, you should see
        //Change Rows     (accelerator is Ctrl-R)
        //Change Columns  (accelerator is Ctrl-C)
        //The animation must be suspended and
        //you must pop up a JOptionPane.showInputDialog
        //and read the new number of rows or columns
        //respectively. The listener continues by
        //calling model.resetRows or model.resetColumns
        //Please verify that resetRows and resetColumns
        //actually work correctly when you test your code
 
        JMenu run = new JMenu("Control");
        pattern.setMnemonic(KeyEvent.VK_R);
        menuBar.add(run);
        populateRun(run);
        run.addMenuListener(suspender);
    }
   
    private static void populatePattern(JMenu menu) {
        JMenuItem glider = new JMenuItem("Glider");
        glider.setMnemonic(KeyEvent.VK_L);
        glider.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        glider.addActionListener(new GliderListener());
        menu.add(glider);
       
        JMenuItem random = new JMenuItem("Random");
        random.setMnemonic(KeyEvent.VK_A);
        random.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        random.addActionListener(new RandomListener());
        menu.add(random);
       
        JMenuItem gosper = new JMenuItem("Gosper Gun");
        gosper.setMnemonic(KeyEvent.VK_G);
        gosper.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        gosper.addActionListener(new GosperListener());
        menu.add(gosper);
       
    }

    private static void populateRun(JMenu menu) {
        JMenuItem pause = new JMenuItem("Pause");
        pause.setMnemonic(KeyEvent.VK_P);
        pause.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        pause.addActionListener(new SuspenderAction());
        menu.add(pause);
       
        JMenuItem go = new JMenuItem("Go");
        go.setMnemonic(KeyEvent.VK_G);
        go.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        go.addActionListener(new GoAgainAction());
        menu.add(go);

        JMenuItem clear = new JMenuItem("Clear");
        clear.setMnemonic(KeyEvent.VK_C);
        clear.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        clear.addActionListener(new ClearAction());
        menu.add(clear);
       
    }

    private static class SuspenderAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
            model.setAnimation(false);           
		}
    	
    }

    private static class GoAgainAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
            model.setAnimation(true);           
		}
    	
    }

    private static class ClearAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
            model.clear();           
		}
    	
    }

    private static class Suspender implements MenuListener {
        @Override
        public void menuCanceled(MenuEvent e) {
            model.setAnimation(true);           
        }

        @Override
        public void menuDeselected(MenuEvent e) {
            model.setAnimation(true);           
        }

        @Override
        public void menuSelected(MenuEvent e) {
            model.setAnimation(false);           
        }
    }
   
    private static class GliderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setAnimation(false);
            model.setupGlider();
            model.setAnimation(true);
        }
       
    }
    private static class RandomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setAnimation(false);
            model.setupRandomStart();
            model.setAnimation(true);
        }       
    }
    
    private static class GosperListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setAnimation(false);
            model.setupGosper();
            model.setAnimation(true);
        }       
    }
}