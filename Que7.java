import java.util.*;

// TSP Using Genetic
public class Que7 {
    static int[][] distMat = {
            { Integer.MAX_VALUE, 7, 3, 12, 8 },
            { 3, Integer.MAX_VALUE, 6, 14, 9 },
            { 5, 8, Integer.MAX_VALUE, 6, 18 },
            { 9, 3, 5, Integer.MAX_VALUE, 11 },
            { 18, 14, 9, 8, Integer.MAX_VALUE }
    };

    static Random rand = new Random();

    public static int calFitness(int[] path) {
        int fitness = 0;
        for (int i = 0; i < path.length - 1; i++) {
            fitness += distMat[path[i]][path[i + 1]];
        }

        fitness += distMat[path[path.length - 1]][path[0]];
        return fitness;
    }

    public static int[] mutate(int[] p) {
        int n = p.length;
        int ind1 = rand.nextInt(n);
        int ind2 = rand.nextInt(n);

        while (ind1 == ind2) {
            ind2 = rand.nextInt(n);
        }

        int temp = p[ind1];
        p[ind1] = p[ind2];
        p[ind2] = temp;

        return p;
    }

    public static int[] crossover(int p1[], int p2[]) {
        int n = p1.length;
        int[] child = new int[n];
        boolean[] visited = new boolean[n];

        int start = rand.nextInt(n);
        int end = rand.nextInt(n);

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        for (int i = start; i <= end; i++) {
            child[i] = p1[i];
            visited[p1[i]] = true;
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[p2[i]]) {
                while (child[k] != 0) {
                    k++;
                }
                child[k] = p2[i];
                visited[p2[i]] = true;
            }
        }
        return child;
    }

    public static int[] solve(int pop, int gen) {
        int[][] p = new int[pop][distMat.length];

        for (int i = 0; i < pop; i++) {
            p[i] = rand.ints(0, distMat.length).distinct().limit(distMat.length).toArray();
        }

        for (int i = 0; i < gen; i++) {
            Arrays.sort(p, Comparator.comparingInt(Que7::calFitness));
            for (int j = pop / 2; j < pop; j++) {
                p[j] = mutate(crossover(p[j % (pop / 2)], p[(j + 1) % (pop / 2)]));
            }
        }

        return p[0];
    }

    public static void main(String[] args) {
        int[] res = solve(10, 100);
        System.out.println("Min cost: " + calFitness(res));
        System.out.println("Path: ");
        for (int i : res) {
            System.out.print(i + " -> ");
        }
        System.out.println(res[0]);
    }
}