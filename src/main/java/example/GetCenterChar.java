package example;

/**
 * @author : eternalteach
 * @since : 2020/07/09 9:10 오후
 * Description : 가운데 글자 가져오기
 * 단어의 길이가 짝수라면 가운데 두 글자, 홀수면 가운데 글자 가져오기
 */
// 20.07.09 해결
public class GetCenterChar {

    public String solution(String s) {
        String answer = "";
        char[] sArray = s.toCharArray();
        int sLength = sArray.length;
        if(sLength%2==0 && sLength > 0){
            answer += sArray[sLength/2-1];
            answer += sArray[sLength/2];
        } else {
            answer += sArray[sLength/2];
        }
        return answer;
    }

    String solution2(String word){
        return word.length()%2==0 ? word.substring(word.length()/2-1, word.length()/2+1) : word.substring(word.length()/2, word.length()/2+1);
    }
}
