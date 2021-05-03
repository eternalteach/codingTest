package example_lv1;

import java.util.Arrays;

public class innerProduct {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int arrayLength = a.length;
        for(int index = 0; index < arrayLength; index ++){
            answer += (a[index] * b[index]);
        }

        return answer;
    }
}
