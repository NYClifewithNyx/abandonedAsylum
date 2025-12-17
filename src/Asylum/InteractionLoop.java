package Asylum;

import Asylum.util.Interaction;

public class InteractionLoop {

    public static void start(GameState state) { //제발 class 내에 method 만드는거 잊지 말자

        while (true) {
            PlaceManager.currentPlace(state);
            showActionMenu(state);
        }
    }

    private static void showActionMenu (GameState state) {
        Place place = state.getCurrentPlace();

        System.out.println();
        System.out.println("어디로 이동하시겠습니까?");

        switch (place) {
            case ROOM_ER -> {
                    System.out.println("[1] 친구를 살펴본다");
                    System.out.println("[2] 복도로 나간다");
                    System.out.println("[3] 침대에서 잠을 청한다");
            }
            case HALLWAY -> {
                    System.out.println("[1] 친구가 있는 병실로 돌아간다");
                    System.out.println("[2] 간호사 스테이션으로 가본다");
                    System.out.println("[3] 정문으로 가본다");
                    System.out.println("[4] 뒷문으로 가본다");
                    System.out.println("[5] 101호로 가본다");
                    System.out.println("[6] 102호로 가본다");
                    System.out.println("[7] 103호로 가본다");
                    System.out.println("[8] 105호로 가본다");
                    System.out.println("[9] 원장실로 가본다");

            }
        }

        int choice = Interaction.getNumberInRange(1, 9);
        handleChoice(choice, state);

    }

    private static void handleChoice(int choice, GameState state) {

        if (choice == 1) {
            state.moveTo(Place.HALLWAY);
        }

    }


}
