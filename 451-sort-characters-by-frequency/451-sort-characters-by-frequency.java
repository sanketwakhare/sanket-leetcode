class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, List<Character>> linkedMap = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int currFreq = map.getOrDefault(ch, 0);
            map.put(ch, currFreq + 1);
        }
        for(var set : map.entrySet()) {
            List<Character> list = linkedMap.getOrDefault(set.getValue(), new ArrayList<>());
            list.add(set.getKey());
            linkedMap.put(set.getValue(), list);
        }
        StringBuilder sb = new StringBuilder();
        for(var curr : linkedMap.entrySet()) {
            int freq = curr.getKey();
            List<Character> list = curr.getValue();
            for(Character ch: list) {
                for(int temp =0; temp < freq; temp++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
