package de.koehler;

import java.io.File;
import java.io.FilenameFilter;

public class FilesByName {
    File[] files;

    FilesByName(String searchPath, final String filterBy){
        File dir = new File(searchPath);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.contains(filterBy);
            }
        };
        files = dir.listFiles(filter);

        assert files != null;
        if (files.length == 0){
            System.err.println("File does not exists. Filter: " + filterBy);
        }
    }
}
