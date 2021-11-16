package de.koehler;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FilesByName {
    File[] files;
    String filename;
    String filePath;

    FilesByName(String searchPath, final String filterBy){
        try {
            File dir = new File(searchPath);
            FilenameFilter filter = (dir1, name) -> name.contains(filterBy);
            files = dir.listFiles(filter);
            filename = files[0].getName();
            filePath = files[0].getPath();
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e){
            System.out.println("File not found: " + filterBy);
        }
    }
}
