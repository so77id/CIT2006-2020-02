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
     * Complete the 'NextGreaterInCicle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY n as parameter.
     */

    public static List<Integer> NextGreaterInCicle(List<Integer> n) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<n.size();i++) ans.add(0);

        Stack<Integer> stack = new Stack<Integer>();
        for(int i= 2 * n.size()-1; i >= 0; i--) {
            while(!stack.empty() && n.get(stack.peek()) <= n.get(i%n.size())) {
                stack.pop();
            }
            ans.set(i % n.size(), stack.empty() ? -1 : n.get(stack.peek()));
            stack.push(i%n.size());
        }

        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.NextGreaterInCicle(arr);

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
