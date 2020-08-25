package example_lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : eternalteach
 * @since : 2020/08/25 7:28 오후
 * Description :
 */
public class TouchKeypad {
    public static void main(String[] args) {
        TouchKeypad t = new TouchKeypad();
        int[] test = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        String s = t.solution(test,hand);
        System.out.println(s);
    }
    // 키패드를 배열로 만들어서 진행
    // 왼손은 * 오른손은 #을 원점으로두자.
    //1. 1,4,7 은 왼손, 3,6,9는 오른손 클릭
    public String solution(int[] numbers, String hand) {
        StringBuffer sb = new StringBuffer();


        // 좌표평면 만들자, 기준점 왼쪽 아래
        List<Point> desmos = new ArrayList<>();
        // 0번 미리 추가하자.
        desmos.add(new Point(1,0));
        for (int y = 3; y >= 0; y--) {
            for (int x = 0; x <= 2; x++) {
                desmos.add(new Point(x, y));
            }
        }

        int lastLeftHand = 10;
        int lastRightHand = 12;

        int numbersLength = numbers.length;
        for (int index = 0; index < numbersLength; index++) {
            int testNum = numbers[index];
            if (testNum == 1 || testNum == 4 || testNum == 7) {
                sb.append("L");
                lastLeftHand = testNum;
            } else if (testNum == 3 || testNum == 6 || testNum == 9) {
                sb.append("R");
                lastRightHand = testNum;
            } else if (testNum == 2 || testNum == 5 || testNum == 8 || testNum == 0) {
                int leftHandLength = getLength(desmos.get(lastLeftHand),desmos.get(testNum));
                int rightHandLength = getLength(desmos.get(lastRightHand),desmos.get(testNum));
                if(leftHandLength < rightHandLength){
                    sb.append("L");
                    lastLeftHand = testNum;
                } else if ( leftHandLength == rightHandLength){
                    if(hand.equals("left")){
                        sb.append("L");
                        lastLeftHand = testNum;
                    } else {
                        sb.append("R");
                        lastRightHand = testNum;
                    }
                } else {
                    sb.append("R");
                    lastRightHand = testNum;
                }
            }
        }
        return sb.toString();
    }
    public int getLength(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public class Point {
        public int x;
        public int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
