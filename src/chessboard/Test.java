package chessboard;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Figure blackKing = new Figure(scanner.nextInt(), scanner.nextInt());
        Figure whiteKing = new Figure(scanner.nextInt(), scanner.nextInt());
        Figure whiteQueen = new Figure(scanner.nextInt(), scanner.nextInt());
        Figure whiteBishop = new Figure(scanner.nextInt(), scanner.nextInt());
        Figure whiteKnight = new Figure(scanner.nextInt(), scanner.nextInt());

        boolean whetherThereIsAMate;


    }

    /**
     * to check whether there is a checkmate with these 5 figures
     *
     * @param blackKing   the only black figure
     * @param whiteKing   of chess
     * @param whiteQueen  of chess
     * @param whiteBishop of chess
     * @param whiteKnight of chess
     */
    public static boolean checkForAMate(Figure blackKing, Figure whiteKing, Figure whiteQueen,
                                        Figure whiteBishop, Figure whiteKnight) {
        final int blackKingX = blackKing.x;
        final int blackKingY = blackKing.y;

        /*check for the place of white king*/
        for (int i = blackKingX - 1; i < blackKingX + 2; i++) {
            if (whiteKing.y == blackKingY - 1 || whiteKing.y == blackKingY || whiteKing.y == blackKingY + 1) {
                return true;
            }
        }

        /*check for the place of white queen*/


        return false;
    }
}