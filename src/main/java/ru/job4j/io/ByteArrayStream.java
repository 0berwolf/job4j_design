package ru.job4j.io;

import javax.imageio.IIOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStream {
    public static void main(String[] args) {
        byte[] bytes = new byte[] {'J', 'a', 'v', 'a'};
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        int data;
        while ((data = stream.read()) != -1) {
            System.out.print((char) data);
        }
        System.out.println();
        String str = "123456789";
        byte[] bytes1 = str.getBytes();
        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes1, 3, 4);
        int data1;
        while ((data1 = byteStream.read()) != -1) {
            System.out.print((char) data1);
        }
        System.out.println();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] bytes2 = "Message".getBytes();
        outStream.writeBytes(bytes2);
        System.out.println(outStream);
        System.out.println();
        try (FileOutputStream fileOutputStream = new FileOutputStream("data/message.txt")) {
            outStream.writeTo(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
