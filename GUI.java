import java.awt.*;
import javax.swing.*;
public class GUI extends Frame{


	private String fileName;
	private JFrame frame;
	public GUI(){

		frame = new JFrame("Artificial Intelligence");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720, 480);
		frame.setVisible(true);
		fileName = JOptionPane.showInputDialog(frame, "Enter name of file to load, or name to write new map to");
	
		init();
	}


	public void init(){
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBounds(0, 0, 5, 3);
		panel.setBackground(Color.gray);
		JButton b1 = new JButton("Draw");
		b1.setBackground(Color.blue);

		panel.add(b1, BorderLayout.NORTH);
		


		frame.add(panel);



		frame.setVisible(true);
	}





}
