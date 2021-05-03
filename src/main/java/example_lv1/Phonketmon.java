package example_lv1;

import java.util.HashSet;
import java.util.Set;

public class Phonketmon {
    public int solution(int[] nums) {
        int canSelect = nums.length / 2;

        Set<Integer> kindSet = new HashSet<>();
        for(int kindNum : nums){
            kindSet.add(kindNum);
        }

        int kindCnt = kindSet.size();

        return (canSelect >= kindCnt) ? kindCnt: canSelect;
    }
}
