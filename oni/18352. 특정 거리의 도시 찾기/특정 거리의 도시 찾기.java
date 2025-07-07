import java.io.*;
import java.util.*;


public class Main {
    static final int UND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(null);
        for(int i=1; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }

        List<Integer> visited = new ArrayList<>(Collections.nCopies(N+1, UND));
        List<Integer> result = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        visited.set(X,0);
        for(int i=1; i<=N; i++) {
            Collections.sort(graph.get(i));
        }

        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next: graph.get(current)) {
                if(visited.get(next) == UND ) {
                    q.add(next);
                    visited.set(next, visited.get(current) + 1);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            if(visited.get(i) == K) {
                result.add(i);
            }
        }

        if(result.isEmpty()) {
            System.out.println(-1);
        } else {
            for(int a : result)  {
                System.out.println(a);
            }
        }

    }

}