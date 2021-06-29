/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.JDBC;

/**
 *
 * @author Admin
 */
public class socketServer {

    ServerSocket server;

    public socketServer() throws IOException {
        try {
            JDBC.con = JDBC.getconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(socketServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(socketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        server = new ServerSocket(8888);
        while (true) {
            System.out.println("wait for request");
            Socket client = server.accept();
            new Thread(new socketThread(client)).start();
        }
    }
    public static void main(String[] args) {
        try {
            new socketServer();
        } catch (IOException ex) {
            Logger.getLogger(socketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
