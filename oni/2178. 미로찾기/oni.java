import java.io.*;
import java.util.*;

public class oni {

    static final int UND = -1;
    static final int WALL = 0;
    static final int ROAD = 1;
    static final int _n = 0;
    static final int _m = 1;

    static final List<List<Integer>> dirs = Arrays.asList(
            Arrays.asList(-1,0),
            Arrays.asList(0,1),
            Arrays.asList(1,0),
            Arrays.asList(0,-1)
    );
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        List<List<Integer>> graph = new ArrayList<>(Collections.nCopies(N+1, null));
        List<List<Integer>> visited = new ArrayList<>(Collections.nCopies(N+1, null));

        for(int i=0 ; i<N+1; i++) {
            graph.set(i,new ArrayList<>(Collections.nCopies(M+1, UND)));
            visited.set(i,new ArrayList<>(Collections.nCopies(M+1, UND)));
        }

        for(int i=1; i<=N; i++) {
            String a = br.readLine();
            for(int j=1; j<=M; j++) {
                graph.get(i).set(j, a.charAt(j-1) - '0');
            }
        }

        // 순회
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(1,1));
        visited.get(1).set(1,1);

        while(!q.isEmpty()) {
            List<Integer> a = q.poll();
            for(List<Integer> dir : dirs) {
                int nextN = a.get(_n) + dir.get(_n);
                int nextM = a.get(_m) + dir.get(_m);

                if(1 <= nextN && nextN <= N && 1 <= nextM && nextM <= M
                        && visited.get(nextN).get(nextM) == UND
                        && graph.get(nextN).get(nextM) == ROAD) {
                    q.add(Arrays.asList(nextN,nextM));
                    visited.get(nextN).set(nextM, visited.get(a.get(_n)).get(a.get(_m)) + 1);
                }
            }

        }

        System.out.println(visited.get(N).get(M));






    }

}