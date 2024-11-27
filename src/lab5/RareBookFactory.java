package lab5;

public class RareBookFactory extends BookFactory {
    
    public Book createBook(String title){
        return new RareBook(title);
    }    
}