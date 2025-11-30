import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class testsample {

    private static volatile boolean running = true;
    // 다른 스레드에서 값을 바꿀 수 있게 volatile 사용

    public static void main(String[] args) throws Exception {
        System.out.println("게임을 로딩 중입니다...\n");

        int total = 20; // 로딩바 길이

        for (int i = 0; i <= total; i++) {

            // ■■□□ 형태로 막대 생성
            String bar = "■".repeat(i) + "□".repeat(total - i);

            int percent = (i * 100) / total;

            System.out.print("\r[" + bar + "] " + percent + "%");

            Thread.sleep(200);
        }

        pressEnterToStart();
        System.out.println("\n게임을 시작합니다...");
    }

    public static void pressEnterToStart() throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String red = "\u001B[31m";
        String reset = "\u001B[0m";

        String text = "PRESS ENTER TO START";
        String message = red + text + reset;
        String empty = " ".repeat(text.length());

        // ✨ 스레드 1: 깜빡이는 텍스트
        Thread blinkThread = new Thread(() -> {
            try {
                while (running) {
                    System.out.print("\r" + message);
                    Thread.sleep(400);
                    System.out.print("\r" + empty);
                    Thread.sleep(400);
                }
            } catch (InterruptedException ignored) {}
        });

        blinkThread.start();

        // ✨ 스레드 2: 엔터 입력 감지
        br.readLine();  // 엔터 누를 때까지 대기

        // 스레드 종료 신호
        running = false;

        // 깜빡임 마지막 남은 줄 지우기
        System.out.print("\r" + empty);

        // 완전히 멈출 때까지 대기
        blinkThread.join();
    }
}
//public class Title {
//
//    public static void main(String[] args) throws InterruptedException {
//        loading();
//    }
//
//        public static void loading() throws InterruptedException {
//            System.out.println("게임을 로딩 중입니다...\n");
//
//            int total = 20; // 로딩바 길이
//
//            for (int i = 0; i <= total; i++) {
//
//                // ■■□□ 형태로 막대 생성
//                String bar = "■".repeat(i) + "□".repeat(total - i);
//
//                int percent = (i * 100) / total;
//
//                System.out.print("\r[" + bar + "] " + percent + "%");
//
//                Thread.sleep(200);
//            }
//
//            System.out.println("\n\n게임이 로딩 되었습니다!");
//        }
//
//
//    public static void loading() throws InterruptedException {
//        System.out.println("게임을 로딩 중입니다...");
//
//        for (int i = 0; i <= 10; i++) {
//            System.out.printf("\r로딩: %3d%%", i * 10);
//            Thread.sleep(300); // 0.3초
//        }
//
//        for (int i = 0; i <= 10; i++) {
//            System.out.print("\r로딩: " + (i * 10) + "%");
//            Thread.sleep(300); // 0.3초
//        }
//
//
//}


//public class testMain {
//
//    private static final String RED = "\u001B[31m";
//    private static final String BOLD = "\u001B[1m";
//    private static final String REVERSE = "\u001B[7m";
//    private static final String RESET = "\u001B[0m";
//
//    public static void main(String[] args) {
//        String text = "들 켰 네...???";
//
//        System.out.println("=== 기본 흔들림 ===");
//        shakeText(text, 25);
//
//        sleep(500);
//
//        System.out.println("\n=== 강한 흔들림 + 색/반전 ===");
//        violentShake(text, 35);
//
//        System.out.println("\n끝.");
//    }
//
//    // 1) 좌우로 살짝 흔들리는 기본 버전
//    public static void shakeText(String text, int times) {
//        for (int i = 0; i < times; i++) {
//            int spaces = (int)(Math.random() * 4); // 0~3칸
//            String pad = " ".repeat(spaces);
//
//            System.out.print("\r" + pad + text);
//            sleep(8);
//        }
//        System.out.print("\r" + text + "        "); // 잔상 지우기용 공백
//        System.out.println();
//    }
//
//    // 2) 빨강 + 볼드 + 반전 + 흔들림(공포 연출용)
//    public static void violentShake(String text, int times) {
//        for (int i = 0; i < times; i++) {
//            int spaces = (int)(Math.random() * 6); // 더 많이 흔들리게
//            String pad = " ".repeat(spaces);
//
//            System.out.print("\r" + BOLD + RED + REVERSE + pad + text + RESET);
//            sleep(35);
//        }
//        System.out.print("\r" + text + "        ");
//        System.out.println();
//    }
//
//    // 공통 sleep 헬퍼
//    private static void sleep(long millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException ignored) {
//        }
//    }
//}



//import java.io.PrintStream;
//
//public class testMain {
//
//
//    private static final String RED = "\u001B[31m"; //글씨 빨강
//    private static final String BOLD = "\u001B[1m"; //글씨 굵게
//    private static final String UNDERLINE = "\\u001B[4m"; //글씨 언더라인
//    private static final String ITALIC = "\\u001B[3m"; //글씨 이탤릭
//    private static final String RESET = "\u001B[0m"; //글씨 리셋
//    private static final String BLINKFAST = "\u001B[6m"; //깜빡임 빠르게
//    private static final String REVERSE = "\u001B[7m";
//
//
//
//    public static void main(String[] args) {
//
//        String text = "들 켰 네...???";
//
//        System.out.println("=== 빠른 흔들림 테스트 ===");
//        fastShake(text, 100);
//
//        System.out.println("\n끝.");
//    }
//
//    // 초고속 흔들림
//    public static void fastShake(String text, int times) {
//        PrintStream out = System.out;
//
//        for (int i = 0; i < times; i++) {
//            int spaces = (int)(Math.random() * 3); // 훨씬 더 크게 흔들림
//            String pad = " ".repeat(spaces);
//
//            out.print("\r" + BOLD + RED + REVERSE + pad + text + RESET + "     ");
//            out.flush(); // 출력 즉시 반영
//
//            sleep(20); // 초고속 (너무 빠르면 5도 가능)
//        }
//
//        // 마지막 정리
//        out.print("\r" + text + "            ");
//        out.println();
//    }
//
//    private static void sleep(long ms) {
//        try {
//            Thread.sleep(ms);
//        } catch (InterruptedException ignored) {}
//    }
//}
