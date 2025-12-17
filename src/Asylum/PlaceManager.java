package Asylum;

import Asylum.util.Interaction;
import Asylum.util.Effects;

import java.lang.module.ModuleReference;

public class PlaceManager {

    public static void currentPlace (GameState state) {
        Place place = state.getCurrentPlace();

        System.out.println();
        System.out.println("어디로 갈까...");
//        switch (place) {
//            case ROOM_ER -> Effects.typePrintLn("단체 병동이다. 내가 누워있었던 침대 옆에 친구가 누워있다. \n그런데...");
//            case HALLWAY -> Effects.typePrintLn("물건이 이리저리 흐트러진 복도로 나왔다.");
//            case NURSE_STATION -> Effects.typePrintLn("간호 스테이션이다. 누군가 뒤진듯, 모든게 엉망진창이다.");
//            case ROOM_GRANDMA -> Effects.typePrintLn("누군가가 썼던것 같은 병실이다. 병실 밖 환자명은 '김옥분'이라고 쓰여있다.");
//            case ROOM_GRANDPA -> Effects.typePrintLn("모든게 난장판이 된 병실이다. 벽에는 오래되고 낡은 군복이 걸려있다.");
//            case ROOM_WOMAN -> Effects.typePrintLn("모든걸 뒤집어 엎은 듯한 병실이다. 화분이 바닥에 깨져있다.");
//            case ROOM_MAN -> Effects.typePrintLn("엉망진창이 된 병실이다. 들어가자마자 보이는 침대 밑엔 소주병이 깨져있다.");
//            case ROOM_STUDENT -> Effects.typePrintLn("찢겨진 종이가 널려있는 병실이다. 빼곡하게 적힌 노트가 많다. 누가 썼을까?");
//            case ROOM_CLINIC -> Effects.typePrintLn("진료실 같다. 가운데 커다란 책상이 있고 의자들은 다 내팽겨쳐져 있다.");
//            case ROOM_DOCTOR ->
//                    Effects.typePrintLn("원장실이라고 적혀있다. 문이 잠겨서 열리지 않는다. \n 문에 난 창문으로 들여다보니, 잠긴 이후에 아무도 못 들어간 듯, 어질러져 있지 않고 잘 정리되어 있다.");
//            case DOOR_MAIN -> Effects.typePrintLn("중앙 출입문이다. 내부에서 체인이 걸려 자물쇠로 잠겨져 있다. 내부...에서?");
//            case DOOR_BACK -> Effects.typePrintLn("뒷문이다. 밖에서 잠겨있는 것 같다. 안에서 열 수 있는 방법은 없어보인다");
//
//        }
    }

//    public static void moveToPlace(GameState state) {
//        Place current = state.getCurrentPlace();
//        Place[] place = Place.values(); //enum 목록 전부
//
//        System.out.println("어디로 갈까?");
//
//        for (int i = 0; i < place.length; i++) {
//            System.out.printf("[%d] %s%n", i + 1, toKoreanName(place[i]));
//        }
//
//        int choice = Interaction.getNumberInRange (1, place.length);
//
//
//    }




}
