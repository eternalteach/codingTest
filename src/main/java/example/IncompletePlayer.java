package example;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : eternalteach
 * @since : 2020/07/02 10:30 오후
 * Description : 완주하지 못한 선수
 * 수많은 마라톤 선수들이 마라톤에 참여하였다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return하도록 작성하라.
 * <p>
 * [제한사항]
 * 1. 마라톤 경기에 참여한 선수의 수는 1명이상 100000명 이하
 * 2. completion의 길이는 participant의 길이보다 1 작습니다.
 * 3. 참가자의 이름은 1개 이상 20개 이하 알파벳 소문자로 이루어져 있다.
 * 4. 참가자 중에는 동명이인이 있을 수 있습니다.
 */
// 20.07.02 해결 16분 21초 걸림
public class IncompletePlayer {

    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"mislav", "stanko", "mislav"};

        IncompletePlayer ip = new IncompletePlayer();
        long start;
        long end;
        start = System.nanoTime();
        System.out.println(ip.solution2(participant, completion));
        end = System.nanoTime();
        System.out.println((end - start)/1000+"ms");

        start = System.nanoTime();
        System.out.println(ip.solution(participant, completion));
        end = System.nanoTime();
        System.out.println((end - start)/1000+"ms");

    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //참가자, 완주자 순서대로 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        int completionLength = completion.length;
        for (int index = 0; index < completionLength; index++) {
            if (!participant[index].equals(completion[index])) {
                answer = participant[index];
                break;
            }
        }
        if (answer.equals("")) {
            answer = participant[participant.length - 1];
        }

        return answer;
    }

    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
