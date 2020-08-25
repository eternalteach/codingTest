package example_lv1;

import java.util.*;

/**
 * @author : eternalteach
 * @since : 2020/07/03 9:34 오후
 * Description : 수포자 삼인방은 1번 문제부터 마지막 문제까지 다음과 같이 찍는다
 * 1번 : 1,2,3,4,5,1,2,3,4,5,1,2,3,4,5
 * 2번 : 2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5
 * 3번 : 3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 정답배열이 주어졌을 때, 가장 많은 문제를 맞히 사람이 누구인지 배열에 담아 반환하도록 작성하라
 * [제한조건]
 * 1. 시험은 최대 10000문제
 * 2. 정답은 1,2,3,4,5 중 하나
 * 3. 가장 높은 사람이 여럿일 경우 반환값을 오름차순으로 정렬
 *
 */
// 20.07.03 해결 36분 2초 걸림
public class MockExam {
    public static void main(String[] args) {

    }

    private final int[] FIRST_CANDIDATE = {1,2,3,4,5};
    private final int[] SECOND_CANDIDATE = {2,1,2,3,2,4,2,5};
    private final int[] THIRD_CANDIDATE = {3,3,1,1,2,2,4,4,5,5};

    public int[] solution(int[] answers) {
        int[] answer = {};

        // 채점
        int firstCandidateScore = scoring(FIRST_CANDIDATE, answers);
        int secondCandidateScore = scoring(SECOND_CANDIDATE, answers);
        int thirdCandidateScore = scoring(THIRD_CANDIDATE, answers);

        int maxScore = Math.max(firstCandidateScore, Math.max(secondCandidateScore, thirdCandidateScore));


        // 순위 매기기
        if(firstCandidateScore > secondCandidateScore){
            //1 > 2,3
            if(firstCandidateScore > thirdCandidateScore){
                return new int[] {1};
            // 1 == 3 > 2
            } else if(firstCandidateScore == thirdCandidateScore){
                return new int[] {1, 3};

            // 3 > 1 > 2
            } else{
                return new int[] {3};
            }
        } else if(firstCandidateScore == secondCandidateScore){
            // 1==2
            if(thirdCandidateScore>firstCandidateScore){
                return new int[] {3};
            } else if(thirdCandidateScore == firstCandidateScore){
            // 1 == 2 == 3
                return new int[] {1,2,3};
            } else {
            // 1 == 2 > 3
                return new int[] {1,2};
            }
        } else {
            // 2 > 1,3
            if(secondCandidateScore > thirdCandidateScore){
                return new int[] {2};
            } else if(secondCandidateScore == thirdCandidateScore){
            // 2==3 > 1
                return new int[] {2,3};
            } else {
            // 3 > 2 > 1
                return new int[] {3};
            }
        }
    }

    // 채점하여 점수 반환
    private int scoring(int[] candidateAnswer, int[] answers){
        int score = 0;
        int questionsCnt = answers.length;
        int candidateLoopLength = candidateAnswer.length;

        for(int questionNum = 0; questionNum < questionsCnt; questionNum++){
            if(answers[questionNum] == candidateAnswer[questionNum % candidateLoopLength]){
                score++;
            }
        }
        return score;
    }


    public int[] solution2(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];

        // 채점
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        // 결과 정렬
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        int answerLength = list.size();

        // 리스트를 int[]로 변경
        int[] answers = new int[answerLength];
        for(int index = 0; index<answerLength; answerLength++){
            answers[index]=list.get(index);
        }
        return answers;
    }

}
