package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        boolean done = false;

        Scanner scanner = new Scanner(System.in);

        String pattern = "[1-9]{3}";

        while (!done) {
            done = gameStart(done, scanner, pattern);
        }

        System.out.println("완전한 종료");




    
        }//main
    
    
        private static boolean gameStart (boolean done, Scanner scanner, String pattern){
    
            boolean threeStrikes = false;
    
            String answer = "";
            for (int i = 0; i < 3; i++) {
                answer += (int) (Math.random() * (9 - 1 + 1)) + 1;
            }
    
            //temp-log
            System.out.println("(정답은 " + answer + " 입니다)");
    
            while (!threeStrikes) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = scanner.nextLine();
                verify(input, pattern);
    
                Map<Integer, String> ansMap = new HashMap<>();
    
                String[] inputArr = input.split("");
                String[] ansArr = answer.split("");
    
                for (int i = 0; i < 3; i++) {
                    ansMap.put(i, ansArr[i]);
                }
    
                System.out.println(ansMap);
    
                String resStr = resultStr(inputArr, ansMap);
                System.out.println(resStr);
    
                if (resStr.equals("3스트라이크")){
                    threeStrikes = true;
                    done = nextGame(done, scanner, pattern);
                }
    
    
            }
    
    
            return done;
        }
    
        private static boolean nextGame(boolean done, Scanner scanner, String pattern) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = scanner.nextLine();
            if (input.equals("1")){
               done = gameStart(done, scanner, pattern);
            }
        else{
            done = true;
        }
        return done;
    }

    private static String resultStr(String[] inputArr, Map<Integer, String> ansMap) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++){


            if (inputArr[i].equals(ansMap.get(i))){
                strike += 1;
            }
            else if (ansMap.containsValue(inputArr[i])){
                ball += 1;
            }
        }

        if (strike > 0 && ball > 0) {
            return String.format("%d볼 %d스트라이크", ball, strike);
        }
        if (strike > 0){
            return String.format("%d스트라이크", strike);
        }
        if (ball > 0){
            return String.format("%d볼", ball);
        }
        return "낫싱";

    }

    private static void verify (String input, String pattern){
        boolean matched = Pattern.matches(pattern, input);

        if (!matched) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 프로그램을 종료시킵니다");
        }


    }



}
