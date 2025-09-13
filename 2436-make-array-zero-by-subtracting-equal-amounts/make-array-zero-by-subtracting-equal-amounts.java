class Solution {
    public int minimumOperations(int[] nums) {
        HashSet <Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                set.add(nums[i]);
            }
        }
        int sizeofset=set.size();
        return sizeofset;
    }
}