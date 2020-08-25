package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/08/25 9:20 오후
 * Description : 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
 * 전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 * s는 길이 4 이상, 20이하인 문자열입니다.
 */
public class HidePhoneNumber {
    public String solution(String phone_number) {
        int numLength = phone_number.length();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < numLength-4; i++){
            sb.append('*');
        }
        char[] charArray = phone_number.toCharArray();
        for(int i = numLength-4; i < numLength; i++){
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
}
