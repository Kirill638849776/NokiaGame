package java.io;

public abstract class InputStream {
    public int read() { return -1; }
    public int read(byte[] b, int off, int len) { return -1; }
    public void close() {}
}
