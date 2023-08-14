class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        BT(0, new ArrayList<>(), nums, result);
        
        return result;
    }
    
    public void BT(int level, List<Integer> letters, int[] nums, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(letters);
            return;
        }
        
        List<Integer> exclude = Arrays.stream(nums)
            .filter(i -> !letters.contains(i))
            .boxed()
            .collect(Collectors.toList());
        
        for(Integer i : exclude) {
            List<Integer> tmp = new ArrayList<>(letters);
            tmp.add(i);
            BT(level + 1, tmp, nums, result);
        }
    }
}