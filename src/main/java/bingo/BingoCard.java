package bingo;
import java.util.List;
import java.util.Random;

public class BingoCard {
    
    private static final int ROW_SIZE = 5;
    private static final int COL_SIZE = 5;
    private static final int CENTER_ROW = 2;
    private static final int CENTER_COL = 2;
    private static final int NUMBERS_PER_COLUMN = 15;
    private final int[][] bingoCard = new int[ROW_SIZE][COL_SIZE];
    private final Random random = new Random();

    public BingoCard() {
        // 列生成
        for (int col = 0; col < COL_SIZE; col++) {
            // 行の最大値、最小値生成
            int minNumber = col * NUMBERS_PER_COLUMN + 1;
            int maxNumber = col * NUMBERS_PER_COLUMN + NUMBERS_PER_COLUMN;

            for (int row = 0; row < ROW_SIZE; row++) {
                boolean isDuplicate;
                int number;
                // FREEはスキップ
                if (col == CENTER_COL && row == CENTER_ROW) {
                    continue;
                }
                // 重複チェック
                do {
                    isDuplicate = false;
                    number = random.nextInt(maxNumber - minNumber + 1) + minNumber;
                    for (int previousRow = 0; previousRow < row; previousRow++) {
                        if (number == bingoCard[previousRow][col]) {
                            isDuplicate = true;
                            break;
                        }
                    }
                } while (isDuplicate);

                bingoCard[row][col] = number;
            }
        }
    }

    // ビンゴカード出力
    public void displayCard(List<Integer> numbers) {
        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                if (col == CENTER_COL && row == CENTER_ROW) {
                    System.out.print("FREE\t");
                } else if (numbers.contains(bingoCard[row][col])) {
                    System.out.printf("(%02d)\t", bingoCard[row][col]);
                } else {
                    System.out.printf("%02d\t", bingoCard[row][col]);
                }
            }
            System.out.println();
        }
    }

    public int[][] getCard() {
        return bingoCard;
    }
}