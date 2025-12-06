package Asylum.util;

import java.util.Scanner; //애는 패키지? 클래스? 내에서 공유가 안되는 것 같음
//import java.util.*; < util 전체 import 하기.

public abstract class Effects {

    //ANSI 리스트
    public static final String RED = "\u001B[31m"; //글씨 빨강
    public static final String WHITE = "\u001B[37m"; //글씨 하양
    public static final String BRIGHT_WHITE = "\u001B[97m"; //글씨 밝은 하양
    public static final String BOLD = "\u001B[1m"; //글씨 굵게
    public static final String UNDERLINE = "\u001B[4m"; //글씨 언더라인
    public static final String ITALIC = "\u001B[3m"; //글씨 이탤릭
    //public static final String BLINKFAST = "\u001B[6m"; //깜빡임 빠르게 < 아니 얘 챗지가 알려줘서 테스트해봤는데 차이가 없어서??? 했더니 지원 안한다함 장난하냐
    public static final String STROKE = "\u001B[9m"; //취소선

    public static final String RESET = "\u001B[0m"; //모든 효과 리셋
    //얘네들은 public으로 해둬도 다른 class에서 바로 사용이 불가능하다. 왜 그런지 모르겠음. 리스트를 복사 붙여넣기 해서 써야함. 왜지?
    //System.out.println(Asylum.game.Effects.STROKE + "TEST 하는 중" + Asylum.game.Effects.RESET); < 이런 식으로 앞에 class명 붙여넣어주어야 하는듯.


    //천천히 한 글자씩 타이핑하는 효과
    public static void typePrint(String text, long delay) { //여기서 text와 delay가 파람.
        //InterruptedException - Thread.sleep이라는 예외를 처리하기 위해서 필요.
        //try-catch는 여기서 처리해야하지만 throws는 이 method를 사용하는 쪽에서 처리하라고 하는 data validation 역할.
        //여기서 왜 throw를 try-catch 대신 썼냐면, Thread.sleep 중에 예외가 나올 수 있는데 그걸 출력에서 해결할게 아니라서 불러오는 쪽에서 해결하라고...?
        //솔직히 이해 못함. 근데 이 method는 문제(InterruptedException)을 해결할 수 있는 능력이 없는 메서드라고 함.
        //아, 다른 thread가 thread.interrupt를 사용해서 현재 자고 있는 이 부분의 thread를 깨울 수 있다고 함.
        //깨우는 방법은 1) 사용자가 취소 버튼을 누르거나, 백그라운드에서 오래 걸리는 작업을 중단시키거나, 게임 루프를 중단할때 등이라고 함.

        //int 대신 long을 쓰는 이유는 1) Thread.sleep 자체가 long으로 받고, int는 약 35분까지의 딜레이만 가능하고지만 long은 무한대 & 나노초 기반도 가능하기 때문

        for (char c : text.toCharArray()) { //c 한글자씩 받은 Array(는 이미 기본 java.lang에 있어서 따로 import 기능이 필요없다고 함)
            System.out.print(c);
            System.out.flush();//버퍼에 저장해서 우르르가 아니라 한 번에 한 자씩 강제로 내보냄. 버퍼를 지워줌.
            sleep(delay);
        }
        try {
            Thread.sleep(delay);
        }
         catch (InterruptedException e) {
             Thread.currentThread().interrupt(); //얘 쓰면 다른 곳에서도 throws InterruptedException 써야하는게 귀찮아서 만듬
             //얘 말고 throw new RuntimeException(e); // 체크 예외 → 언체크화 < 로도 쓸 수 있고 둘 다 각각 장단점이 있는데 일단 내가 현재 Thread를 배웠으니 이렇게 써봄
         }
        System.out.println();// \n 넣어주는 역할

    }
    public static final long DELAY_DEFAULT = 75; //여기서 DEFAULT_DELAY는 파람이 아니고 상수(constant)라고 한다고 함. 그래서 대문자 & 언더스코어.
    public static final long DELAY_SLOW = 200;
    public static final long DELAY_FAST = 50;

//    public enum Speed { //같은 type 모음. 클래스처럼 움직여서 Speed 앞글자가 대문자.
//
//    }

    public static void typePrint(String text) { //처음으로 오버로딩 써봄 오오
        typePrint(text, DELAY_DEFAULT);

    }

    //라인 하나씩마다 sleep 기능 넣기
    public static void typePrintLn(String text) {
        typePrint(text);
        sleep(DELAY_FAST);

    }

    //라인 하나씩마다 sleep 기능 넣기의 오버로딩
    public static void typePrintLn(String text, long Delay) {
        typePrint(text, Delay);
        sleep(Delay);

    }


    //입력값이 4번 이상 넘어가면 글자를 빨갛게 바꿔주는 효과
    public static void fourTimes(String text, int attempts) {

        if (attempts >= 4) {

            System.out.println(RED + text + RESET);

        } else {
            System.out.println(text);
        }

    }

    //Thread.sleep을 캡슐화. (유틸리티로 분류되어서 package에 util이라고 분류되어서 갖다놓고 쓴다)
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    //빠른 커서 깜빡임. 일단은 ▼로 하드 코딩
    public static void blinkFast(long ms) {
        for (int i = 0; i < 20; i++) {
            System.out.print("▼");
            System.out.flush();
            sleep(80); //위의 sleep을 씀. 다른 곳에서 쓸 때는 Asylum.game.Effects.sleep으로 불러와줘야함

            System.out.print("\r" + "▽");
            System.out.flush();
            sleep(80);

            System.out.print("\r" + "  ");
            System.out.print("\r");
            System.out.flush();
        }
    }

    //일반 깜빡이는거... 챗지피티가 짜줌. 그냥 넣어봄
    public static void blinkSlow(long ms) {
        boolean up = false;

        for (int i = 0; i < 6; i++) {
            if (up) {
                System.out.print("\r▼");
            } else {
                System.out.print("\r▽");
            }
            System.out.flush();
            up = !up;

            Effects.sleep(400); //깜빡이 속도 조절
        }
        // 끝나고 지우기
        System.out.print("\r  \r");
        System.out.flush();
    }

    //진짜 짜고 싶었던 엔터 칠 때까지 계속 깜빡이고, 엔터 치면 사라지는 기능
        private static volatile boolean blinking = false;
        public static void blinkEnter() {

            blinking = true;

            Thread blinkThread = new Thread(() -> { //새로운 스레드 만들기
                boolean flag = false;

                while (blinking) {
                        System.out.print("\r" + (flag ? "▼" : "▽"));
                        System.out.flush();
                        flag = !flag;

                    try { Thread.sleep(500); } catch (InterruptedException ignored) {}
                }

//                System.out.print("\u001B[1A"); //한 줄 위로 올리기
//                System.out.print("\r   \r");
//                System.out.flush();
                  //의미가 없어서 지움... 완벽하게 화살표 지우는건 불가능하다고 함

            });

            blinkThread.start(); //스레드 실행

            // 엔터 입력 대기
            Scanner sc = new Scanner(System.in);
            sc.nextLine();

            // 스레드 종료
            blinking = false;

            try {
                blinkThread.join();
            } catch (InterruptedException ignored) {}


        }
    }




//public class TypeEffects extends Asylum.game.Effects { //실제로 서브 클래스 없는데 이런 식으로 만들면 에러가 나는구나
//
//
//}
