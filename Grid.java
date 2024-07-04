import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Grid extends JFrame {

    static final int SIZE = 30;

    static final int TILES = 30;

    // 2D array to store buttons
    static JButton[][] buttons = new JButton[TILES][TILES];

    // Main driver method
    public static void main(String[] args) {
        // Creating a new JFrame
        JFrame f = new JFrame("Game Of Life");

        // Creating a JPanel with GridLayout
        JPanel p = new JPanel(new GridLayout(TILES, TILES));

        // Initialize buttons and add them to the panel
        for (int x = 0; x < TILES; x++) {
            for (int y = 0; y < TILES; y++) {
                buttons[x][y] = new JButton();
                buttons[x][y].setBackground(Color.GRAY);
                buttons[x][y].setOpaque(true);
                buttons[x][y].setBorderPainted(false);

                // Add ActionListener to handle button clicks
                int finalX = x;
                int finalY = y;
                buttons[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        if (button.getBackground() == Color.GRAY) {
                            button.setBackground(Color.YELLOW);
                            System.out.println(finalX);
                            System.out.println(finalY);
                        } else {
                            button.setBackground(Color.GRAY);
                        }
                    }
                });

                p.add(buttons[x][y]);
            }
        }

        // Adding panel to frame
        f.add(p);

        // Setting the size of frame
        f.setSize(TILES * SIZE, TILES * SIZE);

        // Setting the default close operation
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the frame visibility to true
        f.setVisible(true);
    }
}
