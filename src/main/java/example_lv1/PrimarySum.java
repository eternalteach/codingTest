package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/07/20 10:27 오후
 * Description :
 */
public class PrimarySum {
    public int solution(int n) {
        int answer = 0;

        int[] arr = new int[n+1];
        int i, j;
        for(i = 2; i<= n; i++){
            if(arr[i] == 0){
                answer += 1;
                for(j = i; j<= n; j += i){
                    arr[j] = 1;
                }
            }
        }

        return answer;
    }
}
