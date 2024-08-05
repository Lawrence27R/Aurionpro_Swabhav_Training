package com.aurionpro.structural.composite.test;
import com.aurionpro.structural.composite.model.DirectoryComposite;
import com.aurionpro.structural.composite.model.FileLeaf;
import com.aurionpro.structural.composite.model.FileSystemComponent;

public class FileSystemTest {
    public static void main(String[] args) {
    	FileSystemComponent file1 = new FileLeaf("File1.txt");
        FileSystemComponent file2 = new FileLeaf("File2.txt");
        FileSystemComponent file3 = new FileLeaf("File3.jpg");

        DirectoryComposite directory1 = new DirectoryComposite("Directory1");
        DirectoryComposite directory2 = new DirectoryComposite("Directory2");

        directory1.add(file1);
        directory1.add(file2);

        directory2.add(file3);
        directory2.add(directory1);
        directory1.remove(file1);
        directory2.showDetails();
        
    }
}

