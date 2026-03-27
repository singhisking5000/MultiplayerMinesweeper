import java.net.Socket;
import javax.swing.*;

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
        Tile[][] tiles;

        for(int x = 0; x < tiles.length; x++){
            for(int y = 0; y < tiles[x].length; x++){

            }
        }
    }

    private void updateGUI(LogicPacket info)
    {

    }
}