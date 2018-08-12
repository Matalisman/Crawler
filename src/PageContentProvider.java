
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class PageContentProvider {
    String content;
    Scanner scanner;
    
    String readPageContent(URL url)
    {
        System.out.println("readPageContent");
        try {
            scanner = new Scanner(url.openStream());
        } catch (IOException e) {
            System.out.println("Can not read URL");
        }
        
        while(scanner.hasNext()) {
            content += scanner.nextLine();
        }    
        
        return content;    
    }
}
