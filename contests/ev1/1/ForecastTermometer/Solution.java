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
     * Complete the 'ForecastTermometer' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY T as parameter.
     */

    public static List<Integer> ForecastTermometer(List<Integer> T) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack();

        for (int i = T.size() - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T.get(i) >= T.get(stack.peek())) stack.pop();
            ans.add(stack.isEmpty() ? 0 : stack.peek() - i);
            stack.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> T = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.ForecastTermometer(T);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
