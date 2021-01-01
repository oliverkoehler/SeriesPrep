package de.koehler;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class UpdateFiles {
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream(".\\src\\main\\resources\\config.properties");
    String sourceFile;
    String targetFile;
    String changeCase;

    private void updateZip(FilesByName sourceFile, FilesByName targetFile) throws ZipException {
        ZipFile zipFile = new ZipFile(targetFile.filePath);
        for (File file : sourceFile.files) {
            zipFile.addFolder(file);
        }
    }

    public UpdateFiles() throws IOException {
        prop.load(ip);
        this.sourceFile = prop.getProperty("sourceFile");
        this.targetFile = prop.getProperty("targetFile");
        this.changeCase = prop.getProperty("case");
        FilesByName targetFile = new FilesByName(this.targetFile, changeCase);
        FilesByName sourceFile = new FilesByName(this.sourceFile, changeCase);
        updateZip(sourceFile, targetFile);
        System.out.println(targetFile.filename);
        Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome https://origin.cdn.own3d.tv/home?q=" + targetFile.filename});
    }
}
