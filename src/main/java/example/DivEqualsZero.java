package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : eternalteach
 * @since : 2020/07/09 10:21 오후
 * Description :array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 *
 * 제한사항
 * arr은 자연수를 담은 배열입니다.
 * 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
 * divisor는 자연수입니다.
 * array는 길이 1 이상인 배열입니다.
 */
public class DivEqualsZero {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answerList = new ArrayList<>();
        for(int num : arr){
            if(num%divisor==0){
                answerList.add(num);
            }
        }

        int answerListLength = answerList.size();
        int[] answer = new int[answerListLength];
        if(!answerList.isEmpty()){
            for(int index = 0; index < answerListLength; index ++){
                answer[index] = answerList.get(index);
            }
        } else{
            answer = new int[] {-1};
        }
        Arrays.sort(answer);
        return answer;
    }

    public int[] solution2(int[] array, int divisor) {
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }
}
