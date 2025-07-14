import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int fake1 = 0, fake2 = 0;
        Arrays.sort(arr);

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) { // arr[i], arr[j]는 가짜 난쟁이
                    fake1 = arr[i];
                    fake2 = arr[j];
                    break;
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            if (arr[k] != fake1 && arr[k] != fake2) {     // fake1, fake2는 제외하고 출력
                System.out.println(arr[k]);
            }
        }
    }
}
