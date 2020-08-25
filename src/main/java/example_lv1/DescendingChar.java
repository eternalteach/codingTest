package example_lv1;

import java.util.Arrays;

/**
 * @author : eternalteach
 * @since : 2020/07/23 7:56 오후
 * Description : 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 */
public class DescendingChar {

    public String solution(String s) {
        // 문자열 세팅
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        int arrayLength = charArray.length;
        char[] answerArray = new char[arrayLength];

        // 역순배열
        for(int index = 0; index < arrayLength; index++){
            answerArray[index]=charArray[arrayLength-index-1];
        }

        String answer = String.valueOf(answerArray);
        return answer;
    }

    public String solution2(String str){
        char[] sol = str.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }

}
