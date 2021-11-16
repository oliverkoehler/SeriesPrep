package de.koehler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class multiThreadZip extends Thread{
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    String language;
    String filterBy;

    multiThreadZip(String language, String filterBy) throws FileNotFoundException {
        this.language = language;
        this.filterBy = filterBy;
    }

    @Override
    public void run() {
        try {
            prop.load(ip);
            String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname") + "\\" + prop.getProperty("seriesname") + "-Series-Premium-" + language + "\\Files";
            FilesByName files = new FilesByName(path, filterBy);
            new Zip(prop.getProperty("seriesname") + "-" + filterBy + "-" + language, prop.getProperty("targetPath") + prop.getProperty("seriesname") + "\\", files.files);
        } catch (NullPointerException | IOException ignored){}

        System.out.println("Beende Thread " + filterBy + " " + language);
    }
}
