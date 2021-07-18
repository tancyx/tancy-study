package com.tancy.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tancy
 * 2021/6/26 16:47
 * @description 分配饼干
 */
public class AssignCookies {

    public static void main(String[] args) {
        int[] grid = {1, 3}, size = {1, 2, 4};
        System.out.println(assign(grid, size));
    }


    /**
     * 每个孩子都有一个满足度 grid，每个饼干都有一个大小 size，
     * 只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。
     * 求解最多可以获得满足的孩子数量。
     * @param grid
     * @param size
     * @return
     */
    private static int assign(int[] grid, int[] size) {
        Arrays.sort(grid);
        Arrays.sort(size);

        List<int[]> assign = new ArrayList<>();

        int gindex = 0, sindex = 0, count = 0;
        while (sindex < size.length && gindex < grid.length) {
            if (grid[gindex] <= size[sindex++]) {
                // 符合最低满足度
                assign.add(new int[]{gindex, sindex});
                System.out.println(gindex +":"+ sindex);
                count++;
                gindex++;
            }
        }
        return count;
    }

}
