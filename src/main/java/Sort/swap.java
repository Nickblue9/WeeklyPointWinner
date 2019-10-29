package Sort;

import java.util.List;

public class swap {
    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    void swap(List<List<Object>> list, int i, int j){
        List<Object> tmp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,tmp);
    }
}
