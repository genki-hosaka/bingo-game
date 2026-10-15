package bingo;
import java.util.List;

public class BingoChecker {

    private final int[][] bingoCard;
    private final List<Integer> drawNumbers;
    private static final int ROW_SIZE = 5;
    private static final int COL_SIZE = 5;
    private static final int CENTER_ROW = 2;
    private static final int CENTER_COL = 2;
    private static final int REACH_HITS = 4;
    private static final int BINGO_HITS = 5;

    public BingoChecker(int[][] bingoCard, List<Integer> drawNumbers) {
        this.bingoCard = bingoCard;
        this.drawNumbers = drawNumbers;
    }

    // リーチのカウント数
    public int countReach() {
        return countLines(REACH_HITS);
    }

    // ビンゴのカウント数
    public int countBingo() {
        return countLines(BINGO_HITS);
    }

    // リーチ・ビンゴのライン数
    private int countLines(int targetCount) {
        int count = 0;
        // 行のリーチ・ビンゴチェック
        for (int row = 0; row < ROW_SIZE; row++) {
            int rowCount = 0;
            for (int col = 0; col < COL_SIZE; col++) {
                if (isHit(row, col)) {
                    rowCount++;
                }
            }
            if (rowCount == targetCount) {
                count++;
            }
        }
        // 列のリーチ・ビンゴチェック
        for (int col = 0; col < COL_SIZE; col++) {
            int colCount = 0;
            for (int row = 0; row < ROW_SIZE; row++) {
                if (isHit(row, col)) {
                    colCount++;
                }
            }
            if (colCount == targetCount) {
                count++;
            }
        }
        // 左斜めのリーチ・ビンゴチェック
        int leftDiagonalCount  = 0;
        for (int i = 0; i < ROW_SIZE; i++) {
            if (isHit(i, i)) {
                leftDiagonalCount++;
            }
        }
        if (leftDiagonalCount == targetCount) {
            count++;
        }
        // 右斜めのリーチ・ビンゴチェック
        int rightDiagonalCount = 0;
        for (int i = 0; i < ROW_SIZE; i++) {
            if (isHit(i, COL_SIZE - 1 - i)) {
                rightDiagonalCount++;
            }
            
        }
        if (rightDiagonalCount == targetCount) {
            count++;
        }

        return count;
    }

    // hitチェック
    private boolean isHit(int row, int col) {
        if (row == CENTER_ROW && col == CENTER_COL) {
            return true;
        }
        return drawNumbers.contains(bingoCard[row][col]);
    }
}