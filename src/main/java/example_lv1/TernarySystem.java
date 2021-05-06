package example_lv1;

import java.util.ArrayList;
import java.util.List;

public class TernarySystem {
    public int solution(int n) {
        int answer = 0;
        List<Integer> convert = new ArrayList<>();

        // 배열에 3진법 역순 등록
        while(n != 0){
            if(n >= 3){
                int remainder = n % 3;
                convert.add(remainder);
                n = (n /3);
            } else {
                convert.add(n);
                n = 0;
            }
        }
        int cnt = convert.size() - 1;
        for(int num : convert){
            answer += ((int)Math.pow(3, cnt)) * num;
            cnt--;
        }

        return answer;
    }
}
