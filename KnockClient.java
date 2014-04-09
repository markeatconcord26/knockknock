/* ******************************************** */
/* Programmer: Mark Ellison                     */
/* Date: 4/9/2014                               */
/* Propose: A program that acts like a client   */
/* for a knock knock joke network sender.       */
/* ******************************************** */


package knockclient;
import java.io.*;
import java.net.*;

public class KnockClient 
{
    public void go()
    {
        try
        {
            
            //Makes the connection and Input streams 
            //of the connection.
            Socket connection = new Socket ("10.12.3.227",4242);
            InputStreamReader StreamReader= new 
                    InputStreamReader(connection.getInputStream());
            BufferedReader Reader = new BufferedReader(StreamReader);
            
            
            //Runs the Knock knock sim.
            //Alternates between getting data
            //and displaying it.
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
    
    //Main class. Constructs the thread to run
    //the server.
    public static void main(String[] args) 
    {
        KnockClient Client = new KnockClient();
        Client.go();
    }
    
    //Makes sure that the pause in between jokes
    //is humanlly readable and don't go to fast.
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
