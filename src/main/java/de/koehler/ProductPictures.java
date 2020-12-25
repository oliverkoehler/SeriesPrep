package de.koehler;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProductPictures {
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");

    String[] cases = {
            "-overlaytrailer-NOFB.jpg",
            "-alert-product-picture.jpg",
            "-desktop-wallpaper-product-picture.jpg",
            "-intermission-banners-product-picture.jpg",
            "-panels-product-picture.jpg",
            "-talking-banner-product-picture.jpg",
            "-transition-product-picture.jpg",
            "-twitch-profile-picture.jpg",
            "-webcam-product-picture.jpg",
            "-youtube-banner-product-picture.jpg"
    };

    ProductPictures() throws IOException {
        prop.load(ip);
        String path = prop.getProperty("seriesfolder") + prop.getProperty("seriesname") + "\\SHOP\\EN\\";
        for (String aCase : cases) {
            FilesByName files = new FilesByName(path, aCase);

            for (File file : files.files) {
                File copied = new File(prop.getProperty("targetPath") + "ProductPictures\\" + file.getName());
                FileUtils.copyFile(file, copied);
            }


        }
    }
}
