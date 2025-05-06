package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an image represented by an m x n grid of integers image, where
 * image[i][j] represents the pixel value of the image. You are also given three
 * integers sr, sc, and color. Your task is to perform a flood fill on the image
 * starting from the pixel image[sr][sc].
 * 
 * To perform a flood fill:
 * 
 * Begin with the starting pixel and change its color to color.
 * Perform the same process for each pixel that is directly adjacent (pixels
 * that share a side with the original pixel, either horizontally or vertically)
 * and shares the same color as the starting pixel.
 * Keep repeating this process by checking neighboring pixels of the updated
 * pixels and modifying their color if it matches the original color of the
 * starting pixel.
 * The process stops when there are no more adjacent pixels of the original
 * color to update.
 * Return the modified image after performing the flood fill.
 * Example 1:
 * 
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * 
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 */

class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogColor = image[sr][sc];
        if (ogColor == color) {
            return image;
        }
        Queue<Pair> q = new LinkedList<>();
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        q.add(new Pair(sr, sc));
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair p = q.remove();
                for (int[] d : dirs) { // check in 4 directions
                    int x = p.a + d[0];
                    int y = p.b + d[1];
                    if (x > -1 && y > -1 && x < image.length && y < image[0].length && image[x][y] == ogColor) {
                        image[x][y] = color;
                        q.add(new Pair(x, y));
                    }
                }
            }
        }
        return image;
    }
}