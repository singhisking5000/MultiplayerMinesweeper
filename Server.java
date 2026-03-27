import java.net.Socket;
import java.sql.Connection;
import java.net.ServerSocket;
import java.util.Collections;

public class Server
{
    public static final int LISTENING_PORT = 9876;
    //GameLogic logic = new GameLogic();
    Tile[][] board;
    // enum Tile
    // {
    //     BOMB,
    //     SAFE
    // }


    private void createBoard()
    {
        
    }
    public Tile[][] getBoard()
    {
        return board;
    }
    
    private class GameLogic
    {
        private int mines = 10;
        private int rows = 9;
        private int cols = 9;

        private int[] field = new int[(rows - 1) * (cols - 1)];
        
        // enum Tile {
        //     SAFE,
        //     BOMB
        // }
        
        private void createField() {
            for(int i = 0; i<mines; i++) {
                field[i] = 1;
            }

            List<Integer> fieldList = Arrays.asList(field);
            Collections.shuffle(fieldList);
            field = fieldList.toArray(new int[0]);

            System.out.println(Arrays.toString(field));
        }

        private int countNearbyBombs(int index) {
            int count = 0;
            if(field[i]dex) == 0
 {
                return count;
            }            //check if surrounding tile is on  boardrd 
        }
    }

    private class ConnectionHandler extends Thread
    {
        private static ArrayList<ConnectionHandler> handlers;
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
                in = socket.getInputStream();
                out = socket.getOutputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run ()
        {
            
        }
    }
}



    