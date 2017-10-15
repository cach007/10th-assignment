
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Calculator extends JFrame {
	private String check;
	private int numOne,sum,total;
	private int count=0,Chec=0;
	private JPanel panel;
	private JTextField tField;
	private JButton[] buttons;
	private String[] labels = { 
			"Backspace", "", "", "CE", "C",
			"7", "8", "9", "/", "sqrt",
			"4", "5", "6", "x", "%",
			"1", "2", "3", "-", "1/x",
			"0", "+/-", ".", "+", "=",
	};
	
	public Calculator() {
		tField = new JTextField(35);
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 5, 3, 3));
		buttons = new JButton[25];
		tField = new JTextField("", SwingConstants.CENTER);

		  for(int count = 0; count < labels.length; count++)
		  {
		   buttons[count] = new JButton(labels[count]);
		   panel.add(buttons[count]);
		   
		   PadInput handler = new PadInput(); 
		   buttons[count].addActionListener(handler); 
		  }

		add(tField, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack();
	}
	private  class PadInput implements ActionListener
	 {
	  public void actionPerformed(ActionEvent event)
	  {
	   String eventText = event.getActionCommand();
	   
	   
	   if(eventText.equals("+")) 
	   {
	    Chec = 1;
	   }
	   else if(eventText.equals("-")) 
	   {
	    Chec = 2;
	   }
	   else if(eventText.equals("x")) 
	   {
	    Chec = 3;
	   }
	   else if(eventText.equals("/")) 
	   {
	    Chec = 4;
	   }
	   else if(eventText.equals("=")) 
	   {
	    Chec = 5;
	   }
	   else if(eventText.equals("%")) 
	   {
	    Chec = 6;
	   }
	   else if(eventText.equals("CE"))
	   {
		   tField.setText("");
	 	   numOne = 0;
	 	   total = 0;
	 	   sum = 0;
	 	   count = 0;
	 	   Chec=0;
	   }
	   else
	   {
	    if(count == 1) 
	    {
	     tField.setText("");
	     count = 0;
	    }
	    
	    tField.setText(tField.getText()+event.getActionCommand()); 
	   }

	   try
	   {
	    if((total != 0) && (Chec <= 5)) 
	    {
	     tField.setText(tField.getText()); 
	    }
	    else
	    {
	     if( Chec == 1 ) 
	     {
	      numOne = Integer.parseInt(tField.getText()); 
	      total += numOne;  
	      numOne = 0; 
	      
	      tField.setText(String.valueOf(total)); 
	      
	      count = 1;
	      check = "+";
	     }
	     else if( Chec == 2 ) 
	     {
	      numOne = Integer.parseInt(tField.getText());
	      total += numOne;
	      numOne = 0;
	      
	      tField.setText(String.valueOf(total));
	      
	      count = 1;
	      check = "-";
	     }
	     else if( Chec == 3 )
	     {
	      numOne = Integer.parseInt(tField.getText());
	      total += numOne;
	      numOne = 0;
	      
	      tField.setText(String.valueOf(total));
	      
	      count = 1;
	      check = "*";
	     }
	     else if( Chec == 4 )
	     {
	      numOne = Integer.parseInt(tField.getText());
	      total += numOne;
	      numOne = 0;
	      
	      tField.setText(String.valueOf(total));
	      
	      System.out.println(" numBer ==> " + numOne);
	      System.out.println(" total ==> " + total);
	      
	      count = 1;
	      check = "/";
	     }
	     else if( Chec == 6 )
	     {
	      numOne = Integer.parseInt(tField.getText());
	      total += numOne;
	      numOne = 0;
	      
	      tField.setText(String.valueOf(total));
	      
	    
	      count = 1;
	      check = "%";
	    }
	   }
	   }
	   catch(Exception e)
	   {
	    System.out.println(" Error ==> " + e);
	   }
	  
	   if(total == 0)
	   {
	    tField.setText(tField.getText()); 
	   }
	   else
	   {
	    if((Chec == 5) && check.equals("+"))
	    {
	     numOne = Integer.parseInt(tField.getText()); 
	     sum = numOne + total; 
	     
	     count = 1;
	     numOne = 0;
	     total = 0;
	     tField.setText(String.valueOf(sum)); 
	    }
	    else if((Chec == 5) && check.equals("-")) 
	    {
	     System.out.println("bbb");
	     numOne = Integer.parseInt(tField.getText());
	     sum = total - numOne;
	     
	     count = 1;
	     numOne = 0;
	     total = 0;
	     tField.setText(String.valueOf(sum));
	    }
	    else if((Chec == 5) && check.equals("*")) 
	    {
	     System.out.println("ccc");
	     numOne = Integer.parseInt(tField.getText());
	     sum = numOne * total;
	     
	     count = 1;
	     numOne = 0;
	     total = 0;
	     tField.setText(String.valueOf(sum));
	    }
	    else if((Chec == 5) && check.equals("/")) 
	    {
	     System.out.println("ddd");
	     numOne = Integer.parseInt(tField.getText());
	     sum = total / numOne;
	     
	     count = 1;
	     numOne = 0;
	     total = 0;
	     tField.setText(String.valueOf(sum));
	    }
	    else if((Chec == 5) && check.equals("%")) 
	    {
	     
	     numOne = Integer.parseInt(tField.getText());
	     sum = total % numOne;
	     
	     count = 1;
	     numOne = 0;
	     total = 0;
	     tField.setText(String.valueOf(sum));
	    }
	   }
	  }
	 }
	public static void main(String[] args) {
		Calculator s = new Calculator();
	}
	 
}