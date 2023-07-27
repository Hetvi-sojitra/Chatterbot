import java.util.Scanner; 
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class setTimer 
{  
Timer timer = new Timer();  
setTimer(int seconds)   
{  
//schedule the task  
timer.schedule(new RemindTask(), seconds*1000);   
}  
class RemindTask extends TimerTask   
{  
public void run()   
{  
System.out.println("WE ARE DONE!"); 
playmusi("/Users/hetvisojitra/Desktop/myalarm.wav");
//terminate the timer thread  
timer.cancel();   
}  
}  
//driver code  
public static void main(String args[])   
{  
//function calling 
Scanner sc=new Scanner(System.in); 
int t;
System.out.println("enter the time to be set on timer in seconds :");
t=sc.nextInt();
new setTimer(t); 
}

public static void playmusi(String filepath)
{
    InputStream music;
    //InputStream is an abstract class of Byte Stream that describe stream input and 
    //it is used for reading and it could be a file, image, audio, video, webpage, etc.
    try
    {
        music = new FileInputStream(new File(filepath));
            //an object music of file input string is created which will open new file whose add is passed as filepath
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }
    catch(Exception e)
    {
        System.out.println("Error");
    }
}
}

  
  
