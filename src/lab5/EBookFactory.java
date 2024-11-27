package lab5;

public class EBookFactory extends BookFactory {
    
    public Book createBook(String title){
        return new Ebook(title);
    }    
}