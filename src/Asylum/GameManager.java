//감독 역할을 하는 클래스

package Asylum;
import Asylum.scenario.*;
import Asylum.util.Effects;
import Asylum.util.Interaction;

import static Asylum.util.Effects.DELAY_SLOW;


public class GameManager {

    private GameState state = new GameState();
    private boolean skipPrologue = false;

    public void start() {

        Intro.loading();
        int answer = Interaction.introYN();

        if (answer == 1) {
            Intro.introNote();
        }

        titleLoop(true);
        //titleLoop(false); < 나중에 조건 걸어서...
        if (!skipPrologue) {
            Chapter.prologue();
        }

        Chapter.chapter1_Day();

    }

    private void titleLoop(boolean normal) {
        while (true) {
            // 1. 타이틀 출력
            if (normal) {
                Intro.title();
            } else {
                Intro.titleSecret();
            }

            //2. 선택 입력
            String choice = Interaction.getMenuChoice();

            //3. 메뉴
            switch (choice) { // ->는 자바 14+부터 적용이 되는, break를 따로 안해도 되는 루프
                case "1" -> {
                    System.out.println("프롤로그를 스킵할까요?");

                    int answer = Interaction.SimpleYN();

                    if (answer == 1) {
                        skipPrologue = true;

                    } else {
                        skipPrologue = false;
                    }
                    return;
                }

                case "2" -> System.out.println("loadGame()");

                case "3" -> Intro.introNote();

                case "4" -> {

                    if (normal) {
                        System.out.println();
                        Effects.typePrint(Effects.RED + "어떻게..." + "\n알았지....?" + Effects.RESET);
                        Effects.typePrint(Effects.RED + "ㅋ", 80);
                        Effects.typePrint(Effects.RED + "ㅋ", 70);
                        Effects.typePrint(Effects.RED + "ㅋ", 60);

                        int lineWidth = 80;

                        for (int i = 0; i <= 1280; i++) {
                            System.out.print(Effects.RED + "ㅋ");

                            if (i % lineWidth == 0) {
                                System.out.print("\n");

                            }
                        }
                        Effects.sleep(600);
                        return;

                    } else {
                        System.out.println();
                        Effects.typePrint(Effects.RED + "지금 거신 번호는 없는 번호이오니..." + Effects.RESET);
                        Effects.typePrint(Effects.RED + "..." + Effects.RESET, DELAY_SLOW);
                        Effects.typePrint(Effects.RED + "..." + Effects.RESET, DELAY_SLOW);
                        Effects.typePrint(Effects.RED + "...뚝" + Effects.RESET, DELAY_SLOW);
                        System.out.println("전화가 끊겼습니다");
                        Effects.sleep(600);

                    }

                }

                case "5" -> {
                    Effects.typePrint("\n게임을 종료합니다...", DELAY_SLOW);
                    Effects.sleep(600);
                    System.exit(0);
                }

                default -> {
                    Effects.typePrint("지금 거신 번호는 없는 번호이오니...", DELAY_SLOW);
                    System.out.println("...전화가 끊겼다.");
                    Effects.sleep(600);

                }

            }


        }
    }

    private void mainLoop() {
        Chapter.chapter1_Day();
    }

}

