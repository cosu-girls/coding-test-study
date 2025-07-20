import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static class Vertex implements Comparable<Vertex> {
        int v;
        int w;

        public Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Vertex other) {
            return other.v - this.v;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }
    }


    static List<List<Vertex>> graph;
    static List<Integer> visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점


        // 인접리스트 생성
        graph = new ArrayList<>();
        graph.add(null);
        for(int i=1; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        // 인접리스트 삽입
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(new Vertex(a,1));
            graph.get(a).add(new Vertex(b, 1));
        }

        // 내림차순 정렬
        for(int i=1; i<=N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new ArrayList<>(Collections.nCopies(N+1, 0));
        // 순회
        dfs(R);

        // 출력
        for(int i=1; i<=N; i++) {
            System.out.println(visited.get(i));
        }

    }

    static void dfs(int start) {
        count++;
        visited.set(start,count);
        for(Vertex Next : graph.get(start)) {
            if(visited.get(Next.v) == 0 ) {
                dfs(Next.v);
            }
        }
    }

}