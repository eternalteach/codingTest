package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/07/23 8:10 오후
 * Description :문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
 */
public class ControlBasicCharactor {

    public boolean solution(String s) {
        boolean answer = true;
        char[] charArray = s.toCharArray();
        int charArrayLength = charArray.length;

        if(!(charArrayLength==4||charArrayLength==6)){
            return false;
        }

        for(int index = 0; index <charArrayLength; index++){
            if(!(charArray[index]>='0'&& charArray[index]<='9')){
                return false;
            }
        }
        return answer;
    }

    public boolean solution2(String s) {
        if(s.length() == 4 || s.length() == 6){
            try{
                int x = Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        else return false;
    }
// 정규식으로 풀어보기
}
