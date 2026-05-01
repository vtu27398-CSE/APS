class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int room = q.poll();

            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    q.add(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }
}