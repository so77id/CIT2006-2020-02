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
     * Complete the 'SortByFreq' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static class Pair<K, V> {
        private K first;
        private V second;;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K  first() {return this.first;}
        public V second() {return this.second;}
    }
    
    public static String SortByFreq(String s) {
        HashMap<Character,Integer> freq = new HashMap<Character,Integer>(); 
        for (char ch: s.toCharArray()){
            if(freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch)+1);
            } else {
                freq.put(ch, 1);               
            }
        }
        
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>(freq.size() > 0 ? freq.size():1, (a, b) -> {
            if(a.second() != b.second()) return b.second() - a.second();
            else return a.first() - b.first();
        }); 
        
        for(Map.Entry<Character,Integer> entry : freq.entrySet()) {
            pq.add(new Pair<Character,Integer>(entry.getKey(), entry.getValue()));
        }
        
        String S = "";
        while(pq.size() > 0){
            Pair<Character,Integer> p = pq.poll();
            for(int i=0;i<p.second();i++) S += p.first();
        }
        
        return S;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String res = Result.SortByFreq(s);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
