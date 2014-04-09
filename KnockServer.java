package knockserver;
import java.io.*;
import java.net.*;


public class KnockServer {
    

    //Arrays that hold the Answers and Jokes of the 
    //Knock knock sender.
    String[] AnsList = {"Canoe","Merry","Orange"};
    String[] JokeList = {"Canoe help me with my homework?","Merry Christmas!"
    ,"Orange you going to let me in?"};
    
    public void go()
    {
        try
        {
            ServerSocket connection = new ServerSocket (4242);
            
            //A loop that contualliy links up with the client.
            //Prints nessary Answer and Jokes to the  client.
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
    
    //Main function. Creates the thread that
    //runs the server.
    public static void main(String[] args) 
    {
        KnockServer Server = new KnockServer();
        Server.go();
    }
    
    //Gets one of the elements from the joke list
    //in accordance to the random integer that was picked.
    private String getJoke(int Postion)
    {
        return JokeList[Postion];
    }
    
    //Gets one of the elements from the Anwser list
    //in accordance to the random integer that was picked.
    private String getAns(int Postion)
    {
        return AnsList[Postion];
    }
}
