package example_lv1;

/**
 * @author : eternalteach
 * @since : 2020/07/04 10:59 오전
 * Description : 점심시간에 일부 학생 체육복 도난당했다.
 * 체육복을 빌려줄 건데, 학생들의 번호는 체격순으로 매겨져 있다.
 * 바로 앞번호의 학생이나 뒷 번호의 학생에게만 체육복을 빌려줄 수 있다.
 * 체육복을 최대한 많은 학생이 입고 수업을 들어야 한다.
 * 전체 학생 n명, 체육복 도난당한 학생들의 번호가 담긴 배열 lost
 * 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 주어진다.
 * [제한사항]
 * 1. 전체 학생수는 2명 이상 30명 이하
 * 2. 체육복을 도난당한 학생의 수는 1명 이상 n 명 이하, 중복되는 번호 없다
 * 3. 여벌의 체육복을 가져온 학생의 수는 1명 이상n명 이하
 * 4. 여벌의 체육복을 가져온 학생만 체육복 빌려줄 수 있다.
 * 5. 여벌의 체육복을 가져온 학생이 체육복을 도난당했을 수 있다. 도난당했을 경우 남은 체육복 하나이면 다른 학생에게 체육복 빌려줄 수 없다.
 */
// 20.07.04 해결 41분 42초 걸림
public class GymSuit {

    public static void main(String[] args) {
        int[] lost = {2,4};
        int[] reserve = {3};
        GymSuit g = new GymSuit();
        int answer = g.solution(5,lost, reserve);
        System.out.println(answer);
    }

    // 학생수 n명, 체육복 도난당한 사람 배열 lost, 여벌의 체육복 가져온 학생 배열 reserve 최대 몇 명 학생 입을 수 있나?
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 1. 잔여 체육복 소유현황 파악
        // 1.1 기본적으로 모든 학생이 1벌 가지고 있다고 생각하자. 그 뒤 잃어버린사람 -1, 여벌있는사람 +1 처리하자.
        int[] studentSuitCnt = new int[n];

        // 기본적으로 한벌 지급
        for(int studentNum =0 ; studentNum < n; studentNum++){
            studentSuitCnt[studentNum]++;
        }

        // 잃어버린사람 한벌 제거
        for(int studentNum : lost){
            studentSuitCnt[studentNum-1]--;
        }

        // 여벌 가져온 사람 한벌 추가
        for(int studentNum : reserve){
            studentSuitCnt[studentNum-1]++;
        }
        // 2. 체육복 2벌인 사람은 자기 앞 사람부터 체육복 유무 확인해 빌려 주도록 작성
        // 맨 처음 번호가 체육복 없을 경우
        if(studentSuitCnt[0] == 0 && studentSuitCnt[1]==2){
            studentSuitCnt[0]=1;
            studentSuitCnt[0+1]=1;
        }
        // 중간이에 있는 사람이 체육복 없을 경우
        for(int studentNum = 1; studentNum < n - 1; studentNum ++){
            if(studentSuitCnt[studentNum] == 0){
                if(studentSuitCnt[studentNum-1]==2){
                    studentSuitCnt[studentNum]=1;
                    studentSuitCnt[studentNum-1]=1;
                } else if (studentSuitCnt[studentNum+1]==2){
                    studentSuitCnt[studentNum]=1;
                    studentSuitCnt[studentNum+1]=1;
                }
            }
        }
        // 마지막에 있는 사람 체육복 없을 경우
        if(n>=2 && studentSuitCnt[n-1] == 0 && studentSuitCnt[n-2]==2){
            studentSuitCnt[n-1]=1;
            studentSuitCnt[n-2]=1;
        }


        for(int studentNum =0 ; studentNum < n; studentNum++){
            if(studentSuitCnt[studentNum]>=1){
                answer ++;
            }
        }
        return answer;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }
}
