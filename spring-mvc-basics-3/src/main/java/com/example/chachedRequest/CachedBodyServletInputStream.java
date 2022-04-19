package com.example.chachedRequest;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 11:30 AM
**/
public class CachedBodyServletInputStream extends ServletInputStream {

    private InputStream cachedBodyInputStream;

    public CachedBodyServletInputStream(byte[] cachedBodyInputStream) {
        this.cachedBodyInputStream = new ByteArrayInputStream(cachedBodyInputStream);
    }

    @Override
    public boolean isFinished() {
        try {
            return cachedBodyInputStream.available()==0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int read() throws IOException {
        return cachedBodyInputStream.read();
    }
}
