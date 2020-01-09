package fr.epita.dz.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import fr.epita.dz.quiz.*;

public class MainFrame extends JFrame implements ActionListener{
	private JButton start,commit,last,next;
	private JRadioButton aButton,bButton,cButton,dButton;
	private ButtonGroup buttonGroup;
	private JLabel label, clock;
	private JTextArea jTextArea;
	private JPanel panel,panel2,panel3;
	
	Question q1;
	Question[] questions;
	int examtime;
	int p = 0;
	int topicnum = 0;
	int right,wrong;
	ClockDispaly mt;
	
	public MainFrame() {
		this.setTitle("Qestion & Answer");
		this.setSize(760, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		label = new JLabel("Exam Time: 10 minutes");
		clock = new JLabel();
		jTextArea = new JTextArea(80,75);
		jTextArea.setEditable(false);
		
		aButton = new JRadioButton("A");
		bButton = new JRadioButton("B");
		cButton = new JRadioButton("C");
		dButton = new JRadioButton("D");
		buttonGroup = new ButtonGroup();
		
		start = new JButton("Start Quiz");
		commit = new JButton("Submmit Answers");
		last = new JButton("Last Question");
		next = new JButton("Next Question");
		
		aButton.addActionListener(this);
		bButton.addActionListener(this);
		cButton.addActionListener(this);
		dButton.addActionListener(this);
		
		start.addActionListener(this);
		commit.addActionListener(this);
		last.addActionListener(this);
		next.addActionListener(this);
		
		buttonGroup.add(aButton);
		buttonGroup.add(bButton);
		buttonGroup.add(cButton);
		buttonGroup.add(dButton);
		
		panel.add(label);
		panel.add(clock);
		panel.add(start);
		panel2.add(jTextArea);
		panel3.add(aButton);
		panel3.add(bButton);
		panel3.add(cButton);
		panel3.add(dButton);
		panel3.add(last);
		panel3.add(next);
		panel3.add(commit);
		
		
		this.add(panel,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.CENTER);
		this.add(panel3,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		mt = new ClockDispaly(clock, 600);
	
		
	}

	public void createExam(){
		Vector<Question> qList=null;
		Question t;
		String questionText="";
		String standardKey;
	    String s;
	    try {
//	      String filePath = Readsrc.class.getResource("/Quiz Manager/src/test.txt").getPath(); 
	      InputStreamReader fr = new InputStreamReader(new FileInputStream("E:/Eclipse Projects/Epita/Quiz Manager/resource file/test.txt"), "UTF-8");
	      BufferedReader br = new BufferedReader(fr);    
	      qList=new Vector<Question>();
	      while((s=br.readLine())!=null){
	    	  if (s.equals("*****")){
	    		  questionText="";
	    		  s = br.readLine();
	    		  
	    	  }
	    	  if (s.equals("$$$$$")){
	    		  s = br.readLine();  
	    		  standardKey = s;    
	    		  t = new Question(questionText,standardKey);     
	    		  qList.add(t);                                       
	    	  }
	    	  questionText=questionText+s+'\n';
	    	  
	      }
	      br.close();
	      fr.close();
	      
	    } 
	    catch (IOException e) { 
	    	e.printStackTrace();       
	    	}
	    topicnum=qList.size();         
	    questions=new Question[topicnum];
	    for (int i=0;i<qList.size();i++)      
	    	questions[i]=qList.get(i);
	}
	
	
	
	//single choice
	public void setSelected(String s) { 
		if (s.equals("A")) buttonGroup.setSelected(aButton.getModel(), true);
		if (s.equals("B")) buttonGroup.setSelected(bButton.getModel(), true);
		if (s.equals("C")) buttonGroup.setSelected(cButton.getModel(), true);
		if (s.equals("D")) buttonGroup.setSelected(dButton.getModel(), true);
		if (s.equals("")) buttonGroup.clearSelection();
	}
	
	public void showQuestion() {
		jTextArea.setText("");
		jTextArea.append(questions[p].getQuestion());
		setSelected(questions[p].getSelectkey());
	}
	
	public void showScore() {
		right = 0; wrong = 0;
		for(int i =0;i<topicnum;i++) {
			if(questions[i].Check()) {
				right++;
			}else
				wrong++;
		}
		
		int score = (int)(right*100/topicnum);
		JOptionPane.showMessageDialog(null, "u got "+ right + " right answers "+" and you got "+ wrong + " wrong answers and your final score is: " + score);
	}
	
	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			createExam();
			p = 0;
			showQuestion();
			start.setEnabled(false);
			mt.start();
		}
		if(e.getSource() == last){
			p--;
			if(p==-1) {
				JOptionPane.showMessageDialog(null, "Already the first question");
				p++;
			}
			showQuestion();
		}
		if(e.getSource() == next) {
			p++;
			if(p==topicnum) {
				JOptionPane.showMessageDialog(null, "Already the last question");
				p--;
			}
			showQuestion();
		}
		if(e.getSource()==commit) {
			showScore();
			commit.setEnabled(false);
			System.exit(0);
		}
		if(e.getSource()==aButton) questions[p].setSelectkey("A");
		if(e.getSource()==bButton) questions[p].setSelectkey("B");
		if(e.getSource()==cButton) questions[p].setSelectkey("C");
		if(e.getSource()==dButton) questions[p].setSelectkey("D");
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
