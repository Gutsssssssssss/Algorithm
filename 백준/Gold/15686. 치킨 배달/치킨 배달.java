import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m, result = 98765432;
    static int[][] a = new int[51][51];
    static ArrayList<Pair> home = new ArrayList<>();
    static ArrayList<Pair> chicken = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> chickenList = new ArrayList<>();

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void combi(int start, ArrayList<Integer> b) {
        if (b.size() == m) {
            chickenList.add(new ArrayList<>(b));
            return;
        }
        for (int i = start + 1; i < chicken.size(); i++) {
            b.add(i);
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 1) home.add(new Pair(i, j));
                if (a[i][j] == 2) chicken.add(new Pair(i, j));
            }
        }

        ArrayList<Integer> b = new ArrayList<>();
        combi(-1, b);

        for (ArrayList<Integer> cList : chickenList) {
            int ret = 0;
            for (Pair h : home) {
                int minDist = 98765432;
                for (int c : cList) {
                    int dist = Math.abs(h.first - chicken.get(c).first) + Math.abs(h.second - chicken.get(c).second);
                    minDist = Math.min(minDist, dist);
                }
                ret += minDist;
            }
            result = Math.min(ret, result);
        }

        System.out.println(result);
    }
}