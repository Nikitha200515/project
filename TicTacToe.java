import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener{
    JButton[][] buttons = new JButton[3][3];
    JPanel panel;
    char currentplayer='x';

    //constructor
    TicTacToe(){
        setTitle("Tic-Tac-Toe");
        setSize(600,650);
        setLayout(new GridLayout(3,3));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        intialisebuttons();
        setVisible(true);
    }
        void intialisebuttons(){
            Font font = new Font("Arial",Font.BOLD,60);

            for(int row=0;row<3;row++){
                for(int col=0;col<3;col++){
                    buttons[row][col]=new JButton("");
                    buttons[row][col].setFont(font);
                    buttons[row][col].setBackground(Color.LIGHT_GRAY);
                    buttons[row][col].setForeground(Color.white);
                    buttons[row][col].setFocusable(false);
                    buttons[row][col].setBorder(new LineBorder(Color.black));
                    buttons[row][col].addActionListener(this);
                    add(buttons[row][col]);
                }
            }
        }
        public void actionPerformed(ActionEvent e){
            JButton clicked = (JButton) e.getSource();
            if(!clicked.getText().equals("")) return;
            clicked.setText(String.valueOf(currentplayer));
            if(currentplayer=='x'){
                clicked.setForeground(Color.blue);
            }
            else{
                clicked.setForeground(Color.orange);
            }

            if(checkwinner()){
                JOptionPane.showMessageDialog(this, "Player" + currentplayer + "wins!");
                resetboard();
            }
            else if(isDraw()){
                JOptionPane.showMessageDialog(this, " it is a Draw!");
                resetboard();
            }
            else{
                if(currentplayer=='x'){
                    currentplayer='o';
                }
                else{
                    currentplayer='x';
                }
            }
        }
            boolean checkwinner(){
                for(int i=0;i<3;i++){
                    if(match(buttons[i][0],buttons[i][1],buttons[i][2])) return true;
                    if(match(buttons[0][i],buttons[1][i],buttons[2][i])) return true;
                }
                return match(buttons[0][0],buttons[1][1],buttons[2][2]) || 
                match(buttons[0][2],buttons[1][1],buttons[2][0]);
            }
            boolean match(JButton b1,JButton b2,JButton b3){
                return !b1.getText().equals("") &&
                b1.getText().equals(b2.getText()) &&
                b2.getText().equals(b3.getText());
            }
            boolean isDraw(){
                for(JButton[] row:buttons){
                    for(JButton btn:row){
                        if(btn.getText().equals("")){
                        return false;
                    }
                }
            }
            return true;
        }
        void resetboard(){
            for(JButton[] row:buttons){
                for(JButton btn:row){
                    btn.setText(String.valueOf(""));
                }
            }
            currentplayer='x';
        }
    public static void main(String args[]){
        new TicTacToe();
    }
}