package day6;

import java.util.*;

public class BFSGraph {
    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n - num nodes
     *  2. INTEGER m - num edges
     *  3. 2D_INTEGER_ARRAY edges [m][2]
     *  4. INTEGER s - starting node
     */
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
        List<Integer> distances = new ArrayList<>(n-1);
        for (int i = 0; i < n-1; i++) {
            distances.add(-1);
        }

        Map<Integer, List<Integer>> marked = new HashMap<>();
        marked.put(s, null);

        List<Integer> level = new ArrayList<>();
        level.add(s);
        int levelInt = 6;

        while (level.size() > 0) {
            List<Integer> nextLevel = new ArrayList<>();
            for (Integer v : level) {
                for (List<Integer> e : edges) {
                    if (e.contains(v)) {
                        Integer w = null;
                        if (e.get(0).equals(v)) {
                            w = e.get(1);
                        } else if (e.get(1).equals(v)) {
                            w = e.get(0);
                        }
                        if (!marked.containsKey(w)) {
                            marked.put(w, e);
                            nextLevel.add(w);
                            if (w<s) {
                                distances.set(w-1, levelInt);
                            } else {
                                distances.set(w-2, levelInt);
                            }
                        }
                    }
                }
            }
            level = nextLevel;
            levelInt += 6;
        }
        return distances;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> edge1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> edge2 = new ArrayList<>(Arrays.asList(1, 3));
        edges.add(edge1);
        edges.add(edge2);
        System.out.println(bfs(4, 2, edges, 1));
    }
}