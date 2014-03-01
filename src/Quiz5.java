
public class Quiz5 {

	public static String longest(String[] array) {
		String retVal = null;
		if(array != null) {
			if(array.length == 0) {
				retVal = "";
			} else {
				int i = 0;
				while (i < array.length && array[i] == null) {
					i++;
				}
				if(i < array.length) {
					retVal = array[i];
					for( ; i < array.length; i++) {
						if(array[i] != null && array[i].length() > retVal.length()) {
							retVal = array[i];
						}
					}
				}
			}
		}

		return retVal;
	}

	public static String longest1(String[] array) {
		String retVal = null;
		if(array != null) {
			if(array.length == 0) {
				retVal = "";
			} else {
				int i = 0;
				while (i < array.length && array[i] == null) {
					i++;
				}
				if(i < array.length) {
					retVal = array[i];
					for(int j = i+1 ; j < array.length; j++) {
						if(array[j] != null && 
								array[j].length() > retVal.length()) {
							retVal = array[j];
						}
					}
				}
			}
		}

		return retVal;
	}

	public static String longest2(String[] array) {
		String retVal = null;
		if(array != null) {
			if(array.length == 0) {
				retVal = "";
			} else {
				retVal = array[0];
				for(int j = 1 ; j < array.length; j++) {
					if(array[j].length() > retVal.length()) {
						retVal = array[j];
					}
				}
			}
		}

		return retVal;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] arrays = {
				null, 
				{}, 
				{null, null, null, null},
				{null, "abc", null, "def", null},
				{null, "abc", "gh", "def", null},
				{"a", "abc", "gh", "def", null},
				{"1234", "abc", "gh", "def", null},
				{null, "abc", "gh", "def", "1234"},
		};
		for(String[] arr : arrays) { 
			System.out.println(longest1(arr));
		}

		arrays = new String[][]{
				null, 
				{}, 
				{"a", "abc", "gh", "def"},
				{"1234", "abc", "gh", "def"},
				{"abc", "gh", "def", "1234"},
		};
		for(String[] arr : arrays) { 
			System.out.println(longest2(arr));
		}

	}

}
