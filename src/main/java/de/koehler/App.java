package de.koehler;

import java.io.IOException;

public class App
{
    public static void main(String[] args ) throws IOException {
        String[] languages = {"EN"};
        new InteractiveShowcases(languages);
        new ProductPictures(languages);
    }
}
