import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < num; i++) {
            String str = String.valueOf(i);

            int sum = i;
            for (int j = 0; j < str.length(); j++) {
                sum += str.charAt(j) - '0';    // '2' - '0' = 50 - 48 = 2
            }
            if (sum == num) {
                result = i;
                break;
            }
        }
        System.out.print(result);
    }
}