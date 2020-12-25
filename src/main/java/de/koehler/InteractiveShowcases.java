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
            "-youtube-banner-ia-end.webm"
    };

    InteractiveShowcases() throws IOException {
        prop.load(ip);
        String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname") + "\\SHOP\\EN\\";
        FilesByName showcases = new FilesByName(path, "-ia-");

        for (File file : showcases.files){
            File copied = new File(prop.getProperty("targetPath") + "IA\\" + file.getName());
            FileUtils.copyFile(file, copied);
        }

        new Checker(path, showcases, cases);
    }
}
