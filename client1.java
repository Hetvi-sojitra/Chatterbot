import java.net.*;
import java.io.*;
class client1
{
 private Socket socket =null;   
 private DataInputStream input =null;
 private DataOutputStream out=null;
 private DataInputStream in =null;

 public client1(String address,int port){
    try{
        socket=new Socket(address,port);
        System.out.println("Connected");
        input= new DataInputStream(System.in);
        out= new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

    }
    catch(IOException u){
        System.out.println(u);
    }
    String line=" ";
    String rec="";
    while(!line.equals("over") || !rec.equals("over")){
        try{
            System.out.println("Enter your message :");
            line=input.readLine();
            out.writeUTF(line);

           
            rec=in.readUTF();
            System.out.println("Message received is :");
            System.out.println(rec);
        }
        catch(IOException i){
            System.out.println(i);
        }
    }
   


}
public static void main(String args[]){
    client1 client=new client1("192.168.43.113",8085);
        
}

    }