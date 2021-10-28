package example_lv1;

/**
 * @author eternalteach
 * @since 2021/10/28 10:25 오후
 */
public class CalculatingInsufficientMoney {
    public long solution(int price, int money, int count) {
        long totalPrice = (1 + count) * count / 2L * price;
        long changes = totalPrice - money;
        return changes > 0 ? changes : 0;
        //return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}
