package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/08/04 7:48 오후
 * Description : 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
 * [제한 조건]
 * s의 길이는 1 이상 5이하입니다.
 * s의 맨앞에는 부호(+, -)가 올 수 있습니다.
 * s는 부호와 숫자로만 이루어져있습니다.
 * s는 0으로 시작하지 않습니다.
 */
public class ChangeStringToInteger {
    public int solution(String s) {
        int answer = 0;
        int sLength = s.length();
        if(s.charAt(0) == '+'){
            s = s.substring(1, sLength);
            return Integer.parseInt(s);
        } else if (s.charAt(0) == '-'){
            s = s.substring(1, sLength);
            return Integer.parseInt(s)*(-1);
        } else {
            return Integer.parseInt(s);
        }
    }

    public int solution2(String s) {
        return Integer.parseInt(s);
    }
}
