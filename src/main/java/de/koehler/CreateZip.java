package de.koehler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateZip {
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    public void createZips(String[] languages, String filterBy) throws IOException {
        for (String language : languages){
            String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname") + "\\" + prop.getProperty("seriesname") + "-Series-Premium-" + language + "\\Files";
            FilesByName files = new FilesByName(path, filterBy);
            new Zip(prop.getProperty("seriesname") + "-" + filterBy + "-" + language, "D:\\Output\\" + prop.getProperty("seriesname") + "\\", files.files);
        }
    }

    public CreateZip(String[] languages) throws IOException {
        prop.load(ip);
        String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname");

        //Basic
        for (String language : languages){
            FilesByName files = new FilesByName(path, "-Series-Basic-" + language);

            for(int i = 0; i < files.files.length; i++){
                new Zip(prop.getProperty("seriesname") + "-Basic-" + language, "D:\\Output\\" + prop.getProperty("seriesname") + "\\", files.files);
            }
        }

        System.out.println("5 / 7 - Basic Zips completed.");

        //Premium
        for (String language : languages){
            FilesByName files = new FilesByName(path, "-Series-Premium-" + language);

            for(int i = 0; i < files.files.length; i++){
                new Zip(prop.getProperty("seriesname") + "-Premium-" + language, "D:\\Output\\" + prop.getProperty("seriesname") + "\\", files.files);
            }
        }
        System.out.println("6 / 7 - Premium Zips completed.");

        //Single Products
        String[] products = {"Alerts", "Intermission-Banner", "Talking-Banner", "Transition", "Webcam-Overlay", "Desktop-Wallpaper", "Panels", "Twitch-Profile", "Youtube-Banner"};

        for (String product : products){
            createZips(languages, product);
        }

        System.out.println("7 / 7 - Single Product Zips completed.");
    }
}
