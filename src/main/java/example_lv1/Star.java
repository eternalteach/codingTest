package example_lv1;

import java.util.Scanner;

/**
 * @author : eternalteach
 * @since : 2020/08/25 9:10 오후
 * Description :
 */
public class Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 0; i < b; i ++){
            for(int j = 0 ; j < a; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
