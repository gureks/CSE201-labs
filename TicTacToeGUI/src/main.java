/**
 * @author Gurek Singh 2015033
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main {

	static JFrame frame = new JFrame("Tic Tac Toe");

	public static void game()
	{
		JPanel bp = new JPanel();
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,5));
		
		JButton first = new JButton("User 1 vs User 2");
		first.setPreferredSize(new Dimension(150, 50));
		
		JButton second = new JButton("User vs CPU");
		second.setPreferredSize(new Dimension(150, 50));
		
		JButton third = new JButton("CPU vs AI");
		third.setPreferredSize(new Dimension(150, 50));
		
		JButton fourth = new JButton("User vs AI");
		fourth.setPreferredSize(new Dimension(150, 50));
		
		JButton exit = new JButton("Exit");
		exit.setPreferredSize(new Dimension(150, 50));
		

		first.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				second.setEnabled(false);
				third.setEnabled(false);
				fourth.setEnabled(false);
			}
		});
		
		second.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				first.setEnabled(false);
				third.setEnabled(false);
				fourth.setEnabled(false);
			}
		});
		
		third.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				second.setEnabled(false);
				first.setEnabled(false);
				fourth.setEnabled(false);
			}
		});
		

		fourth.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				second.setEnabled(false);
				third.setEnabled(false);
				first.setEnabled(false);
			}
		});
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				System.exit(0);
			}
		});
		
		//buttonPanel.setLayout(null);
		
		buttonPanel.add(first);
		buttonPanel.add(second);
		buttonPanel.add(third);
		buttonPanel.add(fourth);
		buttonPanel.add(exit);
		
		bp.add(buttonPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, bp);
		frame.revalidate();
	}
	
	public static void init()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Labels
		JLabel name = new JLabel("Tic-Tac-Toe");
		JLabel author = new JLabel("By: Gurek Singh(2015033)");
		
		//Start button
		JButton start = new JButton("Start Game");
        start.setPreferredSize(new Dimension(400, 100));
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				panel.setVisible(false);
				frame.getContentPane().remove(panel);
				frame.revalidate();
				game();
			}
		});
		
		//Exit button
		JButton exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(400, 100));
		exit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						frame.setVisible(false);
						System.exit(0);
					}
				});
		
	    panel.setLayout(null);
	    
	    //Set bounds for components
	    name.setBounds(250, 150, 300, 50);
	    name.setFont(new Font("Times New Roman",Font.BOLD,30));
	    author.setBounds(250, 200, 300, 50);
	    author.setFont(new Font("Times New Roman",Font.ITALIC,20));
	    start.setBounds(200, 350, 400, 100);
	    exit.setBounds(200, 500, 400, 100);
	    
	    //Add components to panel
		panel.add(name);
		panel.add(author);
		panel.add(start);
		panel.add(exit);
		
		//Set frame defaults.
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		init();
	}

}
