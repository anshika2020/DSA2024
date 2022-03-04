package matrix;

public class ObstacleMatrix {
/*
63. Unique Paths II ::: NOT WORKING COORRECTLY
  obstacleGrid = [
    [0, 0, 0],
    [0, 1, 0],
    [0, 0, 0]
  ] => true


    obstacleGrid2 = [
      [0, 0, 1],
      [1, 1, 0],
      [0, 0, 0]
    ] => false

    def traverse_grid(grid): boolean

    m x n
    [
      [0, 0],
      [0, 0]
    ]
 */

        public static boolean checkObastackes(int [][] arr){
            boolean visited[][] = new boolean[arr.length][arr.length];

            // check the base condition
            if(arr.length==0) return false;
//     check current element
//     is current element traversable, true or false
//     move right or move down
            for(int i=0; i<arr.length;i++){// row
                for(int j=0; j<arr[i].length;j++){ // col
                    if(arr[i][j]==0){
                        dfs(arr, i, j, visited,0);
                        return true;
                    }
                }
            }

            return false;
        }

        private static void dfs(int[][] arr, int i, int j, boolean visited[][], int count){
            // base case
            if(i<0||i>arr.length-1||j<0||j>arr[i].length-1||arr[i][j]!=0){
                return;
            }
            if(arr[i][j]==0){
                return;
            }
            visited[i][j] = true;
            dfs(arr, i+1, j, visited, count+1);
            dfs(arr, i, j+1, visited, count+1);
            visited[i][j] = false;

        }

        public static void main(String[] args) {
            int num[][] = {{0, 1, 1},{1, 1, 1},{0, 0, 0}};

            System.out.println(checkObastackes(num));

        }
}
