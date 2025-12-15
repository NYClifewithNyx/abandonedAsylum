package Asylum.user;
import Asylum.user.CharacterId;

public class Character {

    private final CharacterId id;
    private boolean visible = false;

    public Character(CharacterId id) {
        this.id = id;
    }

    public CharacterId getId() {
        return id;
    }

//    public void talk() {
//        System.out.println(id + " 이(가) 아무 말도 하지 않는다.");
//    }


}
