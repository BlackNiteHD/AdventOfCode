package day2;

public enum EnumGameState {

    WIN(6,"Z"),
    LOSE(0,"X"),
    DRAW(3, "Y");

    public int point;
    public String interpret;
    EnumGameState(int point, String interpret) {
        this.point = point;
        this.interpret = interpret;
    }

    public static EnumGameState getEnumFromInterpret(String interpret)
    {
        for (EnumGameState enumGameState : EnumGameState.values()) {
            if(enumGameState.interpret.equals(interpret))
                return enumGameState;
        }
        return null;
    }
}
