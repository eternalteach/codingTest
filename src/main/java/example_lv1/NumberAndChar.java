package example_lv1;

/**
 * @author eternalteach
 * @since 2021/10/28 9:59 오후
 */
public class NumberAndChar {
    public int solution(String s) {
        s = s.replaceAll("one","1")
            .replaceAll("two","2")
            .replaceAll("three","3")
            .replaceAll("four","4")
            .replaceAll("five","5")
            .replaceAll("six","6")
            .replaceAll("seven","7")
            .replaceAll("eight","8")
            .replaceAll("nine","9")
            .replaceAll("zero","0");

        return Integer.parseInt(s);
    }
}
