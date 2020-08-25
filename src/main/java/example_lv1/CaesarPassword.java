package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/08/04 8:01 오후
 * Description : 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 * [제한 조건]
 * 공백은 아무리 밀어도 공백입니다.
 * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
 * s의 길이는 8000이하입니다.
 * n은 1 이상, 25이하인 자연수입니다.
 */
public class CaesarPassword {
    public String solution(String s, int n) {
        int sLength = s.length();
        char[] charArray = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        for(int index = 0; index < sLength; index ++){
            char testChar = charArray[index];
            if('a'<=testChar && testChar <= 'z'){
                int charNum = ((testChar-'a'+n)%26)+'a';
                charArray[index] = (char)charNum;
            } else if ('A'<=testChar && testChar <= 'Z'){
                int charNum = ((testChar-'A'+n)%26)+'A';
                charArray[index] = (char)charNum;
            }
            sb.append(charArray[index]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //CaesarPassword cp = new CaesarPassword();
        //System.out.println(cp.solution("",1));
        System.out.println('a'+0);
        System.out.println('z'+0);
        System.out.println('A'+0);
        System.out.println('Z'+0);
    }
}
