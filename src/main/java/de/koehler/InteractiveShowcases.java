package de.koehler;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InteractiveShowcases {
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    String[] cases = {
            "-alert-cheer-ia-",
            "-alert-donation-ia-",
            "-alert-follower-ia-",
            "-alert-host-ia-",
            "-alert-raid-ia-",
            "-alert-subscriber-ia-",
            "-desktop-wallpaper-ia-",
            "-intermission-ending-ia-",
            "-intermission-offline-ia-",
            "-intermission-pause-ia-",
            "-intermission-starting-ia-",
            "-overlay-ia-",
            "-talking-banner-ia-",
            "-twitch-profile-ia-",
            "-webcam-ia-",
            "-youtube-banner-ia-"
    };

    InteractiveShowcases(String[] languages) throws IOException {
        prop.load(ip);
        for (String language : languages) {
            String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname") + "\\SHOP\\" + language + "\\";
            for (String aCase : cases) {
                FilesByName files = new FilesByName(path, aCase);
                if (files.files.length == 0){
                    System.err.println("Lang: " + language + " File: " + aCase + " Desc: File does not exist.");
                }

                for (File file : files.files) {
                    File copied = new File(prop.getProperty("targetPath") + prop.getProperty("seriesname") + "\\IA\\" + language + "\\" + file.getName());
                    FileUtils.copyFile(file, copied);
                }
            }
        }
        System.out.println("1 / 9 - Interactive Showcases completed.");
    }
}
