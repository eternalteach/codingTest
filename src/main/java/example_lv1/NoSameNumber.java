package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/07/09 9:22 오후
 * Description : 배열 Arr가 주어진다. 배열의 각 원소는 숫자 0 부터 9까지로 이루어져 있다. 이 때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고
 * 전부 제거하려 한다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 한다. 예를들면
 * arr =[1,1,3,3,0,1,1]이면 [1,3,0,1]을 반환한다.
 * [제한사항]
 * 배열의 크기 1000000이하의 자연수
 * 배열원소의 크기 0보다 크고, 9보다 작거나 같은 정
 */
// 20.07.09 해결
public class NoSameNumber {

    public int[] solution(int []arr) {
        int arrSize = arr.length;
        int[] answerList = new int[arrSize];
        answerList[0] = arr[0];
        int answerListIndex = 1;

        for(int index = 1 ; index < arrSize; index ++){
            if(arr[index-1]!=arr[index]){
                answerList[answerListIndex]=arr[index];
                answerListIndex++;
            }
        }

        int[] answer = new int[answerListIndex];
        for(int index = 0; index < answerListIndex; index ++){
            answer[index] = answerList[index];
        }

        return answer;
    }

}
