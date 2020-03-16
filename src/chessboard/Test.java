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

        System.out.println(checkForAMate(blackKing, whiteKing, whiteQueen, whiteBishop, whiteKnight)
                ? "there is a checkmate" : "there isn't a checkmate");

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

        /*check for the place of white king,
         * not to be near the black king*/
        for (int i = blackKingX - 1; i < blackKingX + 2; i++) {
            if (whiteKing.y == blackKingY - 1 || whiteKing.y == blackKingY || whiteKing.y == blackKingY + 1) {
                return true;
            }
        }

        /*check for the place of white queen,
         * not to be on the diagonals, verticals and horizontals of the black king*/
        //vertical and horizontal
        if (whiteQueen.y == blackKingY || whiteQueen.x == blackKingX) {
            return true;
        }
        /*check for the place of both queen and white bishop,
         * not to be on the diagonals of the black king*/
        //diagonal
        for (int i = 1; i < blackKingX; i++) {
            if (whiteQueen.x == blackKingX - i &&
                    (whiteQueen.y == blackKingY - i || whiteQueen.y == blackKingY + i)) {
                return true;
            }
            if (whiteBishop.x == blackKingX - i &&
                    (whiteBishop.y == blackKingY - i || whiteBishop.y == blackKingY + i)) {
                return true;
            }
        }
        for (int i = 1; i < 9 - blackKingX; i++) {
            if (whiteQueen.x == blackKingX + i &&
                    (whiteQueen.y == blackKingY - i || whiteQueen.y == blackKingY + i)) {
                return true;
            }
            if (whiteBishop.x == blackKingX + i &&
                    (whiteBishop.y == blackKingY - i || whiteBishop.y == blackKingY + i)) {
                return true;
            }
        }

        /*check for place of knight,
         * not to be on the places drawn with Г from the black king*/
        for (int i = 1, j = 2; i < 3; i++, j--) {
            if (whiteKnight.x == blackKingX - j &&
                    (whiteKnight.y == blackKingY - i || whiteKnight.y == blackKingY + i)) {
                return true;
            }
            if (whiteKnight.x == blackKingX + j &&
                    (whiteKnight.y == blackKingY - i || whiteKnight.y == blackKingY + i)) {
                return true;
            }
        }

        return false;
    }
}