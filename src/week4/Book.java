package week4;

public class Book {
	private String title;
	private String authors;
	private int numPages;
	
	//null-argument constructor
	public Book() {
		
	}

	
	public Book(String title, String authors, int numPages) {
		super();
		this.title = title;
		this.authors = authors;
		this.numPages = numPages;
	}

	public String getTitle() {
		return title;
	}
	public String getAuthors() {
		return authors;
	}
	public int getNumPages() {
		return numPages;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", authors=" + authors + ", numPages="
				+ numPages + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
