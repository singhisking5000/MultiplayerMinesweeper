import java.net.Socket;
import javax.swing.*;

public class Client
{
    private static JFrame f;
    private static JLabel top;
    private static JLabel bottom;
    private static JPanel board;

    private static int a;
    private static int b;



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
        a = 50;
        b = 50;
        f.setLayout(new BorderLayout());
        board.setLayout(new GridLayout(a, b));
        f.add(top, BorderLayout.NORTH);
        f.add(board, BorderLayout.CENTER);
        f.add(bottom, BorderLayout.SOUTH);
    }

    private void updateGUI(GamePacket info)
    {

    }
}