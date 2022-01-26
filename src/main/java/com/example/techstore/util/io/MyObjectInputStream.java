package com.example.techstore.util.io;

import java.io.*;

public class MyObjectInputStream extends ObjectInputStream {
    public MyObjectInputStream() throws IOException
    {
        super();
    }

    public MyObjectInputStream(InputStream i) throws IOException
    {
        super(i);
    }

    public void readStreamHeader() {
        return;
    }
}
