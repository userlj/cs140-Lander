package lab04;

public class Book2Helper {

	static Book2 bookWithMostPages(Book2[] array) {
		Book2 returnVal = null;
		if(array != null && array.length > 0) {
			int maxIndex = 0;
			while(maxIndex < array.length 
					&& array[maxIndex] == null){
				maxIndex++; 
			}
			if (maxIndex < array.length) {
				int maxPages = array[maxIndex].getPageCount();
				for(int i = maxIndex+1; i < array.length; i++) {
					if(array[i] != null && array[i].getPageCount() > maxPages) {
						maxIndex = i;
						maxPages = array[i].getPageCount();
					}
				}
				returnVal= array[maxIndex];
			}
		}
		return returnVal;
	}

}
