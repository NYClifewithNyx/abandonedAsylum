package Asylum.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interaction {

    //인트로에서 YN 받을때
    public static int introYN() {
        //이 int 값을 돌려줘서 밖에서 받아서 switch로 연결되어야하기 때문. 리턴 값이 뭔지를 정하는 것. void는 줄 건 없어 > 게임이 진행이 안됨.
        Scanner sc = new Scanner(System.in);
        int answer; //여기다 하는게 나은지, try 안에서 int answer 하는게 나은지는 잘 모르겟음
        int attempts = 0; //잘못 횟수 카운터

        System.out.println("[1] 네");
        System.out.println("[2] 아니오");
        //answer = sc.nextInt(); < 처음엔 예전에 하듯이 여기다 넣었는데 try-catch로 감싸고 그 안에 if-else로 감싸는게 안전한듯

        while (true) {
            try {
                answer = sc.nextInt();
                sc.nextLine();

                if (answer == 1 || answer == 2) { //이걸 != 1 || != 2 즉 아닐 때의 값으로 쓰면 노란 라인이 뜨면서 unwrap if라고 뜸. 이유 모르는데 챗지피셜 그건 항상 true라서라고 함...
                    //대신 지금처럼 == 1 || == 2로 진행하면 노란 줄도 안 뜨고 코드가 예쁨.
                    return answer;
                    //이 다음에 loop를 끝내려고 break를 썼는데 이미 return 값 때문에 루프에서 벗어나서 break에 도달할 수가 없어서 실행이 안된다고 함.
                }

                if (attempts >= 8) {
                    Effects.typePrint(Effects.RED + "다른 방법은 없다고 말했을텐데...?\n" + Effects.RESET, Effects.DELAY_SLOW);

                } else if (attempts >= 4 && attempts < 8) {
                    Effects.fourTimes("다른 방법은 존재하지 않습니다", attempts);

                } else {
                    System.out.println("다른 방법은 존재하지 않습니다");

                }

                attempts++;

            } catch (InputMismatchException e) {
                sc.nextLine();
                attempts++;

                if (attempts >= 4) {
                    Effects.fourTimes("다른 방법은 존재하지 않습니다", attempts);

                } else {
                    System.out.println("다른 방법은 존재하지 않습니다");

                }
            }
        }
    }

    //메뉴에서 1~5 받을때
    public static String getMenuChoice() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String choice = sc.nextLine(); //여기다 하는게 나은지, try 안에서 int answer 하는게 나은지는 잘 모르겠음

            if (choice.matches("[1-5]")) { //이렇게 쓰는게 신기하네
                return choice;
            } else {
                System.out.println(Effects.RED + "없는 번호입니다. 다시 눌러주세요" + Effects.RESET);
            }

            //원래대로라면 이렇게 짤텐데, 여기 interaction에서는 입력값 받는 일만 하려고 해서 없애고 위의 방법대로 함
//            switch (choice) {
//                case "1":
//                case "2":
//                case "3":
//                case "5":
//                    return choice;
//
//                case "4":
//                    System.out.println("4번은 존재하지 않습니다");
//                    break;
//
//                default:
//                    System.out.println("잘못된 입력입니다");
//                    break;

        }


    }

    public static int SimpleYN() {
        //이 int 값을 돌려줘서 밖에서 받아서 switch로 연결되어야하기 때문. 리턴 값이 뭔지를 정하는 것. void는 줄 건 없어 > 게임이 진행이 안됨.
        Scanner sc = new Scanner(System.in);
        int answer; //여기다 하는게 나은지, try 안에서 int answer 하는게 나은지는 잘 모르겟음
        int attempts = 0; //잘못 횟수 카운터

        System.out.println("[1] 네");
        System.out.println("[2] 아니오");
        //answer = sc.nextInt(); < 처음엔 예전에 하듯이 여기다 넣었는데 try-catch로 감싸고 그 안에 if-else로 감싸는게 안전한듯

        while (true) {
            try {
                answer = sc.nextInt();
                sc.nextLine();

                if (answer == 1 || answer == 2) { //이걸 != 1 || != 2 즉 아닐 때의 값으로 쓰면 노란 라인이 뜨면서 unwrap if라고 뜸. 이유 모르는데 챗지피셜 그건 항상 true라서라고 함...
                    //대신 지금처럼 == 1 || == 2로 진행하면 노란 줄도 안 뜨고 코드가 예쁨.
                    return answer;
                    //이 다음에 loop를 끝내려고 break를 썼는데 이미 return 값 때문에 루프에서 벗어나서 break에 도달할 수가 없어서 실행이 안된다고 함.
                } else {
                    System.out.println("다른 방법은 존재하지 않습니다");

                }

                attempts++;

            } catch (InputMismatchException e) {
                sc.nextLine();
                attempts++;

                    System.out.println("다른 방법은 존재하지 않습니다");

                }
            }
        }

    }


    public static int getNumberInRange(int min, int max) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("> ");
            String input = sc.nextLine();

            try {
                int value = Integer.parseInt(input);

                if (value < min || value > max) {
                    System.out.println(min + "부터 " + max + " 사이의 숫자를 입력해주세요.");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }


    }



    }



