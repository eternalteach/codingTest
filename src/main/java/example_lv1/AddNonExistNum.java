package example_lv1;

/**
 * @author eternalteach
 * @since 2021/10/28 10:17 오후
 */
public class AddNonExistNum {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int num : numbers){
            answer -= num;
        }
        return answer;
    }
}
// 45-Arrays.stream(numbers).sum();