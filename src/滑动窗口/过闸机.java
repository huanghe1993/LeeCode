package 滑动窗口;

public class 过闸机 {

    public int[] getTime(int[] arrTime, int[] direction) {
        int left = 0;
        int[] result = new int[arrTime.length];
        // map的key存的是进闸机的人的序号，value存的是出去的时间
        for (int i = 1; i < arrTime.length; i++) {
            int leftArrTIme = arrTime[left];
            int currArrTime = arrTime[i];
            if (currArrTime != leftArrTIme) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arrTime = {0, 0, 1, 5};
        int[] direction = {0, 1, 1, 0};
        // 输出 [2,0,1,5]
        // [1,0,1,5]
        // [2,0,1,5]

    }
}
