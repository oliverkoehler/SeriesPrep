package de.koehler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateZip {
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");
    String[] products = {"Alerts", "Intermission-Banner", "Talking-Banner", "Transition", "Webcam-Overlay", "Desktop-Wallpaper", "Panels", "Twitch-Profile", "Youtube-Banner"};

    public CreateZip(String[] languages, boolean bundles) throws IOException {
        prop.load(ip);
        String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname");

        //Bundles
        for (String language : languages){
            multiThreadBasic basic = new multiThreadBasic(language, path);
            basic.start();
            multiThreadPremium premium = new multiThreadPremium(language, path);
            premium.start();
        }

        //Single Products
        for (String language : languages){
            for (String product : products){
                multiThreadZip t = new multiThreadZip(language, product);
                t.start();
            }
        }
    }
}
