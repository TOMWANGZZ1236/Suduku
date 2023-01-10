import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;


public class MainWindow extends JFrame{
    // fields
    public static SudokuGame game = new SudokuGame();
    public static final int WIDTH = 700, HEIGHT = 750; // height and width used for the screen
    private static Timer timer;

    public MainWindow()  {
// Deceleration of components
        JPanel gamePanel = new JPanel();
        JPanel actionPanel = new JPanel();
        JButton newGame =  new JButton("New Game");
        JButton rules =  new JButton("Rules");
        JButton solve =  new JButton("Solve");


// frame
        setTitle("Suduku Game");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //add game
        game.setSize(800, 800);




// Panels
        //ActionPanel (where the buttons will go)

        actionPanel.setLayout(new GridLayout(1,3));
        actionPanel.setBackground(Color.GRAY);

        //GamePanel
        gamePanel.setBackground(Color.DARK_GRAY);


// Button
        newGame.setFont(new Font("Arial", Font.BOLD, 18)); //NewGame button

        solve.setFont(new Font("Arial", Font.BOLD, 18));   //Solve button

        rules.setFont(new Font("Arial", Font.BOLD, 18));    //Rule button

// ActionListeners for the buttons
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rule r = new Rule();
            }
        });

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNewGame();
            }
        });

        solve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(()->{
                    MainWindow.game.solve(MainWindow.game.getGrid(), 0, 0);
                }).start();
            }
        });





// Adding components


        actionPanel.add(newGame);
        actionPanel.add(rules);
        actionPanel.add(solve);
        add(actionPanel,BorderLayout.SOUTH);
        add(gamePanel, BorderLayout.CENTER);
        add(game);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow m = new MainWindow();
        // Refresh screen at approx 60Hz
        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.repaint();
            }
        });
    }

    /*
    Draws lines to the JFrame (so that the lines can go over the JPanel)
    All lines are drawn using ratios so when screen is resized, the lines will still be in the correct places
     */
    public void paint(Graphics g) {
        super.paint(g);
        // get current size (in case user resized window)
        Dimension size = this.getBounds().getSize();
        double h = size.getHeight();
        double w = size.getWidth();

        // Line2D needs Graphics2D to draw it
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        // make the line thicker so its visible
        g2.setStroke(new BasicStroke(3f));
        // makes a line and draws it to JFrame
        Line2D line = new Line2D.Double(0.336*w, 40, 0.336*w, h-45);
        g2.draw(line);
        Line2D line2 = new Line2D.Double(0.663*w, 40, 0.663*w, h-45);
        g2.draw(line2);
        Line2D line3 = new Line2D.Double(2, 0.3488*h, w-2, 0.3488*h);
        g2.draw(line3);
        Line2D line4 = new Line2D.Double(2, 0.6444*h, w-2, 0.6444*h);
        g2.draw(line4);
    }

    /*
    param: none
    Removes current game from frame
    Generates a new game by calling SudokuGame constructor
    Re-adds the new game tp frame
     */
    public void getNewGame() {
        super.remove(game);
        game = new SudokuGame();
        game.setSize(800, 800);
        super.add(game);
        super.setVisible(true);
        repaint();
        // change up the sizes so that it redraws the lines
        setSize(400, 400);
        setSize(700,750);
    }

}


