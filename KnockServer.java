package knockserver;
import java.io.*;
import java.net.*;


public class KnockServer {

    String[] AnsList = {"Canoe","Merry","Orange"};
    String[] JokeList = {"Canoe help me with my homework?","Merry Christmas!"
    ,"Orange you going to let me in?"};
    
    public void go()
    {
        try
        {
            ServerSocket connection = new ServerSocket (4242);
            
            while(true)
            {
                Socket Sock = connection.accept();
                int random = (int) (Math.random() *JokeList.length);
                
                PrintWriter Writer = new PrintWriter(Sock.getOutputStream());
                String Ans = getAns(random);
                String Joke = getJoke(random);
                Writer.println("Who's there");
                Writer.println(Ans);
                Writer.println(Joke);
                
                
                Writer.close();
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
        KnockServer Server = new KnockServer();
        Server.go();
    }
    private String getJoke(int Postion)
    {
        return JokeList[Postion];
    }
    private String getAns(int Postion)
    {
        return AnsList[Postion];
    }
}
