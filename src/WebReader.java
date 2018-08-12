import java.io.IOException;
import java.net.*;
import java.net.URL;

public class WebReader {
    PageContentProvider pageContentProvider;
    ContentChecker pageContentChecker;
    String pageContent;
    
    WebReader() {
       pageContentProvider = new PageContentProvider();
       pageContentChecker = new ContentChecker();
    }

    public boolean checkIfGivenPageHasGivenValue(
        String urlLineFromCsV,
        String checkAgainst
    ) {
          try {
            URL url = new URL(urlLineFromCsV);
            pageContent = pageContentProvider.readPageContent(url);
        } catch (MalformedURLException e) {
            System.out.println("Wrong url");
            System.out.println(e.getMessage());
        }
          
        System.out.println(checkAgainst);
    return 
        pageContentChecker.checkIfContentHasGivenValues(
            pageContent,
            checkAgainst
        );
    }
    
//    private  getUrl(String urlLineFromCsV)
//    {
//        try {
//            System.out.println("checkIfGivenPageHasGivenValue");
//            System.out.println(urlLineFromCsV + " 1");
//            URL url = new URL(urlLineFromCsV);
//            System.out.println("po utworzeniu urla");
//            return url;
//        } catch (MalformedURLException e) {
//            System.out.println("Wrong url");
//            System.out.println(e.getMessage());
//        }
//    }
}
