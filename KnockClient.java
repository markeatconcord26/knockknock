package knockclient;
import java.io.*;
import java.net.*;

public class KnockClient 
{
    public void go()
    {
        try
        {
            Socket connection = new Socket ("10.12.3.227",4242);
            InputStreamReader StreamReader= new 
                    InputStreamReader(connection.getInputStream());
            BufferedReader Reader = new BufferedReader(StreamReader);
            
            System.out.println("Knock Knock...");
            Pause();
            String Intro = Reader.readLine();
            System.out.println(Intro);
            Pause();
            String Ans = Reader.readLine();
            System.out.println(Ans);
            Pause();
            System.out.println(Ans+" who?");
            Pause();
            String Joke = Reader.readLine();
            System.out.println(Joke);
            
            
            
            Reader.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
        KnockClient Client = new KnockClient();
        Client.go();
    }
    public void Pause()
    {
        try 
        {
            Thread.sleep(2000);
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }
    }
}
