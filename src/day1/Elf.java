package day1;

public class Elf {

    private int[] calories;

    public Elf(int[] calories) {
        this.calories = calories;
    }

    public int getCaloriesSum() {
        int sum = 0;
        for (int calorie : calories) {
            sum+=calorie;
        }
        return sum;
    }
}
