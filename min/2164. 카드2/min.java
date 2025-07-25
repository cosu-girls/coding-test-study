import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int card = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= card; i++) {
            que.add(i);
        }
        while (que.size() > 1) {
            que.remove();
            que.add(que.remove());
        }
        System.out.print(que.peek());
    }
}