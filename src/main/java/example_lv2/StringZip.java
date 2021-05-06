package example_lv2;

import java.util.TreeSet;

public class StringZip {

    public int solution(String s) {
        int strLength = s.length();
        TreeSet<Integer> answerSet = new TreeSet<>();

        if(strLength == 1){
            return 1;
        }

        for(int index = 1; index <= strLength/2; index++){
            answerSet.add(splitStr(s,index).length());
        }

        return answerSet.first();
    }

    public String splitStr(String str, int splitNum) {
        boolean preDuplicate = false;
        int duplicateCnt = 1;
        String resultStr = "";

        while(true){
            int strLength = str.length();
            if(strLength >= splitNum){
                String tempStr = str.substring(0, splitNum);
                str = str.substring(splitNum);
                if(str.indexOf(tempStr) == 0){
                    preDuplicate = true;
                    duplicateCnt++;
                } else {
                    resultStr = (preDuplicate) ?resultStr + duplicateCnt + tempStr : resultStr +  tempStr;
                    preDuplicate = false;
                    duplicateCnt = 1;
                }
            } else {
                resultStr += str;
                break;
            }
        }
        return resultStr;
    }
}
