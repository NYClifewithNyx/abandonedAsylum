//감독 역할을 하는 클래스

package Asylum;
import Asylum.scenario.Prologue;
import Asylum.util.Effects;
import Asylum.util.Interaction;
import java.util.Scanner;

import static Asylum.util.Effects.DELAY_SLOW;


public class GameManager {

    private GameState state = new GameState();

    public void start() {

        Intro.loading();
        int answer = Interaction.introYN();

        if (answer == 1) {
            Intro.introNote();
        }

        titleLoop();

    }

    private void titleLoop() {
       while (true) {
            Intro.title();
            String choice = Interaction.getMenuChoice();

            switch (choice) { // ->는 자바 14+부터 적용이 되는, break를 따로 안해도 되는 루프
                case "1" -> Prologue.prologue();
                case "2" -> System.out.println("loadGame()");
                case "3" -> Intro.introNote();
                case "4" -> {
                    Effects.typePrint(Effects.RED + "어떻게... 알았지....?" + Effects.RESET);

                    for (int i = 0; i <= 1000; i++) {
                        System.out.print(Effects.RED + "ㅋ");
                    }

                }
                case "5" -> {
                    Effects.typePrint("\n게임을 종료합니다...", DELAY_SLOW);
                    System.exit(0);
                }
                default -> {
                    Effects.typePrint("지금 거신 번호는 없는 번호이오니...",DELAY_SLOW);
                    System.out.println("...전화가 끊겼다.");
                }

            }

        }
    }

}


