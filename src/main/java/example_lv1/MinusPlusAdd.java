package example_lv1;

public class MinusPlusAdd {
    public int solution(int[] absolutes, boolean[] signs) {

        int answer = 0;
        int arrayLength = absolutes.length;

        for(int index = 0; index < arrayLength; index++){
            answer += absolutes[index] * ((signs[index]) ? 1 : -1);
        }

        return answer;
    }
}
