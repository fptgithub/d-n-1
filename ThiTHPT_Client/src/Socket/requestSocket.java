/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import Util.RepoundPackageObject;
import Util.Formatter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class requestSocket {

    private Socket socket;

    public requestSocket() {
        try {
            socket = new Socket("localhost", 8888);
        } catch (IOException ex) {
            Logger.getLogger(requestSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void write(String json) {
        DataOutputStream write = null;
        try {
            write = new DataOutputStream(socket.getOutputStream());
            write.writeUTF(json);
            System.out.println("write ok");
            write.flush();
        } catch (IOException ex) {
            Logger.getLogger(requestSocket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//            if (write != null) {
//                try {
//                    write.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(requestSocket.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
    }

    public RepoundPackageObject read() {
        String data = "";
        DataInputStream read = null;
        try {
            read = new DataInputStream(socket.getInputStream());
            data = read.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(requestSocket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (read != null) {
                try {
                    read.close();
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(requestSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println(data);
        return Formatter.GSON.fromJson(data, RepoundPackageObject.class);
    }
    public RepoundPackageObject readDataLong() {
        StringBuilder data = new StringBuilder();
        DataInputStream read = null;
        try {
            String line;
            read = new DataInputStream(socket.getInputStream());
            while(!(line = read.readUTF()).equals("end")){
            data.append(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(requestSocket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (read != null) {
                try {
                    read.close();
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(requestSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println(data);
        return Formatter.GSON.fromJson(data.toString(), RepoundPackageObject.class);
    }
}
