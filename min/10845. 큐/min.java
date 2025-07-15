import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    que.add(last);
                    break;

                case "pop":
                    sb.append(que.isEmpty() ? -1 : que.poll()).append("\n");
                    break;

                case "size":
                    sb.append(que.size()).append("\n");
                    break;

                case "empty":
                    sb.append(que.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    sb.append(que.isEmpty() ? -1 : que.peek()).append("\n");
                    break;

                case "back":
                    sb.append(que.isEmpty() ? -1 : last).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
