package de.koehler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class multiThreadBasic extends Thread{
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    String language;
    String path;

    multiThreadBasic(String language, String path) throws FileNotFoundException {
        this.language = language;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            prop.load(ip);
            FilesByName files = new FilesByName(path, "-Series-Basic-" + language);

            for(int i = 0; i < files.files.length; i++){
                new Zip(prop.getProperty("seriesname") + "-Basic-" + language, prop.getProperty("targetPath") + prop.getProperty("seriesname") + "\\", files.files);
            }

        } catch (NullPointerException | IOException ignored){}

        System.out.println("Beende Thread Basic " + language);
    }
}
