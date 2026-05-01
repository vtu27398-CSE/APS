class Solution {
    public String longestNiceSubstring(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));

                if (j - i + 1 > ans.length() && isNice(set)) {
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }

    private boolean isNice(HashSet<Character> set) {
        for (char c : set) {
            if (Character.isLowerCase(c)) {
                if (!set.contains(Character.toUpperCase(c))) return false;
            } else {
                if (!set.contains(Character.toLowerCase(c))) return false;
            }
        }

        return true;
    }
}