/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class downloadFile implements Runnable {

    private String url;
    private File file;

    public downloadFile(String url, String filename) {
        this.url = url;
        this.file = new File(formatFilename(filename));
        try {
            createFile(file);
        } catch (IOException ex) {
            Logger.getLogger(downloadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public downloadFile() {
    }

    public void createFile(File file) throws IOException {
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
    }

    public String formatFilename(String filename) {
        File folder = new File("image");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return "image/" + filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    

    @Override
    public void run() {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            System.out.println(url);
            in = new BufferedInputStream(new URL(this.url).openStream());
            fout = new FileOutputStream(file.getAbsolutePath());

            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(downloadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(downloadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(downloadFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(downloadFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException ex) {
                    Logger.getLogger(downloadFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
