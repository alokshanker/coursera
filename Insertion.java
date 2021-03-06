
/**
 * Insertion sort. Insert the first element from the unsorted array into the
 * appropriate position by value in the left side sorted array.
 * @author Alok Shankar <alok@alumni.cmu.com>
 *
 */
public class Insertion {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N ; i++){
            for (int j = i; j > 0 ; j--){
                if(less(a[j], a[j-1])){
                    exch(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    private static void exch(Comparable[] a, int j, int i) {
       Comparable swap = a[i];
       a[i] = a[j];
       a[j] = swap;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
