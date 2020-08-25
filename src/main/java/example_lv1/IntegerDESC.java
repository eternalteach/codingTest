package example_lv1;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author : eternalteach
 * @since : 2020/08/24 8:04 오후
 * Description : 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를 들어 n이 118372면 873211을 리턴하면 됩니다.
 *
 * [제한 조건]
 * n은 1이상 8000000000 이하인 자연수입니다.
 */
public class IntegerDESC {
    public long solution(long n) {
            int answerLength = (int) Math.log10(n) +1;
            Integer[] nArray = new Integer[answerLength];
            int index = 0;
            while(n!=0){
                nArray[index]=(int) (n%10L);
                n /= 10;
                index ++;
            }
            Arrays.sort(nArray,  Collections.reverseOrder());
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i<nArray.length; i++){
                sb.append(nArray[i]);
            }
            long answer = Long.valueOf(sb.toString());
            return answer;
    }


    // 다른 솔루션
    String res = "";
    public int reverseInt(int n){
        res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
    }
}
