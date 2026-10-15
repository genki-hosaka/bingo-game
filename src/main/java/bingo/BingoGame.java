package bingo;
import java.util.ArrayList;

public class BingoGame {

    private final ArrayList<Integer> drawNumbers = new ArrayList<>();
    private static final int TOTAL_BINGO_LINES = 12;

    public void start() {
        NumberGenerator numberGenerator = new NumberGenerator();
        BingoCard bingoCard = new BingoCard();
        BingoChecker bingoChecker = new BingoChecker(bingoCard.getCard(), drawNumbers);
        int drawCount = 0;
        
        do {
            drawCount++;
            // ビンゴボール出力
            int drawNumber = numberGenerator.drawNumber();
            System.out.println("ball[" + drawCount + "]:" + drawNumber);
            // ビンゴカード出力
            drawNumbers.add(drawNumber);
            bingoCard.displayCard(drawNumbers);
            // リーチ・ビンゴ数出力
            displayResult(bingoChecker);
        } while (bingoChecker.countBingo() != TOTAL_BINGO_LINES);
    }

    private void displayResult(BingoChecker bingoChecker) {
        System.out.println("REACH: " + bingoChecker.countReach() + "\t");
        System.out.println("BINGO: " + bingoChecker.countBingo() + "\t");
        System.out.println("--------------------\t");
    }
}