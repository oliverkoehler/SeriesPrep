package de.koehler;

import java.io.IOException;

public class App
{
//   Todo
//    Implement Zipper

    public static void main(String[] args ) throws IOException {
        String[] languages = {"EN", "DE", "ES", "FR", "PT"};
        new InteractiveShowcases(languages);
        new ProductPictures(languages);
        new UploadVideos(languages);
        new BgBlank();
    }
}
