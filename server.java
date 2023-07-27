import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8085);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        System.out.println("Reading: " + System.currentTimeMillis());

        byte[] sizeAr = new byte[4];
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();//C:\Users\KUSH SONI\Desktop\Semester 3\OOP\Innovativve\Image Transmission\trial2

        byte[] imageAr = new byte[size];
        inputStream.read(imageAr);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

        System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
        ImageIO.write(image, "jpg", new File("/Users/hetvisojitra/Desktop/kush.jpg"));
               serverSocket.close();
    }

}