package de.koehler;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class InteractiveShowcases {
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    String[] cases = {
            "-alert-cheer-ia-en.webm",
            "-alert-donation-ia-en.webm",
            "-alert-follower-ia-en.webm",
            "-alert-host-ia-en.webm",
            "-alert-raid-ia-en.webm",
            "-alert-subscriber-ia-en.webm",
            "-desktop-wallpaper-ia-en.webm",
            "-intermission-ending-ia-en.webm",
            "-intermission-offline-ia-en.webm",
            "-intermission-pause-ia-en.webm",
            "-intermission-starting-ia-en.webm",
            "-overlay-ia-en.webm",
            "-talking-banner-ia-en.webm",
            "-twitch-profile-ia-en.webm",
            "-webcam-ia-en.webm",
            "-youtube-banner-ia-en.webm"
    };

    InteractiveShowcases(String[] languages) throws IOException {
        prop.load(ip);
        for (String language : languages) {
            String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname") + "\\SHOP\\" + language + "\\";
            for (String aCase : cases) {
                FilesByName files = new FilesByName(path, aCase);
                if (files.files.length == 0){
                    System.err.println("File does not exist. File: " + prop.getProperty("seriesname") + aCase);
                }

                for (File file : files.files) {
                    File copied = new File(prop.getProperty("targetPath") + "IA\\" + language.toLowerCase() + "\\" + file.getName());
                    FileUtils.copyFile(file, copied);
                }
            }
        }
        System.out.println("1 / 9 - Interactive Showcases completed.");
    }
}
