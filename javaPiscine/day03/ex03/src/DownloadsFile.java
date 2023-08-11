
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class DownloadsFile {
    Queue<URL> url = new LinkedList<>();
    ArrayList<String> str;
    Integer countThreads;
    ArrayList<MyThreads> threads = new ArrayList<>();
    int count = 1;
    public DownloadsFile(ArrayList<String> str, Integer countThreads) {
        this.str = str;
        this.countThreads = countThreads;
    }
    public URL getUrl() {
        return url.element();
    }
    public URL poolUrl() {
        count++;
        return url.poll();
    }

    public Integer getCount() {
        return count;
    }

    public void queueURL() throws MalformedURLException {
        for (String value : this.str) {
            String[] s = value.split(" ");
            URL uri = new URL(s[1]);
            url.add(uri);
        }
    }

    public void downloads() throws IOException {
        queueURL();
        for (int i = 0; i < countThreads; ++i) {
            this.threads.add(new MyThreads(("Thread_" +(i+1)), this));
        }
            while (!url.isEmpty()) {
                for (MyThreads thread : threads) {
                    if(!url.isEmpty())
                        thread.run();
                    else
                        break;
                }
            }
        }
}

