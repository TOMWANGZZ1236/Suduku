import java.awt.*;
import java.io.File;

import javax.swing.*;

public class Rule {

    public Rule()  {
        // Deceleration of components
        JFrame frame = new JFrame("Rule of Sudoku");
        JLabel PicLabel = new JLabel();
        JPanel RulePanel = new JPanel();
        ImageIcon rule = new ImageIcon("SudokuRules.png");
        Image img = rule.getImage();

        // make the image scale with the container
        Image ScaledImage = img.getScaledInstance(600,700,Image.SCALE_SMOOTH);
        ImageIcon ScaledRule = new ImageIcon(ScaledImage);

        // add image to Label
        PicLabel.setSize(600,700);
        PicLabel.setIcon(ScaledRule);

        // add label to Panel
        RulePanel.setSize(600,700);
        RulePanel.add(PicLabel);

        // add panel to frame
        frame.setSize(630,730);
        frame.add(RulePanel);


        //SetVisible
        frame.setVisible(true);

    }

}

