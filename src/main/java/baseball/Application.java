package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        System.out.println("hello world");

        String answer = "";

        for (int i=0; i<3; i++){
            answer += (int) (Math.random() * (9 - 1 + 1)) + 1;
        }

        System.out.println(answer);

        Scanner scanner = new Scanner(System.in);

        String pattern = "[1-9]{3}";



//        boolean done = false;
//        while(!done){
//            String input = scanner.nextLine();
//            boolean matched = Pattern.matches(pattern, input);
//            if (matched){
//                //결과 체크 로직
//            }
//            else {
//                done = true;
//                throw new IllegalArgumentException("잘못된 입력값입니다. 프로그램을 종료시킵니다");
//            }
//        }

        String input = scanner.nextLine();

        result(input, answer);


    }

    private static void result(String input, String answer) {

        String pattern = "[1-9]{3}";
        verify(input, pattern);

        int ball = 0;
        int strike = 0;

        Map<String, Integer> ansMap = new HashMap<>();

        String[] inputArr = input.split("");
        String[] ansArr = answer.split("");

        for (int i=0; i<3; i++) {
            ansMap.put(ansArr[i], i);
        }

        for (int i=0; i<3; i++) {
            if (ansMap.containsKey(inputArr[i])) {
                if (i == ansMap.get(inputArr[i])){
                    strike += 1;
                }
                else {
                    ball += 1;
                }
            }

        }





    }

    private static void verify(String input, String pattern) {
        boolean matched = Pattern.matches(pattern, input);

        if (!matched){
            throw new IllegalArgumentException("잘못된 입력값입니다. 프로그램을 종료시킵니다");
        }


    }
}
