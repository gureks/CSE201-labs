/**
 * @author Gurek Singh 2015033
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TicTacToe
{
	static JFrame frame = new JFrame("Tic Tac Toe");
	static String move = "X";
	
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
		
        JButton exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(150,50));
        exit.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				frame.setVisible(false);
        				System.exit(0);
        			}
        		});
		buttonPanel.add(first);
        buttonPanel.add(second);
		buttonPanel.add(third);
		buttonPanel.add(fourth);
		buttonPanel.add(exit);
		
		frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
		frame.revalidate();
		
		JPanel textPanel = new JPanel();
		JTextField textbox = new JTextField("Random Text");
	    textbox.setPreferredSize(new Dimension(600,200));
	    textPanel.setLayout(new FlowLayout());
	    textPanel.add(textbox);
	    
	    JPanel gridPanel = new JPanel();
	    gridPanel.setLayout(new FlowLayout());
	    
	    JPanel grid = new JPanel();
	    grid.setLayout(new GridLayout(3, 3, 0, 0));
	    //gridPanel.setPreferredSize(new Dimension(300,300));
	    gridPanel.setMaximumSize(new Dimension(450,450));
	    gridPanel.add(grid);
	    for(int i = 0; i < 9; i++)
	    {
	    	JButton button = new JButton("");
	        button.setPreferredSize(new Dimension(150, 150));
	        button.setMaximumSize(new Dimension(150,150));
	        grid.add(button);
	        button.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		if(button.getText()=="")
	        		{
	        			button.setText(move);
	        			if(move=="X"){
	        				move = "O";
	        				textbox.setText("X Moved, O's turn");
	        			}
	        			else{
	        				move="X";
	        				textbox.setText("O Moved, X's turn");
	        			}
	        		}
	        	}
	        });
	    }
	    
	    frame.getContentPane().add(BorderLayout.NORTH, gridPanel);
	    frame.revalidate();
	    
	    frame.getContentPane().add(BorderLayout.CENTER, textPanel);
	    frame.revalidate();
	}
	
	public static void init()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel name = new JLabel("Tic-Tac-Toe");
		JLabel author = new JLabel("By: Gurek Singh(2015033)");
		
		JButton start = new JButton("Start Game");
        start.setPreferredSize(new Dimension(300, 50));
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
		
		
		JButton exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(300, 50));
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
	    panel.setLayout(null);
	    
	    name.setBounds(325, 150, 300, 50);
	    name.setFont(new Font("Arial",Font.BOLD,30));
	    author.setBounds(300, 200, 300, 50);
	    author.setFont(new Font("Arial",Font.ITALIC,20));
	    start.setBounds(300, 300, 300, 50);
	    exit.setBounds(300, 400, 300, 50);
	    
		panel.add(name);
		panel.add(author);
		panel.add(start);
		panel.add(exit);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		init();
	}

}
