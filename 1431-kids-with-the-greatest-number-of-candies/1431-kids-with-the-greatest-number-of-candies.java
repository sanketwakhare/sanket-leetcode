class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        List<Boolean> list = new ArrayList<>();
        for(int currCandies:candies) {
            maxCandies = Math.max(maxCandies, currCandies);
        }
        for(int currCandies : candies) {
            if(currCandies + extraCandies >= maxCandies) {
               list.add(true); 
            } else {
               list.add(false);
            }
        }
        return list;
    }
}