package de.koehler;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final String newLine = System.getProperty("line.separator");

    Log(String msg){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String sendMsg = dtf.format(now) + " - " + msg;
        String fileName = "out.txt";

        PrintWriter printWriter = null;
        File file = new File(fileName);
        try {
            if (!file.exists()){
                file.createNewFile();
            } else {
                printWriter = new PrintWriter(new FileOutputStream(fileName, true));
                printWriter.write(newLine + sendMsg);
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }
}
