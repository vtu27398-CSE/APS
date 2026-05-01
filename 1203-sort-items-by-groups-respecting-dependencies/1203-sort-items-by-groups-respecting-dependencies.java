class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        List<Integer>[] itemGraph = new ArrayList[n];
        List<Integer>[] groupGraph = new ArrayList[m];

        for (int i = 0; i < n; i++) itemGraph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) groupGraph[i] = new ArrayList<>();

        int[] itemIn = new int[n];
        int[] groupIn = new int[m];

        for (int item = 0; item < n; item++) {
            for (int pre : beforeItems.get(item)) {
                itemGraph[pre].add(item);
                itemIn[item]++;

                if (group[pre] != group[item]) {
                    groupGraph[group[pre]].add(group[item]);
                    groupIn[group[item]]++;
                }
            }
        }

        List<Integer> itemOrder = topo(itemGraph, itemIn);
        List<Integer> groupOrder = topo(groupGraph, groupIn);

        if (itemOrder.size() != n || groupOrder.size() != m) {
            return new int[0];
        }

        Map<Integer, List<Integer>> groupToItems = new HashMap<>();

        for (int item : itemOrder) {
            groupToItems.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        int[] ans = new int[n];
        int idx = 0;

        for (int g : groupOrder) {
            for (int item : groupToItems.getOrDefault(g, new ArrayList<>())) {
                ans[idx++] = item;
            }
        }

        return ans;
    }

    private List<Integer> topo(List<Integer>[] graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);

            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        return order;
    }
}