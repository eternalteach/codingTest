package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/08/24 7:41 오후
 * Description : 문제 설명
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 *
 *  [제한 조건]
 * n은 10,000,000,000이하인 자연수입니다.
 */
public class ReverseNumber {

    public static void main(String[] args) {
        ReverseNumber rv = new ReverseNumber();
        rv.solution(10000000000L);
    }

    public int[] solution(long n) {
        int answerLength = (int) Math.log10(n) +1;
        int[] answer = new int[answerLength];
        int index = 0;
        while(n!=0){
            answer[index]=(int) (n%10L);
            n /= 10;
            index ++;
        }

        return answer;
    }

}
