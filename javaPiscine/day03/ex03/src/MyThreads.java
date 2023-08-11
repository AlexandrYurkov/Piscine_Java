import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MyThreads implements Runnable {
    String name;
    DownloadsFile files;
    public MyThreads(String name, DownloadsFile files) {
        this.files = files;
        this.name =name;
    }

    public static String fileName(String str) {
        String[] name = str.split("/");
        return name[name.length - 1];
    }

    public void downloadFile(URL url, String fileName) throws IOException {
        try (InputStream in = url.openStream();
             BufferedInputStream bis = new BufferedInputStream(in);
             FileOutputStream fos = new FileOutputStream(fileName)) {

            byte[] data = new byte[1024];
            int count;
            while ((count = bis.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, count);
            }
        }
    }

    @Override
    public synchronized void run() {
        try {
            int count = files.getCount();
            System.out.println(this.name + " start download file number " + count);
            downloadFile(files.getUrl(), fileName(files.poolUrl().toString()));
            System.out.println(this.name + " finish download file number " + count);
        }catch (IOException e){
            System.out.println("File " + fileName(files.getUrl().toString() + " no downloadFile!"));
            System.err.println(e.getMessage());
        }
    }
}
