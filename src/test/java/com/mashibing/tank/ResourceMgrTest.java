package com.mashibing.tank;

import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * @author william
 * @create 2021-11-03 21:36
 **/
public class ResourceMgrTest {
    @Test
    public void test() throws IOException {
        BufferedImage read = ImageIO.read(ResourceMgrTest.class.getResourceAsStream("/images/tankD.gif"));
        System.out.println("11"+read);
    }

}