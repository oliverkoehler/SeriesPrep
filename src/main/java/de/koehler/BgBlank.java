package de.koehler;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BgBlank {
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    String cases = "intermission-bg-blank";

    BgBlank() throws IOException {
        prop.load(ip);

        String path = "G:\\Geteilte Ablagen\\Animation\\Projects\\Animated Overlays\\" + prop.getProperty("seriesname") + "\\Webm";
        FilesByName files = new FilesByName(path, cases);

        if (files.files.length == 0){
            System.err.println("File: " + prop.getProperty("seriesname") + cases + " Desc: File does not exist.");
        }

        for (File file : files.files) {
            File copied = new File(prop.getProperty("targetPath") + prop.getProperty("seriesname") + "\\Others\\" + file.getName());
            FileUtils.copyFile(file, copied);
        }

        System.out.println("4 / 7 - Others completed.");
    }
}
