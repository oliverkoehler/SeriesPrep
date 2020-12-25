package de.koehler;

import java.io.File;
import java.io.FilenameFilter;

public class FilesByName {
    File[] files;
    FilesByName(String searchPath, final String filterBy){
        File dir = new File(searchPath);
        FilenameFilter filter = (dir1, name) -> name.contains(filterBy);
        files = dir.listFiles(filter);
    }
}
