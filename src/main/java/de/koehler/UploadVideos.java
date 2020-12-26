package de.koehler;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UploadVideos {
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    String[] cases = {
            "-transition-showcase.webm",
            "-showcase.webm",
            "30sek-1920x1080.mp4"
    };

    UploadVideos(String[] languages) throws IOException {
        prop.load(ip);

        for (String language : languages) {
            String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname") + "\\SHOP\\" + language + "\\";
            for (String aCase : cases) {
                try {
                    FilesByName files = new FilesByName(path, aCase);
                    if (files.files.length == 0){
                        System.err.println("Lang: " + language + " File: " + prop.getProperty("seriesname") + aCase + " Desc: File does not exist.");
                    }

                    for (File file : files.files) {
                        File copied = new File(prop.getProperty("targetPath") + prop.getProperty("seriesname") + "\\UploadVideos\\" + language + "\\" + file.getName());
                        FileUtils.copyFile(file, copied);
                    }
                } catch (NullPointerException ignored){}
            }
        }
        System.out.println("3 / 7 - UploadVideos completed.");
    }
}
