class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dirs) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];

                if (r >= 0 && r < m && c >= 0 && c < n && dist[r][c] == -1) {
                    dist[r][c] = dist[cur[0]][cur[1]] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }

        return dist;
    }
}