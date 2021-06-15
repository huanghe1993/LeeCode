package DFS和BFS;

import java.util.ArrayList;
import java.util.List;

public class 全排列_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(result, temp, nums, visited);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length){
            if (!result.contains(temp)){
                result.add(new ArrayList<>(temp));
                return;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])){
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            dfs(result, temp, nums, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,3};
        List<List<Integer>> permute = new 全排列_47().permuteUnique(nums);
        System.out.println(permute);
    }
}
