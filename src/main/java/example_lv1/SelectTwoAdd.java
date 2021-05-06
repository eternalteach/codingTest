package example_lv1;

import java.util.Set;
import java.util.TreeSet;

public class SelectTwoAdd {
    public int[] solution(int[] numbers) {
        Set<Integer> answerSet = new TreeSet<>();
        int numLength = numbers.length;
        for(int firstIndex = 0; firstIndex < numLength -1; firstIndex++){
            for(int secondIndex = firstIndex+1; secondIndex < numLength; secondIndex++){
                answerSet.add(numbers[firstIndex] + numbers[secondIndex]);
            }
        }
        int[] answer = answerSet.stream().mapToInt(x->x).toArray();
        return answer;
    }
}
