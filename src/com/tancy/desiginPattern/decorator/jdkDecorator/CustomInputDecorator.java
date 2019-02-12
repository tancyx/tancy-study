package com.tancy.desiginPattern.decorator.jdkDecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomInputDecorator extends FilterInputStream {

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected CustomInputDecorator(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c=super.read();
        return c==-1?c:Character.toLowerCase((char) c);
    }

    @Override
    public int read(byte[] b) throws IOException {
        int r=super.read(b);
        for (int i=0;i<r;i++){
            b[i]=(byte) Character.toLowerCase((char)b[i]);
        }
        return r;
    }
}
