
public class ContentChecker {
    
    public boolean checkIfContentHasGivenValues(String content, String regexp)
    {
        System.out.println("checkIfContentHasGivenValues");
        
        return content.matches(regexp);
    }
    
    public boolean checkIfContentHasGivenValues(String content)
    {
        
        return true;
    }
}
