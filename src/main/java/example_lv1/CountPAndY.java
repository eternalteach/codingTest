package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/07/23 7:42 오후
 * Description : 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 * 예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.
 * [제한사항]
 * 문자열 s의 길이 : 50 이하의 자연수
 * 문자열 s는 알파벳으로만 이루어져 있습니다.
 */
public class CountPAndY {

    boolean solution(String s) {
        s = s.toLowerCase();
        char[] sCharArray = s.toCharArray();
        int answer = 0;
        for(char ch : sCharArray){
            if(ch=='p'){
                answer++;
            } else if(ch=='y'){
                answer--;
            }
        }
        return answer == 0;
    }


    boolean solution2(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
}
