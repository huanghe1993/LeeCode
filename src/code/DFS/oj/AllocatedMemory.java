package code.DFS.oj;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AllocatedMemory {
    /**
     * 记录以及分配了的区间值
     */
    TreeMap<Integer, Integer> map = new TreeMap<>();

    private boolean release(int index) {
        if (map.containsKey(index)) {
            map.remove(index);
            return true;
        }
        return false;
    }

    private String request(int size) {
        int startAddress = 0;
        if (size < 0 || size > 100) {
            return "error";
        }
        if (map.isEmpty()) {
            map.put(0, size);
            return String.valueOf(0);
        }
        List<Integer> indexs = new ArrayList<>(map.keySet());
        for (Integer index : indexs) {
            if (index - startAddress >= size) {
                map.put(index, index + size);
                return String.valueOf(index);
            } else {
                startAddress = map.get(index);
            }
        }
        if (100 - startAddress >= size) {
            map.put(startAddress, startAddress + size);
            return String.valueOf(startAddress);
        } else {
            return "error";
        }
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        AllocatedMemory allocatedMemory = new AllocatedMemory();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int line = Integer.parseInt(cin.nextLine());
        String[][] ins = new String[line][2];
        for (int i = 0; i < line; i++) {
            ins[i] = cin.nextLine().split("=");
            if (ins[i][0].startsWith("REQUEST")) {
                System.out.println(allocatedMemory.request(Integer.parseInt(ins[i][1])));
            } else {
                boolean ret = allocatedMemory.release(Integer.parseInt(ins[i][1]));
                if (!ret) {
                    System.out.println("error");
                }
            }
        }

        cin.close();
    }


}


