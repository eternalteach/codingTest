package example;

/**
 * @author : eternalteach
 * @since : 2020/07/06 10:45 오후
 * Description : 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a,b를 입력받아 2016년 a월b일이 무슨 요일인지 리턴하는
 * 함수를 완성하라. 일요일부터 토요일까지 각각 sun,mon,tue,wed,thu,fri,sat입니다.
 * [제한조건]
 * 1. 2016년은 윤년입니다.
 * 2. 2016년 a월 b일은 실제로 있는 날 입니다.
 */
public class T2016 {

    public static void main(String[] args) {
        T2016 t = new T2016();
        String answer = t.solution(1,1);
        System.out.println(answer);
    }

    private final String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
    private final int[] monthly = {31,29,31,30,31,30,31,31,30,31,30,31};
    public String solution(int a, int b) {
        String answer = "";
        int days = 0;
        for(int i = 0; i < a -1; i++){
            days += monthly[i];
        }
        days += b;
        answer = day[days%7];
        return answer;
    }
}
