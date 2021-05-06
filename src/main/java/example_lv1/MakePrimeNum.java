package example_lv1;

import java.util.HashMap;
import java.util.Map;

public class MakePrimeNum {

    public static void main(String[] args) {
        MakePrimeNum m = new MakePrimeNum();
        int[] nums = {1,2,3,4};
        System.out.println(m.solution(nums));
    }

    // 각 숫자마다 소수면 true, 합성수면 false
    public Map<Integer, Boolean> primeMap = new HashMap<>();

    public int solution(int[] nums) {
        int answer = 0;

        int numLength = nums.length;

        for(int firstSelect = 0; firstSelect < numLength - 2; firstSelect++){
            for(int secondSelect = firstSelect + 1; secondSelect < numLength - 1; secondSelect++){
                for(int thirdSelect = secondSelect + 1; thirdSelect < numLength; thirdSelect++){
                    if(isPrimeNum(nums[firstSelect] + nums[secondSelect] + nums[thirdSelect])){
                        answer++;
                    }
                }
            }

        }

        return answer;
    }

    public boolean isPrimeNum(int num){
        if(primeMap.containsKey(num)){
            return primeMap.get(num);
        }
        // 1 이상 중복되지 않은 3개의 자연수 합이므로 num >=6
        boolean result = true;
        // 2의배수 제거
        if(num % 2 == 0){
            primeMap.put(num,false);
            return false;
        }
        // 에라토스테네스 체로 테스트할 숫자 줄이기, 2의배수는 테스트할 필요 없다.
        int maxTestNum = (int)(Math.sqrt(num));

        for(int index = 2; index <= maxTestNum; index++){
            if(num % index == 0){
                primeMap.put(num,false);
                return false;
            }
        }
        primeMap.put(num,true);
        return result;
    }
}
