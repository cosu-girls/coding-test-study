import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int N_len = n.length();
        int N = Integer.parseInt(n);

        int result = 0;

        for(int i=N-(N_len * 9); i<N; i++) {
            int number = i;
            int sum = 0;

            while(number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if(sum + i == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }

}