package Asylum;

public enum Place { //파일 타입을 class에서 enum으로 바꿈

    ROOM_ER("공동 병동"), //응급 병동
    HALLWAY("복도"), //복도
    NURSE_STATION("간호사 스테이션"), //병동 간호 스테이션
    DOOR_MAIN("정문"), //중앙 출입문. 체인이 안쪽으로 걸려있다
    DOOR_BACK("뒷문"), //뒷문. 밖에서 잠겨있다
    ROOM_GRANDMA("101호 병실"), //할머니 환자의 방
    ROOM_GRANDPA("102호 병실"), //할아버지 환자의 방
    ROOM_WOMAN("103호 병실"), //젊은 여자의 방
    ROOM_MAN("105호 병실"), //중년 아저씨의 방
    ROOM_STUDENT("106호 병실"), //10대 학생의 방
    ROOM_CLINIC("진료실"), //진료실
    ROOM_DOCTOR("원장실"); //원장실

    private final String displayName;

    Place(String displayName) {
        this.displayName = displayName;

    }

    public String getDisplayName() {
        return displayName;
    }
}
