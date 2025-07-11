import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class oni {

    static int N; // 정점
    static int M; // 간선
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();
            for(int i=0; i<N; i++) {
                if(graph[tmp][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}