package lab5;

public class PaperBookFactory extends BookFactory {
    
    public Book createBook(String title){
        return new PaperBook(title);
    }    
}