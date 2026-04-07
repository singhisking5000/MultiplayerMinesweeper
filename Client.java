import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class Client
{
    private static JFrame f;
    private static JLabel top;
    private static JLabel bottom;
    private static JPanel board;

    private static int length;

    public static void main(String[] args)
    {
        setupGUI();
    }

    private static void setupGUI()
    {
        f = new JFrame();
        top = new JLabel();
        bottom = new JLabel();
        board = new JPanel();
        length = 50;
        f.setLayout(new BorderLayout());
        board.setLayout(new GridLayout(length, length));
        f.add(top, BorderLayout.NORTH);
        f.add(board, BorderLayout.CENTER);
        f.add(bottom, BorderLayout.SOUTH);

        // Now set up the board
        // int[][] tiles = createField(9,9,10);

        // for(int x = 0; x < tiles.length; x++){
        //     for(int y = 0; y < tiles[x].length; x++){

        //     }
        // }
    }

    private static int[][] createField(int r, int c, int m) {
        int[] tempField = new int[r*c];
        for(int i = 0; i<m; i++) {
            tempField[i] = 1;
        }

        Collections.shuffle(Arrays.asList(tempField));

        //turn into 2d array
        int[][] field = new int[r][c];
        for(int i=0; i<tempField.length; i++) {
            int row = i / c;
            int col = i % r;
            field[row][col] = tempField[i];
        }

        return field;
    }
    private void updateGUI(LogicPacket info)
    {

    }
}