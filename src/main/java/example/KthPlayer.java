package example;

import java.util.Arrays;

/**
 * @author : eternalteach
 * @since : 2020/07/06 10:09 오후
 * Description : 배열 array의 i번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 한다.
 * 예를들어 array가 [1,5,2,6,3,7,4], i = 2, j = 5, k = 3이라면
 * 1. array의 2번째부터 5번째 까지 자르면 [5,2,6,3]입니다.
 * 2. 1에서 나온 배열을 정렬하면 [2,3,5,6]입니다.
 * 3. 2에서 나온 배열의 3번째 숫자는 5 입니다.
 * 배열 array, [i,j,k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온
 * 결과를 배열에 담아 return하도록 solution함수를 작성해 주세요.
 * [제한사항]
 * 1. array의 길이는 1 이상 100 이하입니다.
 * 2. array의 각 원소는 1 이상 100 이하입니다.
 * 3. commands 의 길이는 1 이상 50 이하입니다.
 * 4. commands의 각 원소의 길이가 3 입니다.
 */
// 20.07.06 해결 25분 23초 걸림
public class KthPlayer {

    public static void main(String[] args) {
        KthPlayer k  = new KthPlayer();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        k.solution(array,commands);
    }

    public int[] solution(int[] array, int[][] commands) {
        // 정답 길이
        int answerLength = commands.length;
        int[] answer = new int[answerLength];

        // 1. 배열 자르기
        for(int index = 0 ; index < answerLength; index ++){
            int startPoint = commands[index][0]-1;
            int endPoint = commands[index][1]-1;
            int[] conversionArray = new int[endPoint-startPoint+1];
            for(int i = 0; i <= endPoint-startPoint; i ++){
                conversionArray[i] = array[startPoint+i];
            }
           // 2. 배열 정렬하기
            Arrays.sort(conversionArray);
            // 3. 배열의 n번째 숫자 구하기
            answer[index] = conversionArray[commands[index][2]-1];
        }
        return answer;
    }

    class Solution {
        public int[] solution2(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i=0; i<commands.length; i++){
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }

            return answer;
        }
    }

}
