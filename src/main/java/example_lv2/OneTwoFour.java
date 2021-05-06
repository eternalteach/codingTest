package example_lv2;


public class OneTwoFour {
    public String solution(int n) {
        String[] convert = {"1","2","4"};
        String answer = "";
        while(true){
            n -= 1;
            int remainNum = n % 3;
            answer = convert[remainNum] + answer;
            n/=3;
            if(n<=0){
                break;
            }
        }
        return answer;
    }

    /*  public String solution(int n) {
      String[] num = {"4","1","2"};
      String answer = "";

      while(n > 0){
          answer = num[n % 3] + answer;
          n = (n - 1) / 3;
      }
      return answer;
  }
  */
}
