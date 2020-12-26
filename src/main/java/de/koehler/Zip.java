package de.koehler;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import java.io.File;
import java.io.IOException;

public class Zip {
    String filename;
    String destination;

    Zip(String filename, String destination, File[] files) throws ZipException, IOException {
        this.filename = filename + ".zip";
        this.destination = destination;

        ZipFile zipFile = new ZipFile(this.destination + this.filename);
        for (File file : files) {
            zipFile.addFolder(file);
        }
    }
}