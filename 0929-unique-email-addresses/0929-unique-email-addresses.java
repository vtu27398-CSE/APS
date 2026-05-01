class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");

            String local = parts[0];
            String domain = parts[1];

            StringBuilder sb = new StringBuilder();

            for (char ch : local.toCharArray()) {
                if (ch == '+') break;
                if (ch != '.') sb.append(ch);
            }

            set.add(sb.toString() + "@" + domain);
        }

        return set.size();
    }
}