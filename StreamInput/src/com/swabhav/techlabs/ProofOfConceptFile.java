package com.swabhav.techlabs;

import java.io.File;
import java.text.SimpleDateFormat;

public class ProofOfConceptFile {
    public static void main(String[] args) {

        File file = new File("D:\\Aurionpro\\StreamInput\\src\\com\\swabhav\\techlabs\\test");

        if (!file.exists()) {
            System.out.println("File not found: ");
            return;
        }

        System.out.println("File Path: " + file.getPath());
        System.out.println("File Type: " + getFileType(file));
        System.out.println("File Location: " + file.getParent());
        System.out.println("File Size: " + file.length() + " bytes");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Last Modified: " + dateFormat.format(file.lastModified()));
    }

    private static String getFileType(File file) {
        if (file.isDirectory()) {
            return "Directory";
        } else if (file.isFile()) {
            return "File";
        } else {
            return "Other";
        }
    }
}
