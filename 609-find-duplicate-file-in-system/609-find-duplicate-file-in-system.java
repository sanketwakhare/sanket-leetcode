class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] tokens = path.split(" ");
            String directory = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                String fileName = tokens[i].substring(0, tokens[i].indexOf('('));
                String content = tokens[i].substring(tokens[i].indexOf('(') + 1, tokens[i].length() - 1);
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(directory + "/" + fileName);
                map.put(content, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            if (list.size() > 1) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}