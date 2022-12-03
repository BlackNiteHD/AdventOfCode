package day2;

public enum EnumRPS {

    ROCK(1, "A","X"),
    PAPER(2, "B", "Y"),
    SCISSORS(3, "C", "Z");

    public int point;
    public String interpretPlayer;

    public String interpretOpposent;

    EnumRPS(int point, String interpretOpposent, String interpretPlayer) {
        this.point = point;
        this.interpretPlayer = interpretPlayer;
        this.interpretOpposent = interpretOpposent;
    }

    public static EnumRPS getEnumFrominterpretPlayer(String interpret)
    {
        for (EnumRPS enumRPS : EnumRPS.values()) {
            if(enumRPS.interpretPlayer.equals(interpret))
                return enumRPS;
        }
        return null;
    }

    public static EnumRPS getEnumFromInterpretOpposent(String interpretOpposent)
    {
        for (EnumRPS enumRPS : EnumRPS.values()) {
            if(enumRPS.interpretOpposent.equals(interpretOpposent))
                return enumRPS;
        }
        return null;
    }
}
