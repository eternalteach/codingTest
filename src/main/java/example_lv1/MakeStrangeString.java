package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/08/06 6:45 오후
 * Description : 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 * [제한 사항]
 * 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
 * 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
 */
public class MakeStrangeString {

    public static void main(String[] args) {
        MakeStrangeString ms = new MakeStrangeString();
        System.out.println(ms.solution(" TRY "));
    }

    public String solution(String s) {
        StringBuffer sb = new StringBuffer();

        String[] strArray = s.split(" ",-1);
        for (String str : strArray) {
            if (!str.equals("")) {
                char[] tmpStrArray = str.toCharArray();
                int length = tmpStrArray.length;
                for (int i = 0; i < length; i++) {
                    int testChar = tmpStrArray[i];
                    if (i % 2 == 0 && testChar >= 'a' && testChar <= 'z') {
                        testChar -= 32;
                    } else if (i % 2 == 1 && testChar >= 'A' && testChar <= 'Z') {
                        testChar += 32;
                    }
                    sb.append((char) testChar);
                }
                sb.append(' ');
            }
        }
        int sbLength = sb.length();
        sb.deleteCharAt(sbLength - 1);
        return sb.toString();
    }
}
