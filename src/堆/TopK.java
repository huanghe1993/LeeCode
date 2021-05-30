package 堆;

import java.util.Arrays;

public class TopK {

    public static int[] topK(int[] data,int topK){
        int[] result = new int[topK];
        System.arraycopy(data,0,result,0,5);
        MinHeap minHeap = new MinHeap(result);
        for (int i = topK; i < data.length; i++) {
            int root = minHeap.getRoot();
            if (data[i]> root){
                minHeap.setRoot(data[i]);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] input = {56,275,12,6,45,478,41,1236,456,12,546,45};
        int[] topK = topK(input,5);
        System.out.println(Arrays.toString(topK));


    }
}
