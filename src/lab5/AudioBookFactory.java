package lab5;

public class AudioBookFactory extends BookFactory {
    
    public Book createBook(String title){
        return new AudioBook(title);
    }    
}