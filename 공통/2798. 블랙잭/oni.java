import java.io.*;
import java.util.StringTokenizer;


public class oni {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
        }

        int answer = search(N, M, arr);

        System.out.println(answer);

    }

    public static int search(int N, int M, int[] arr) {
        int temp;
        int sum = 0;
        for(int i=0; i<N-2; i++) {
            if(arr[i] > M) continue;
            for(int j=i+1; j<N-1; j++) {
                if(arr[i] + arr[j] > M) continue;
                for(int k=j+1; k<N; k++) {
                    if(arr[i] + arr[j] + arr[k] > M) continue;
                    temp = arr[i] + arr[j] + arr[k];
                    if(sum < temp) sum = temp;
                }
            }
        }
        return sum;
    }
}