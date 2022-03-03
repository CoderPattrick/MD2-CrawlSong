import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            Scanner input = new Scanner(new InputStreamReader(url.openStream()));
            input.useDelimiter("\\Z");
            String content = input.next();
            input.close();
            content = content.replaceAll("\\n+","");

            Pattern p =Pattern.compile("name_song\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while(m.find()){
                System.out.println(m.group(1));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
