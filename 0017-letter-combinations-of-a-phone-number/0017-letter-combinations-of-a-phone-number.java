class Solution {
    
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
        
        BT(0, "", digits, map, result);
        
        return result;
    }
    
    public void BT(int index, String letter, String digits, Map<Integer, List<Character>> map, List<String> result) {
        if (index >= digits.length()) {
            if (!letter.isEmpty()) {
                result.add(letter);    
            }
            return;
        }
        
        int n = Character.getNumericValue(digits.charAt(index));
        List<Character> characters = map.get(n);
        for (Character character : characters) {
            String added = letter + character;
            BT(index + 1, added, digits, map, result);
        }
        
    }
}