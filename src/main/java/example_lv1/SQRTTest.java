package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/08/24 11:09 오후
 * Description :
 */
public class SQRTTest {
    public long solution(long n) {

        long testNum = (long) Math.sqrt(n);
        if(testNum * testNum == n){
            return (testNum+1) *(testNum+1);
        }
        return -1L;
    }
}
