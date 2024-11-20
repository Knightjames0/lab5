package lab5;

public class RareBook implements Book{

	private String title;
	private boolean isAvailable;
	
	public RareBook(String title) {
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
