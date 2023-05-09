import Server.MyServer;

import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try {
            MyServer server = new MyServer(65525);
        }catch(Exception e){
            System.out.println("Connection error!");
        }
    }
}
