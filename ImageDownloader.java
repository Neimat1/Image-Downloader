import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class ImageDownloader {

    public static void main(String[] args) throws IOException {
        String imageUrl = "https://law.cu.edu.eg/books/arabic/two/a/alaiqtisad/1/files/mobile/";
        String fileName = "";
        int numberOfPages = 222;
        for(int page = 1; page <= numberOfPages; page++) {
            downloadImage(imageUrl+page+".jpg", fileName+page+".jpg");
        }
    }

    private static void downloadImage(String imageUrl, String fileName) throws IOException {
        URL url = new URL(imageUrl);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fos = new FileOutputStream(fileName);

        byte[] buffer = new byte[1024];
        int count;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fos.write(buffer, 0, count);
        }

        fos.close();
        bis.close();
    }
}