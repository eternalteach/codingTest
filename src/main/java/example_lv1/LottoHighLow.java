package example_lv1;

import java.util.Arrays;

public class LottoHighLow {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        int collectCnt = 0;

        for(int num : lottos){
            if(num == 0){
                zeroCnt += 1;
            }
            if(Arrays.stream(win_nums).anyMatch(win -> win == num)){
                collectCnt += 1;
            }
        }
        int high = collectCnt + zeroCnt;
        int low = collectCnt;

        return new int[]{rank(high), rank(low)};
    }

    public int rank (int collectCnt){
        if(collectCnt >= 2){
            return 6 - collectCnt + 1;
        } else {
            return 6;
        }
    }
}
