package assignment08;
import java.util.ArrayList;
import java.util.List;

public class NaiveQuickListSorter implements Sorter {

	private static List<Double> less(List<Double> list) {
		List<Double> retVal = new ArrayList<Double>();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i)< (list.get(0))) {
				retVal.add(list.get(i));
			}
		}
		return retVal;
	}

	private static List<Double> gtreq(List<Double> list) {
		List<Double> retVal = new ArrayList<Double>();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) >= (list.get(0))) {
				retVal.add(list.get(i));
			}
		}
		return retVal;
	}

	private static boolean inOrder(List<Double> list) {
		boolean retVal = true;
		for (int i = 0; i < list.size() - 1 && retVal; i++) {
			if (list.get(i) > (list.get(i + 1))) {
				retVal = false;
			}
		}
		return retVal;
	}

	public static List<Double> sort(List<Double> list) {
		List<Double> retVal = new ArrayList<Double>();
		if(list == null) {
			retVal = null;
		} else if(list.size() == 0 || inOrder(list)) {
			retVal = list;
		} else {
			retVal = sort(less(list));
			retVal.add(list.get(0));
			retVal.addAll(sort(gtreq(list)));
		}
		return retVal;
	}

	@Override
	public double timedSort(double[] array) {
		List<Double> list = new ArrayList<Double>();
		for(double x : array) list.add(x);
	    long start = System.currentTimeMillis();
	    	list = sort(list);
	    long end = System.currentTimeMillis();
	    return end - start;
	}


}
