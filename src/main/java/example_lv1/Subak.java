package example_lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : eternalteach
 * @since : 2020/08/03 8:18 오후
 * Description : 길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.
 */
public class Subak {

    public static void main(String[] args) {
        Subak subak = new Subak();
        System.out.println(subak.solution(1));
    }

    // 유클리드 호제법으로 풀어보
    public String solution(int n) {
        if(n==1){
            return "수";
        }

        String answer = "";
        List<String> subak = new ArrayList<>();
        List<Integer> quotientList = new ArrayList<>();
        List<Integer> remainder = new ArrayList<>();

        subak.add("수");
        subak.add("수박");



        // 몫 과 나머지 구하기
        while(n!=1){
            int r = n%2;
            n /= 2;
            quotientList.add(n);
            remainder.add(r);
        }

        // 합칠 글자 만들기
        int remainderSize = remainder.size();
        StringBuffer sb = new StringBuffer();
        sb.append("수박");
        for(int index = 0; index <= remainderSize-2; index++){
            sb.append(subak.get(index+1));
            subak.add(sb.toString());
        }

        for(int index=remainderSize-1; index >= 0; index--){
            if(remainder.get(index)!=0){
                sb.append(subak.get(index));
            }
        }

        return sb.toString();
    }

    public String solution2(int n) {

        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n); }
}
