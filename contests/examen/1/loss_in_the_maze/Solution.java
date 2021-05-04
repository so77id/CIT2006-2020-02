import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'MazeEscape' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY maze
     *  2. INTEGER start_i
     *  3. INTEGER start_j
     *  4. INTEGER end_i
     *  5. INTEGER end_j
     */

    public static boolean MazeEscape(List<List<Integer>> maze, int start_i, int start_j, int end_i, int end_j) {
        boolean[][] visited = new boolean[maze.size()][maze.get(0).size()];
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue < int[] > queue = new LinkedList < > ();

        int[] start = {start_i, start_j};
        int[] end = {end_i, end_j};

        queue.add(start);

        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == end[0] && s[1] == end[1])
                return true;
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.size() && y < maze.get(0).size() && maze.get(x).get(y) == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int start_i = Integer.parseInt(bufferedReader.readLine().trim());

        int start_j = Integer.parseInt(bufferedReader.readLine().trim());

        int end_i = Integer.parseInt(bufferedReader.readLine().trim());

        int end_j = Integer.parseInt(bufferedReader.readLine().trim());

        int maze_size = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> maze = new ArrayList<>();

        IntStream.range(0, maze_size).forEach(i -> {
            try {
                maze.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        boolean result = Result.MazeEscape(maze, start_i, start_j, end_i, end_j);

        bufferedWriter.write(String.valueOf(result ? "True" : "False"));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
