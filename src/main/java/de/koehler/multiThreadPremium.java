package de.koehler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class multiThreadPremium extends Thread{
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    String language;
    String path;

    multiThreadPremium(String language, String path) throws FileNotFoundException {
        this.language = language;
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("Starte Thread Premium " + language);

        try {
            prop.load(ip);
            FilesByName files = new FilesByName(path, "-Series-Premium-" + language);

            for(int i = 0; i < files.files.length; i++){
                new Zip(prop.getProperty("seriesname") + "-Premium-" + language, "D:\\Output\\" + prop.getProperty("seriesname") + "\\", files.files);
            }

        } catch (NullPointerException | IOException ignored){}
        System.out.println("Beende Thread Premium " + language);
    }
}
