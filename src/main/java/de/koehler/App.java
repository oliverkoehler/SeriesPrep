package de.koehler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App
{
    public static void main(String[] args ) throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");
        prop.load(ip);
        String[] languages = {"EN", "DE"};

        if (prop.getProperty("sortFiles").equals("true")){
            new InteractiveShowcases(languages);
            new ProductPictures(languages);
            new UploadVideos(languages);
            new BgBlank();
        }
        if (prop.getProperty("createZips").equals("true")){
            System.out.println("Starte createZips");
            new CreateZip(languages, true);
        }
    }
}
