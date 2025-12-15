package Asylum;

public class GameState {

    //1. 현재 위치 저장
    private Place currentPlace;

    //2. 생성자; 게임 시작 위치 지정
    public GameState() {
        this.currentPlace = Place.ROOM_ER; //시작 위치
    }

    //3. 현재 위치를 찾는 메서드
    public Place getCurrentPlace() {
        return currentPlace;
    }

    //4. 위치 이동용 메서드
    public void moveTo(Place newPlace) {
        this.currentPlace = newPlace;

    }


}
