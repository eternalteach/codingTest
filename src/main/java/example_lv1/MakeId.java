package example_lv1;

public class MakeId {
    public String solution(String new_id) {
        // 1. 소문자로 치환
        String recommendedId = new_id.toLowerCase();

        // 2. 알파벳 소문자, 숫자, -_. 제외하고 모든문자 제거
        String match = "[^0-9a-z._-]";
        recommendedId = recommendedId.replaceAll(match,"");

        // 3. .. -> .
        recommendedId = recommendedId.replaceAll("\\.+",".");

        // 4. 첫 글자 . 제거
        recommendedId = recommendedId.replaceAll("^\\.","");

        // 5. 빈 문자열 -> a 대입
        if(recommendedId.equals("")){
            recommendedId = "a";
        }

        int idLength = recommendedId.length();
        // 6. 길이 16자 이상 -> 15자로 제한
        if(idLength >= 16){
            recommendedId = recommendedId.substring(0,15);
        }
        recommendedId = recommendedId.replaceAll("$\\.","");

        idLength = recommendedId.length();
        if(idLength <= 2){
            char lastChar = recommendedId.charAt(idLength - 1);
            for(int index = 0; index < 3 - idLength; index++){
                recommendedId = recommendedId + lastChar;
            }
        }

        return recommendedId;
    }
}
