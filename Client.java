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
    private static int[][] field;
    private static int rows = 9;
    private static int cols = 0;

    private static int length;

    public static void main(String[] args)
    {
        setupGUI();
        field = createField(rows, cols, 10);
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
        // int[][] tiles = createField(rows,cols,10);

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
        int[][] f = new int[r][c];
        for(int i=0; i<tempField.length; i++) {
            int row = i / c;
            int col = i % r;
            f[row][col] = tempField[i];
        }
        return f;
    }

    private int countNearbyBombs(int row, int col) {
        if(field[row][col] == 1) {
            return 0;
        }
        int count = 0;

        //check surrounding tile is on the board AND is a bomb
        if(col-1 > 0 && field[row][col-1] > 0) {
            count++;
        }
        if(col+1 < cols+1 && field[row][col+1] > 0) {
            count++;
        }

        if(row-1 > 0 && field[row-1][col] > 0) {
            count++;
        }
        if(row+1 < rows+1 && field[row+1][col] > 0) {
            count++;
        }

        //diagonals
        if(col-1 >0 && row-1 >0 && field[row-1][col-1] >0) {
            count++;
        }
        if(col+1 < cols+1 && row-1 >0 && field[row-1][col+1] >0) {
            count++;
        }

        if(col-1 >0 && row+1 < rows+1 && field[row+1][col-1] >0) {
            count++;
        }
        if(col+1 < cols+1 && row+1 < rows+1 && field[row+1][col+1] >0) {
            count++;
        }
        return count;
    }
    // private void updateGUI(LogicPacket info)
    // {

    // }
}