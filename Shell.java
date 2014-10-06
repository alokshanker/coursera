
public class Shell {

    public static void sort(Comparable[] a){
    	SortHelpers x = new SortHelpersImpl();
        int N = a.length;
        int h = 1;
        while(h < N/3){
            h = 3*h + 1;
        }

        while (h >= 1){
            for (int i = 0; i < N ; i++){
                for (int j = i; j > h ; j = j-h){
                    if(x.less(a[j], a[j-h])){
                        x.exch(a, j, j-h);
                    } else {
                        break;
                    }
                }
            }
            h = h/3;
        }
    }
}
