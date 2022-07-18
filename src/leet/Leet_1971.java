package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Find if Path Exists in Graph
 */
public class Leet_1971 {

    int parent [];

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int i1 = edge[0];
            int i2 = edge[1];

            int a = find(i1);
            int b = find(i2);

            union(a,b);
        }

        return find(source) == find(destination);
    }

    int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    void union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[aRoot] = bRoot;
        } else {
            return;
        }
    }

    @Test
    void test() {
        assertEquals(validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2), true);
        assertEquals(validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5), false);
    }
}
