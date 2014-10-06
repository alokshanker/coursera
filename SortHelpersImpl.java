
public class SortHelpersImpl implements SortHelpers {

	@Override
	public void exch(Comparable[] a, int j, int i) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	@Override
	public boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

}
