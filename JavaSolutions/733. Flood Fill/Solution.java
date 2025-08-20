class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];
        if (original != newColor) {
            dfs(image, sr, sc, original, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int original, int newColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length 
            || image[x][y] != original) return;

        image[x][y] = newColor;
        dfs(image, x+1, y, original, newColor);
        dfs(image, x-1, y, original, newColor);
        dfs(image, x, y+1, original, newColor);
        dfs(image, x, y-1, original, newColor);
    }
}
