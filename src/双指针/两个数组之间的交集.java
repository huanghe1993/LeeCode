package 双指针;

import java.util.*;

public class 两个数组之间的交集 {

    /**
     * https://zhuanlan.zhihu.com/p/157976012
     * 求解的是；两个数组的交集，前提是这两个数组没有重复的元素
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < maxSize; i++) {
            if (i < nums1.length) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }
            if (i < nums2.length) {
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (2 == entry.getValue()) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 求多个数组的交集，这个是时候多个数组可能会存在交集
     *
     * @param arrays 数组
     * @return 数组的交集
     */
    public int[] intersection2(int[][] arrays) {
        if (arrays.length == 0) {
            return new int[0];
        }
        int[] ints = Arrays.stream(arrays).min(Comparator.comparing(a -> a.length)).get();
        List<HashSet<Integer>> collects = new ArrayList<>();
        for (int[] a : arrays) {
            HashSet<Integer> integers = new HashSet<>(Arrays.asList(Arrays.stream(a).boxed().toArray(Integer[]::new)));
            collects.add(integers);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            boolean status = true;
            for (HashSet<Integer> set : collects) {
                if (!set.contains(ints[i])) {
                    status = false;
                    break;
                }
            }
            if (status) {
                res.add(ints[i]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).distinct().toArray();
    }

    public List<Object> intersection3(int[][] arrays) {
        List<List<Object>> allCourses = new ArrayList<>();
        List<Object> commonCourses = allCourses.stream()
                .reduce((list1, list2) -> {
                    list1.retainAll(list2);
                    return list1;
                })
                .orElse(Collections.emptyList());
        return commonCourses;
    }

    public <T> List<T> twoDArrayToList(T[][] twoDArray) {
        List<T> list = new ArrayList<T>();
        for (T[] array : twoDArray) {
            list.addAll(Arrays.asList(array));
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = new 两个数组之间的交集().intersection(nums1, nums2);

        int[][] array = new int[][]{{1, 2, 2, 1}, {2, 2}};
        int[] intersection2 = new 两个数组之间的交集().intersection2(array);
        System.out.println(Arrays.toString(intersection2));
    }
}
