import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener{
    //componenets
    JTextField textField;
    JButton numberButton[]=new JButton[10];
    JButton functionButton[]=new JButton[6];
    JButton addButton,subButton,mulButton,divButton,eqButton,clrButton;
    JPanel panel;
    //variables
    double num1=0,num2=0,result=0;
    char operator;
    //consturctor
    calculator(){
        setTitle("Simple calculator");
        setSize(400,540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        textField=new JTextField();
        textField.setBounds(50,25,300,50 );
        textField.setEditable(false);
        add(textField);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        eqButton=new JButton("=");
        clrButton=new JButton("c");

        functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=mulButton;
        functionButton[3]=divButton;
        functionButton[4]=eqButton;
        functionButton[5]=clrButton;

        for(int i=0;i<6;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(new Font("Arial",Font.BOLD,20));
            functionButton[i].setBackground(Color.orange);
            functionButton[i].setForeground(Color.WHITE);
            functionButton[i].setFocusable(false);
            //functionButton[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            functionButton[i].setBorder(new LineBorder(Color.black));
        }
        for(int i=0;i<10;i++){
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(new Font("Arial",Font.BOLD,20));
            numberButton[i].setBackground(Color.darkGray);
            numberButton[i].setForeground(Color.WHITE);
            numberButton[i].setFocusable(false);
            //numberButton[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            numberButton[i].setBorder(new LineBorder(Color.black));
        }
        panel=new JPanel();
        panel.setBounds(50,100,300,300 );
        panel.setLayout(new GridLayout(4,4));
        panel.setBackground(Color.BLACK);
        //add buttons to panel
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(numberButton[0]);
        panel.add(clrButton);
        panel.add(eqButton);
        panel.add(divButton);

        add(panel);
        setVisible(true);
    }
    //handle event
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==addButton){
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }   
        else if(e.getSource()==subButton){
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
         else if(e.getSource()==mulButton){
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
         else if(e.getSource()==divButton){
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
         else if(e.getSource()==eqButton){
            num2=Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                result=num1+num2;
                break;
                case '-':
                result=num1-num2;
                break;
                case '*':
                result=num1*num2;
                break;
                case '/':
                if(num2!=0){
                    result=num1/num2;
                }
                else{
                    System.out.println("error");
                    return;
                }
                break;
            }
            textField.setText(String.valueOf((int)result));
            num1=result;
        }
        else if(e.getSource()==clrButton){
            textField.setText("");
            num1=num2=result=0;
        }
    }
        public static void main(String args[]){
            calculator calculator=new calculator();
    }
    
}