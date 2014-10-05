/**
 * Selection sort: Find the smallest entry in the remaining array and swap it
 * with the first entry of the unsorted array.
 * @author Alok Shankar <alok@alumni.cmu.com>
 *
 */
public class SelectionSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N ; i++){
            int min = i;
            for(int j = i+1; j < N; j++){
                if (less(a[j], a[min])){
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable v, Comparable w) {
    	return v.compareTo(w) < 0;
    }
}
