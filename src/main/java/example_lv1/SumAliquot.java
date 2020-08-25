package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/08/04 8:22 오후
 * Description : 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
 * [제한 사항]
 * n은 0 이상 3000이하인 정수입니다.
 */
public class SumAliquot {
    public int solution(int n) {
        if(n==0){return 0;}
        if(n==1){return 1;}
        int answer = 1+n;
        int r = n/2;
        for(int i = 2; i <= r; i++){
            if(n%i==0){
                answer+=i;
            }
        }
        return answer;
    }
}
