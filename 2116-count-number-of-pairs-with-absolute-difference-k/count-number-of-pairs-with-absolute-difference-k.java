class Solution {

    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int num : nums) {
            cnt += map.getOrDefault(num - k, 0);
            cnt += map.getOrDefault(num + k, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return cnt;
    }
}
