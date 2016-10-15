/**
 * @author Gurek Singh 2015033
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TicTacToe
{
	static JFrame frame = new JFrame("Tic Tac Toe");
	
	public static void game()
	{
		JPanel buttonPanel = new JPanel();
		
		JButton first = new JButton("User vs User");
        first.setPreferredSize(new Dimension(150, 50));

        JButton second = new JButton("User vs CPU");
        second.setPreferredSize(new Dimension(150, 50));

        JButton third = new JButton("CPU vs AI");
        third.setPreferredSize(new Dimension(150, 50));

        JButton fourth = new JButton("User vs AI");
        fourth.setPreferredSize(new Dimension(150, 50));
		
		buttonPanel.add(first);
		buttonPanel.add(second);
		buttonPanel.add(third);
		buttonPanel.add(fourth);
		frame.getContentPane().add(buttonPanel);
		frame.revalidate();
	}
	
	public static void init()
	{
		JPanel panel = new JPanel();
		
		JLabel name = new JLabel("Tic-Tac-Toe");
		JLabel author = new JLabel("By: Gurek Singh(2015033)");
		
		JButton start = new JButton("Start Game");
        start.setPreferredSize(new Dimension(150, 50));
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.getContentPane().remove(panel);
				frame.revalidate();
				game();
			}
		});
		
		
		JButton exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(150, 50));
		exit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						frame.setVisible(false);
						System.exit(0);
					}
				});
		
	    start.setBackground(new Color(52, 152, 219));
	    start.setForeground(Color.WHITE);
	    exit.setBackground(new Color(52, 152, 219));
	    exit.setForeground(Color.WHITE);
	    
	    
		panel.add(name);
		panel.add(author);
		panel.add(start);
		panel.add(exit);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		init();
	}

}
