//감독 역할을 하는 클래스

package Asylum;
import Asylum.util.Interaction;

public class GameManager {

    private GameState state = new GameState();

    public void start() {

        Intro.loading();
        int answer = Interaction.introYN();

        if (answer == 1) {
            Intro.introNote();
        }

        Intro.title();


    }




}
