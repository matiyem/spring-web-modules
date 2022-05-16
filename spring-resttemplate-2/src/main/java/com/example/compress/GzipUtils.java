package com.example.compress;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/*
    Create by Atiye Mousavi 
    Date: 5/15/2022
    Time: 11:56 AM
**/
public class GzipUtils {
    public static byte[] compress(String text) throws Exception {
        return GzipUtils.compress((text.getBytes(StandardCharsets.UTF_8)));
    }

    public static byte[] compress(byte[] body) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(baos)) {
            gzipOutputStream.write(body);
        }
        return baos.toByteArray();
    }
    public static String decompress(byte[] body) throws IOException {
        try(GZIPInputStream gzipInputStream=new GZIPInputStream(new ByteArrayInputStream(body))) {
            return IOUtils.toString(gzipInputStream,StandardCharsets.UTF_8);
        }
    }
}
