import javax.swing.*;
import java.awt.*;

public class Box extends JTextField {
    // fields
    public int num;
    public int row, col;
    /*
    param: number will be the number displayed on the box
    in this constructor, the box will not be an input field
     */
    public Box(int number, int row, int col) {
        super(number+"");
        num = number;
        setHorizontalAlignment(JTextField.CENTER);
        super.setEditable(false);
        super.setBackground(Color.WHITE);
        super.setFont(new Font("Serif", Font.BOLD, 60));
        super.setBorder(BorderFactory.createLineBorder(Color.black));
        this.row = row;
        this.col = col;
        //super.getLineStartOffset(getLineCount() / 2);
    }

    /*
    param: none
    in this constructor, the box will be an input field for the user to try numbers
     */
    public Box(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        setHorizontalAlignment(JTextField.CENTER);
        super.setBackground(Color.WHITE);
        super.setEditable(true);
        super.setFont(new Font("Serif", Font.BOLD, 60));
        super.setBorder(BorderFactory.createLineBorder(Color.black));
        num = 0; // temporarily set this as 0
        // since 0 is not 1-9, if num is 0, then i know this box is currently unassigned
    }


    /*
    param: number user wants to input
    return: none
    this method will display the number the user wants to fill in permanently
     */
    public void changeNum(int number) {
        this.num = number;
        this.setText(number+"");
        setHorizontalAlignment(JTextField.CENTER);
        //this.setBackground(Color.WHITE);
        this.setFont(new Font("Serif", Font.BOLD, 60));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setEditable(true);
    }

    /*
    returns the number the box stores
     */
    public int getNum() {
        return this.num;
    }

}
