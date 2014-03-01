package week4;

public class BookTester {

	private static Book bookWithMostPages(Book[] array) {
		Book returnVal = null;
		if(array != null && array.length > 0) {
			int maxIndex = 0;
			while(maxIndex < array.length 
					&& array[maxIndex] == null){
				maxIndex++; 
			}
			if (maxIndex < array.length) {
				int maxPages = array[maxIndex].getNumPages();
				for(int i = maxIndex+1; i < array.length; i++) {
					if(array[i] != null && array[i].getNumPages() > maxPages) {
						maxIndex = i;
						maxPages = array[i].getNumPages();
					}
				}
				returnVal= array[maxIndex];
			}
		}
		return returnVal;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Book[] books = new Book[3];

		books[1] = new Book("Big Java", "Horstmann", 1150);
		if(books[1] != null) {
			System.out.println(books[1].getNumPages());
		} else {
			System.out.println("no such book");
		}

		// null can be hidden in the fields:
		Book b = new Book();
		System.out.println(b.getNumPages());
		//System.out.println(b.getTitle().length());


		Book[] books1 = new Book[10];


		Book b1 = new Book("Big Java 3rd ed", "Horstmann", 1150);
		Book b2 = new Book("Big Java 4th ed", "Horstmann", 1160);
		Book b3 = new Book("Big Java 5th ed", "Horstmann", 1100);      

		Book[] books2 = {b1, b2, b3};

		if(books2[1] != null) {
			System.out.println(books2[1].getTitle());
		} else {
			System.out.println("no such book");
		}

		Book bMax = bookWithMostPages(books1);
		System.out.println(bMax);
	}


}
