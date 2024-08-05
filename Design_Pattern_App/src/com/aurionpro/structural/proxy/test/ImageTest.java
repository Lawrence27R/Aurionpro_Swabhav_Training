package com.aurionpro.structural.proxy.test;

import com.aurionpro.structural.proxy.model.IImage;
import com.aurionpro.structural.proxy.model.ProxyImage;

public class ImageTest {
    public static void main(String[] args) {
        IImage image = new ProxyImage("Image_10mb.jpg");

        // The image will be loaded from disk
        image.display();
        System.out.println("");

        // The image will not be loaded from disk again
        image.display();
    }
}

