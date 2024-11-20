package lab5;

public class Ebook implements Book {
	private String title;
	private boolean isAvailable;
	
	public Ebook(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public boolean getIsAvailable() {
		return isAvailable;
	}
}
