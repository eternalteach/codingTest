package example_lv1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : eternalteach
 * @since : 2020/07/10 8:35 오후
 * Description : 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.
 * <p>
 * [제한 조건]
 * strings는 길이 1 이상, 50이하인 배열입니다.
 * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
 * strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
 * 모든 strings의 원소의 길이는 n보다 큽니다.
 * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
 */
// 20.07.10 해결
public class CharactorSort {
    public String[] solution(String[] strings, int n) {

        int strLength = strings.length;
        for (int index = 0; index < strLength; index++) {
            strings[index] = strings[index].charAt(n) + strings[index];
        }
        Arrays.sort(strings);
        for (int index = 0; index < strLength; index++) {
            strings[index] = strings[index].substring(1, strings[index].length());
        }

        return strings;
    }

    public String[] solution2(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                } else {
                    return (s1.charAt(n) > s2.charAt(n)) ? 1 : -1;
                }
            }
        });
        return strings;
    }
}
