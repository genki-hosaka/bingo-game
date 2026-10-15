package bingo;
import java.util.HashSet;
import java.util.Random;

public class NumberGenerator {

    private final HashSet<Integer> drawNumbers = new HashSet<>();
    private final Random random = new Random();

    public int drawNumber() {
        // ランダムで1~75を生成
        int number = generateRandomNumber();
        // ランダムが重複していないかチェック
        while(drawNumbers.contains(number)) {
            number = generateRandomNumber();
        }
        drawNumbers.add(number);

        return number;
    }

    private int generateRandomNumber() {
        return random.nextInt(75) + 1;
    }
}