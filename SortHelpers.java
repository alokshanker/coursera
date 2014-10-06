/**
 *
 * @author Alok Shankar <alok@alumni.cmu.edu>
 *
 */
public interface SortHelpers {

	/**
	 * exchange two array elements at a specified index.
	 * @param a
	 * @param j
	 * @param i
	 */
	void exch(Comparable[] a, int j, int i);

	/**
	 * check if a value is lesser than other or not.
	 * @param v
	 * @param w
	 * @return
	 */
	boolean less(Comparable v, Comparable w);
}
