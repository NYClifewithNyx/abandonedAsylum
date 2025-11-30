import Asylum.util.Effects;

public class Intro {
    //클래스 안에는 꼭 method가 있어줘야 한다.  Class는 그냥 모음집 이름 뿐이다

    public static void loading() { //실제로 움직이는 메써드
        System.out.println();
        Effects.typePrint("바닥에 쪽지가 떨어져 있습니다...");
        System.out.println("\n주우시겠습니까?\n");
    }

    public static void introNote() {
        Effects.typePrint(Effects.RED + "\n당신은 쪽지를 열어봅니다..." + Effects.RESET);

        Effects.typePrint("쪽지에는 이렇게 쓰여있습니다...\n");

    }

    public static void title() {

        Effects.typePrint("\n<<<그 날, 폐벙동에서 우리는>>",Effects.DEFAULT_FAST);
        Effects.sleep(400);
        System.out.print("\n");
        System.out.println("1. 시작하기");
        System.out.println("2. 이어하기");
        System.out.println("3. 쪽지를 다시 읽는다");
        System.out.println("F. ��▒▒▒╬▓╫Ãþ¿");
        System.out.println("5. 종료하기");

    }
}

