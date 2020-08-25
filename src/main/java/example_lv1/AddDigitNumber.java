package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/08/24 7:34 오후
 * Description : 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 *
 *  [제한사항]
 * N의 범위 : 100,000,000 이하의 자연수
 */
public class AddDigitNumber {
    /* 전략 n을 한 자리수 씩 제거하여 더하기 or String으로 변형, 각 자리 수 더하기 */
    public int solution(int n) {
        int answer = 0;

        while(n!=0){
            answer += n%10;
            n /= 10;
        }

        return answer;
    }
}
