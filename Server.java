import java.net.Socket;
import java.sql.Connection;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Server
{
    public static final int LISTENING_PORT = 9876;
    //GameLogic logic = new GameLogic();
    //Tile[][] board;
    // enum Tile
    // {
    //     BOMB,
    //     SAFE
    // }


    // public Tile[][] getBoard()
    // {
    //     return board;
    // }
    
    private class GameLogic
    {
        private int mines = 10;
        private int rows = 9;
        private int cols = 9;

        public int[][] field = createField();
        
        
        private int[][] createField() {
            int[] tempField = new int[rows*cols];
            int[][] newField = new int[rows][cols];

            for(int i = 0; i<mines; i++) {
                tempField[i] = 1;
            }

            Collections.shuffle(Arrays.asList(tempField));

            //turn into 2d array
            int[][] newField = new int[rows][cols];
            for(int i=0; i<tempField.length; i++) {
                int row = i / cols;
                int col = i % rows;
                newField[row][col] = tempField[i];
            }

            System.out.println(Arrays.toString(newField));
            return newField;
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
    }

    private class ConnectionHandler extends Thread
    {
        private /* static */ ArrayList<ConnectionHandler> handlers;
        Socket socket;
        ObjectInputStream in;
        ObjectOutputStream out;

        public ConnectionHandler(Socket s)
        {
            socket = s;
            if (handlers == null)
            {
                handlers = new ArrayList<ConnectionHandler>();
            }
            handlers.add(this);
            
            //Attempt to connect in and out streams
            try {
                in = (ObjectInputStream) socket.getInputStream();
                out = (ObjectOutputStream) socket.getOutputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run ()
        {
            
        }
    }
}



    