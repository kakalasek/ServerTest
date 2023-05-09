package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    ServerSocket server;
    boolean isRunning;

    public MyServer(int port) throws IOException {
        server = new ServerSocket(port);
        isRunning = true;
        serverLoop();
    }

    private void serverLoop() throws IOException {
        System.out.println("Sever is running");
        while(isRunning) {
            Socket socket = server.accept();
            clientLoop(socket);
        }
    }

    private void clientLoop(Socket socket) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter.println("Hello there");
        printWriter.flush();
        boolean isOn = true;
        while(isOn){
            String data = bufferedReader.readLine();
            data = data.trim();
            printWriter.println(data);
            printWriter.flush();
            if(data.toLowerCase().equals("konec")){
                isOn = false;
                printWriter.println("Sbohem");
                printWriter.flush();
            }
        }
    }
}
