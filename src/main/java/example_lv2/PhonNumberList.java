package example_lv2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhonNumberList {

    public boolean solution(String[] phone_book) {
        int length = phone_book.length;

        for(int i = 0; i< length; i++){
            String patternStr = phone_book[i];
            Pattern testPattern = Pattern.compile("^"+patternStr);

            for(int j = 0; j< length; j++){
                if(i != j){
                    String testNum = phone_book[j];
                    Matcher matcher = testPattern.matcher(testNum);
                    if(matcher.find()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean solution2(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }

}
