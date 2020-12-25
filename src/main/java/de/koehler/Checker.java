package de.koehler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;


public class Checker {
    boolean success = true;
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    Checker(String path, FilesByName files , String[] cases) throws IOException {
        prop.load(ip);

        for (String aCase : cases) {
            File file = new File(path + prop.getProperty("seriesname") + aCase);
            if (!Arrays.asList(files.files).contains(file)){
                new Log("File not exists. Filter: " + aCase + " at: " + path);
                System.err.println("File does not exists. Filter: " + aCase);
            } else {
                this.success = false;
            }
        }
    }
}
