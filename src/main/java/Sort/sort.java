package Sort;

import java.util.List;

public class sort {
    swap swap = new swap();

    public void sort(List<List<Object>> list){
        int[] array = new int[list.size()];
        for(int i = 0; i<list.size(); i++)
            array[i] = Integer.parseInt(list.get(i).get(1).toString());
        quickSort(array,0,array.length-1);

        for(int i = 0; i<list.size(); i++){
            int k=0;
            while(true){
                if(array[i] == Integer.parseInt(list.get(k).get(1).toString())) {
                    swap.swap(list, i, k);
                    break;
                }
                else
                    k++;
            }
        }

    }
    private void quickSort(int[] A, int left, int right){
        if(right<=left)
            return;
        int lp = left, rp = right;
        int v = A[left];
        int i = left +1;
        while(i<=rp){
            if(v<A[i])
                swap.swap(A,lp++,i++);
            else if (v>A[i])
                swap.swap(A,i,rp--);
            else
                i++;
        }
        quickSort(A,left,lp-1);
        quickSort(A,rp+1,right);

    }
}
