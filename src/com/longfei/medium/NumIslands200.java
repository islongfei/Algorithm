package com.longfei.medium;

/**
 * 岛屿数量
 *
 * @author islongfei
 * @date 2020.09.20
 */
public class NumIslands200 {


    /**
     * s1. DFS 遍历每个节点，当为陆地节点时去递归，发现陆地则把陆地置为 0 直到找不到附近陆地退出
     */
    public int numIslands(char[][] grid) {
        int count = 0;

        if (grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

}
