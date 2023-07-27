import java.awt.Desktop;
import java.util.Scanner;
import java.io.*;
import java.net.URI;



class url {
	
	public static void main(String args[])
			throws Exception

             {  
        String inputstring=new String();
             System.out.println("ENTER THE TAB YOU WANT TO OPEN");
             Scanner sc=new Scanner(System.in);
             inputstring=sc.nextLine();

              if(inputstring.equals("OPEN GOOGLE")){
		Desktop desk = Desktop.getDesktop();
		// now we enter our URL that we want to open in our
	 	// default browser
	 	desk.browse(new URI("http://www.google.com"));
	 }

     if(inputstring.equals("OPEN MAIL")){
		Desktop desk = Desktop.getDesktop();
		// now we enter our URL that we want to open in our
	 	// default browser
	 	desk.browse(new URI("https://www.google.com/gmail/about/"));
	 }

     if(inputstring.equals("OPEN NEWS")){
		Desktop desk = Desktop.getDesktop();
		// now we enter our URL that we want to open in our
	 	// default browser
	 	desk.browse(new URI("https://m.timesofindia.com"));
	 }

     if(inputstring.equals("OPEN NETFLIX")){
		Desktop desk = Desktop.getDesktop();
		// now we enter our URL that we want to open in our
	 	// default browser
	 	desk.browse(new URI("https://www.netflix.com/browse"));
	 }

     if(inputstring.equals("OPEN WEATHER")){
		Desktop desk = Desktop.getDesktop();
		// now we enter our URL that we want to open in our
	 	// default browser
	 	desk.browse(new URI("https://weather.com/en-IN/weather/today/l/23.13,72.54"));
	 }


}
}
   

