package de.koehler;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Properties;

public class App
{

    public static void main(String[] args ) throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");
        prop.load(ip);

        String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname") + "\\SHOP\\EN";
        System.out.println(path);
        FilesByName test = new FilesByName(path, "webcam");
        for (File file : test.files){
            System.out.println(file);
        }

        File copied = new File("D:\\test.png");
        FileUtils.copyFile(test.files[0], copied);

    }
}
