package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Service {

    private Socket clientSocket = null;
    private BufferedWriter out;
    private BufferedReader in;
    private static Service instance;
    private final int PORT_NUMBER = 9999;
    private final String IP = "localhost";

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }
    public void startConnection() {
        try {
            clientSocket = new Socket(IP, PORT_NUMBER);
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String sendMessage(String msg) {
        try {
            out.write(msg);
            out.newLine();// xuống dòng
            out.flush();
            String resp = in.readLine();
            return resp;
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Service() {
    }
}
