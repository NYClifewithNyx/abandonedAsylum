package Asylum;

import Asylum.util.Interaction;

public class Main {
    static void main(String[] args) throws InterruptedException {

    Intro.loading();
    int answer = Interaction.simpleYN();

    switch (answer) {
        case 1:
            Intro.introNote();
            Intro.title();
            break;
        case 2:
            Intro.title();
            break;
    }


    }

}
