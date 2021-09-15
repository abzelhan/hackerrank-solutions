package leetcode.medium.graph;

public class ValidateBinaryTreeNodes {

    private boolean dfs(int from, int[][] adjacencyMatrix, int[] visited) {
        if (visited[from] == 1) {
            return true;
        }

        if (visited[from] == 2) {
            return false;
        }

        visited[from] = 1;

        for (int i = 0; i < adjacencyMatrix.length; i++) {

            if (adjacencyMatrix[from][i] == 1) {
                boolean hasCycle = dfs(i, adjacencyMatrix, visited);
                if (hasCycle) {
                    return true;
                }
            }
        }


        visited[from] = 2;
        return false;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[][] adjacencyMatrix = new int[n][n];
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                adjacencyMatrix[i][leftChild[i]] = 1;

                if (adjacencyMatrix[leftChild[i]][i] == 1) {
                    return false;
                }

            }
            if (rightChild[i] != -1) {
                adjacencyMatrix[i][rightChild[i]] = 1;

                if (adjacencyMatrix[rightChild[i]][i] == 1) {
                    return false;
                }
            }
        }

        int counter = 0;

        for (int i = 0; i < n; i++) {
            int parentCount = 0;
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[j][i] != 0) {
                    parentCount++;
                }
            }

            if (parentCount > 1) {
                return false;
            } else if (parentCount == 0) {
                boolean hasCycle = true;

                if (adjacencyMatrix.length > 1) {
                    for (int j = 0; j < adjacencyMatrix.length; j++) {
                        if (adjacencyMatrix[i][j] == 1) {
                            hasCycle = false;
                            break;
                        }
                    }

                    if (hasCycle) {
                        return false;
                    }
                }


                counter++;
                hasCycle = dfs(i, adjacencyMatrix, visited);

                if (hasCycle) {
                    return false;
                }

            }
        }

        return counter == 1;
    }


    public static void main(String[] args) {
        System.out.println(new ValidateBinaryTreeNodes()
                .validateBinaryTreeNodes(
                        1, new int[]{-1}, new int[]{-1}));
    }

}
