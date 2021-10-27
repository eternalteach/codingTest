package example_lv2;

import java.util.ArrayList;

/**
 * @author eternalteach
 * @since 2021/10/27 9:24 오후
 */
public class TakeAGroupPhoto {
    public static void main(String[] args) {
        TakeAGroupPhoto a = new TakeAGroupPhoto();
        String[] data = {"N~F=0", "R~T>2"};
        a.solution(2, data);
    }

        public final static char[] MEMBERS = {'A','C','F','J','M','N','R','T'};

        public int solution(int n, String[] data) {
            ArrayList<String> takeAGroupPhotoCase = new ArrayList<>();
            makeAllCase(takeAGroupPhotoCase, 0, "");
            for (String condition : data) {
                char firstMember = condition.charAt(0);
                char secondMember = condition.charAt(2);
                char operator = condition.charAt(3);
                int value = condition.charAt(4) - 48;
                switch (operator) {
                    case '=':
                        takeAGroupPhotoCase.removeIf(memberIndex -> (Math.abs(memberIndex.indexOf(firstMember) - memberIndex.indexOf(secondMember)) - 1 != value));
                        break;
                    case '<':
                        takeAGroupPhotoCase.removeIf(memberIndex -> (Math.abs(memberIndex.indexOf(firstMember) - memberIndex.indexOf(secondMember)) - 1 >= value));
                        break;
                    case '>':
                        takeAGroupPhotoCase.removeIf(memberIndex -> (Math.abs(memberIndex.indexOf(firstMember) - memberIndex.indexOf(secondMember)) - 1 <= value));
                        break;
                }
            }
            return takeAGroupPhotoCase.size();
        }

        public ArrayList<String> makeAllCase(ArrayList<String> takeAGroupPhotoCase, int depth, String memberIndex) {
            if (depth == 8) {
                takeAGroupPhotoCase.add(memberIndex);
                return takeAGroupPhotoCase;
            }
            for(char member : MEMBERS){
                if(memberIndex.indexOf(member) < 0) makeAllCase(takeAGroupPhotoCase, depth + 1, memberIndex + member);
            }
            return takeAGroupPhotoCase;
        }
}
