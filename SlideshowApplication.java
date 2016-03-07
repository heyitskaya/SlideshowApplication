import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

import javax.swing. *;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;


public class SlideshowApplication implements ActionListener
{
	Timer timer= new Timer();
	Task myTask=new Task(1,"a");
	
	PriorityQueueBH queue;
	private  int MAXTIME;
	JTextField valueField;
	JTextField priorityField;
	JLabel slideshow; //changed this to JLabel
	JPanel bottomPanel;
	int length;
	int seconds=0;
	JLabel time;
	JOptionPane pane= new JOptionPane();
	
	
	public void SlideshowApplication2()
	{
		
	
	}
	public PriorityQueueBH getQueue()
	{
		return queue;
	}
	public JLabel getSlideshow()
	{
		return slideshow;
	}
	
	/** to init the GUI**/
	public void initGUI()
	{
		//queue= new PriorityQueueBH()
		JFrame frame= new JFrame("Slideshow");
		frame.setSize(750,450);
		frame.setLayout(new GridLayout(3,1));
		
		pane.setVisible(true);
		String newAnimal=pane.showInputDialog("How long would you like your slideshow, please enter in seconds");
		MAXTIME=Integer.parseInt(newAnimal);
		
		queue= new PriorityQueueBH(MAXTIME);
		
		
		
		JPanel textPanel=new JPanel();
		textPanel.setLayout(new GridLayout(1,2));
		JLabel input1=new JLabel("Please write string");
		JLabel input2=new JLabel("Please input priority");
		textPanel.add(input1);
		textPanel.add(input2);
		frame.add(textPanel);
		
		JPanel topPanel= new JPanel();
		topPanel.setLayout(new GridLayout(2,1));
		JPanel enterPanel=new JPanel();
		enterPanel.setLayout(new GridLayout(1,2));
		valueField= new JTextField();
		priorityField= new JTextField();
		enterPanel.add(valueField);
		enterPanel.add(priorityField);
		topPanel.add(enterPanel);
		
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridLayout(2,1));
		//create the buttons
		JButton enterButton= new JButton("enter");
		enterButton.addActionListener(this);
		JButton startButton= new JButton("start");
		startButton.addActionListener(this);
		buttonPanel.add(enterButton);
		buttonPanel.add(startButton);
		
		bottomPanel= new JPanel();
		bottomPanel.setLayout(new GridLayout(2,1));
		slideshow=new JLabel();
		time= new JLabel();
		
		
		time= new JLabel("");
		bottomPanel.add(slideshow);
		bottomPanel.add(time);
		bottomPanel.add(slideshow);
		
		topPanel.add(buttonPanel);
		frame.add(topPanel);
		frame.add(bottomPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set it to EXIT_ON_CLOSEE
		frame.setVisible(true); //set visibilty to true
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String buttonPressed=e.getActionCommand(); //get info about which button was pressed
		
		if(buttonPressed.equals("enter")) //if the enter button was pressed
		{
			String priority =priorityField.getText();
			
			String string=valueField.getText();
			
			if(!string.isEmpty() && !priority.isEmpty())
			{
				if(java.lang.Integer.valueOf(priority) instanceof Integer)
				{
					
					Integer i=Integer.parseInt(priorityField.getText());
				
					queue.insert(i, string);
					valueField.setText("");
					priorityField.setText("");
					queue.toString();
				}
			}
		}
		if(buttonPressed.equals("start"))
		{
			int length=queue.getLength(); //2,
			
		
			
			for(int i=0;i<length;i++)
			{
				queue.toString();
				Integer priority =(MAXTIME-queue.getMaxPriority())*1000; //1,2
				
				String s=queue.extractMax();
				//currTask prints out the string
				Task currTask=new Task(priority,s);
				timer.schedule(currTask,priority);
				
				
			}
			for(int q=0;q<MAXTIME;q++)
			{
				UpdateTime timeTask= new UpdateTime(q+1);
				timer.schedule(timeTask,(q+1)*1000);
			}
		
		}
	}
	/** this inner class takes care of updating the string in the JLabel**/
		public class Task extends TimerTask
		{
			int seconds;
			String string;
			public Task(int i,String s)
			{
				seconds=i;
				string=s;
			}
			
			public void run()
			{
				slideshow.setText(string);
			}
		}
		
		/** This inner class takes care of updating the time, for the duration of the slideshow**/
		public class UpdateTime extends TimerTask
		{
			int currTime;
			public UpdateTime(int currTime)
			{
				this.currTime=currTime;
			} 
			public void run()
			{
				
				time.setText(Integer.toString(currTime));
			}
		}
	
	
	
	public static void main(String args[])
	{
		
		SlideshowApplication app= new SlideshowApplication();
		app.initGUI();
	
	}
	

}
