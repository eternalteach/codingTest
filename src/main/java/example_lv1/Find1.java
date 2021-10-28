package example_lv1;

/**
 * @author eternalteach
 * @since 2021/10/28 10:40 오후
 */
public class Find1 {
    public int solution(int n) {
        int answer = n-1;
        for(int i = 2; i < n - 1; i++){
            if((n-1) % i == 0){
                int semiAnswer = (n-1) / i;
                answer = answer > semiAnswer ? semiAnswer : answer;
            }
        }
        return answer;
        // while문으로 처리해버려도 된다.
    }
}
