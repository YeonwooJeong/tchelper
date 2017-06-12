package com.tc.helper;

import javax.swing.*;

//import com.burger.king.runner;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

class runner extends Thread{
	Ui simul = new Ui();
	public static    JLabel labelIntroduce;
//	public static survey survey = new survey();
	public  static  JTextField tf_btsUrl, note_row;;
	public static JLabel submit,number;
	public boolean check = true;

	
	public void run(){
        // 텍스트 필드값 가져오기
        String receiptNum = tf_btsUrl.getText();
    	String txt_speed = note_row.getText();
        if(txt_speed.equals("")){
        	txt_speed = "100";
        }else{
        	txt_speed = note_row.getText();
        }
         
        try {
//			survey.setUp();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//        survey.inputNumber(receiptNum, txt_speed);
        try {
//			survey.run();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}

class JPanel033 extends JPanel{        // 3번째 패널
	runner thread = new runner();
    
	// 클래스 멤버 필드 설정
	
	private    JLabel name;
    private    JLabel url, note;
    private    JTextField tf_speed;
    private JLabel image;
    private Font f1, f2, f3;
    
    private    JButton buttonSave;
    private    JButton buttonStop;
    public boolean check = true; 
    
    public JPanel033() {         // 3번째 패널 생성자
        
    	URL imageURL = Ui.class.getClassLoader().getResource("burger.png");
        setLayout(null);
        
//        ImageIcon im  = new ImageIcon(imageURL);
//        image = new JLabel(im);
        
        // 라벨
        f1 = new Font("궁서", Font.BOLD, 15);        
        name = new JLabel("TC Helper");
        name.setFont(f1);
        name.setSize(200, 30);   
        name.setLocation(10, 0);
        
        note = new JLabel("비고 열 지정");
        note.setSize(230, 20);   
        note.setLocation(165, 50);
        add(note);
        
        runner.note_row = new JTextField();
        runner.note_row.setBounds(250, 50,50, 20);
        runner.note_row.setText("100");
        add(runner.note_row);

//        image.setSize(40,50);
//        image.setBounds(310,5,60,60);
        
        url = new JLabel("BTS 필터 URL: ");
        url.setBounds(10,30,100,20);
        
        // 텍스트 필드
        runner.tf_btsUrl = new JTextField();             
        runner.tf_btsUrl.setBounds(100,30,200,20);
        
        thread.labelIntroduce = new JLabel("결과");
        thread.labelIntroduce.setBounds(10,50,280,20);
       
            
        // 버튼        
        buttonSave = new JButton("시작");
        buttonSave.setBounds(80,80,100,20);
        buttonSave.addActionListener(new EventHandlerSave());   
        
        buttonStop = new JButton("정지");
        buttonStop.setBounds(220,80,100,20);
        buttonStop.addActionListener(new EventHandlerStop());   
        
        add(name);
      
        add(thread.labelIntroduce);
        
        add(url);
        add(thread.tf_btsUrl);
        
//        add(image);
        
        add(buttonSave);
        add(buttonStop);
        
    }
    
    class EventHandlerSave implements ActionListener{     // 
        public void actionPerformed(ActionEvent e){
        	
			if(check){
				thread.start();	
			}else{
				runner thread = new runner();
				thread.start();	
				check = true;
			}
		}
    }   
    class EventHandlerStop implements ActionListener{     // 
        public void actionPerformed(ActionEvent e){
        	check = false;
        	System.out.println(check);
        	thread.interrupt();
        	System.out.println("정지!");
//        	System.exit(1);
        	
        }
    } 
    
}


public class Ui extends JFrame{
    
    public JPanel033 jpanel03 = null;
   
    public static void main(String[] args) {
        Ui win = new Ui();
        
        win.setTitle("TC Helper");
        win.jpanel03 = new JPanel033();
        
        URL imageURL = Ui.class.getClassLoader().getResource("burger.png");
        
        System.out.println(imageURL);
//        ImageIcon img = new ImageIcon(imageURL);
//        win.setIconImage(img.getImage());

        win.add(win.jpanel03);

        win.setSize(400,150);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
}
