import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    public static Game game = new Game();

    static final int SIZE = 30;

    static final int TILES = 30;

    static JButton[][] buttons = new JButton[TILES][TILES];

    public static void main(String[] args) {
        Game game = new Game();
        JFrame f = new JFrame("Game Of Life");

        JPanel p = new JPanel(new GridLayout(TILES, TILES));
        JPanel p2 = new JPanel();
        JButton next = new JButton("Next");
        JButton clear = new JButton("Clear");
        p2.add(next);
        p2.add(clear);

        for (int x = 0; x < TILES; x++) {
            for (int y = 0; y < TILES; y++) {
                buttons[x][y] = new JButton();
                buttons[x][y].setBackground(Color.GRAY);
                buttons[x][y].setOpaque(true);
                buttons[x][y].setBorderPainted(false);

                int finalX = x;
                int finalY = y;
                buttons[x][y].addActionListener(e -> {
                    JButton button = (JButton) e.getSource();
                    if (button.getBackground() == Color.GRAY) {
                        button.setBackground(Color.YELLOW);
                        game.changeState(finalX, finalY);
                    } else {
                        button.setBackground(Color.GRAY);
                    }
                });

                p.add(buttons[x][y]);
            }
        }

        next.addActionListener(e -> {
            game.checkNeighbors();
            game.nextMove();
            boolean[][] gameGrid = game.getGameGrid();
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    if(gameGrid[i][j]) {
                        buttons[i][j].setBackground(Color.YELLOW);
                    }
                    else {
                        buttons[i][j].setBackground(Color.GRAY);
                    }
                }
            }
        });

        clear.addActionListener(e -> {
            game.checkNeighbors();
//            game.nextMove();
            boolean[][] gameGrid = game.getGameGrid();
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                        gameGrid[i][j] = false;
                        buttons[i][j].setBackground(Color.GRAY);
                }
            }
        });

        f.setLayout(new BorderLayout());

        f.add(p, BorderLayout.CENTER);
        f.add(p2, BorderLayout.SOUTH);

        f.setSize(TILES * SIZE, TILES * SIZE);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
