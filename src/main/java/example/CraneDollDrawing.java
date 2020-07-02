package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : eternalteach
 * @since : 2020/05/11 10:07 오후
 * Description : 게임개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 한다. 죠르디는 게임의 재미를 높이기 위해 화면 구성과
 * 규칙을 다음과 같이 게임 로직에 반영하려고 한다. 게임 화면은 1 x 1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인이 있고
 * 오른쪽에는 바구니가 있다. 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸이다. 모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며
 * 격자의 가장 아래 칸부터 차곡차곡 쌓여있다. 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있다.
 * 집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓인다. 만약 같은 모양의 인형 두 개가 바구니에 연속해서
 * 쌓이면 두 인형은 터뜨려지면서 바구니에서 사라진다. 크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우
 * 아무런 일도 일어나지 않는다. 또한 바구니는 모든 인형이 들어갈 수 있을 만큼 크다. 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해
 * 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때, 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return하도록 함수를 완성하라.
 * [제한사항]
 * 1. board배열은 2차원 배열로 크기는 5 x 5 이상 30 x 30 이하 이다.
 * 2. board의 각 칸에는 0 이상 100 이하인 정수가 담겨 있다.
 * (0은 빈칸을 나타낸다. 1~100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타낸다.
 * 3. moves 배열의 크기는 1 이상 1000 이하이다.
 * 4. moves 배열 각 원소들의 값은 1 이상이며 board배열의 가로 크기 이하인 자연수이다.
 */
// 20.07.02 해결 1시간 16분 46초 걸림
public class CraneDollDrawing {
    public static void main(String[] args) {
        int [] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int [][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        CraneDollDrawing sol = new CraneDollDrawing();
        long startTime = System.nanoTime();
        sol.solution(board, moves);
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000+"ms");

        startTime = System.nanoTime();
        sol.solution2(board, moves);
        endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000+"ms");
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int boardLength = board.length;

        // board List 구성
        List<Stack<Integer>> boardList = new ArrayList<Stack<Integer>>(boardLength);
        // 열단위
        for (int line = 0; line < boardLength; line++) {
            Stack<Integer> rowStack = new Stack<Integer>();
            for (int row = boardLength-1 ; row >= 0 ; row--) {
                int value = board[row][line];
                if(value != 0){
                    rowStack.push(value);
                }
            }
            boardList.add(rowStack);
        }

        Stack<Integer> basket = new Stack<Integer>();

        // moves작업 수행
        int movesLength = moves.length;
        for(int index = 0; index < movesLength; index++ ){
            if(!boardList.get(moves[index]-1).isEmpty()){
                Integer value = boardList.get(moves[index]-1).pop();
                if(!basket.isEmpty() && basket.peek() == value){
                    basket.pop();
                    answer+=2;
                } else {
                    basket.push(value);
                }
            }
        }
        return answer;
    }

    public int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
