package ExamPreparation._03may2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ChessKnight {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[8][8];
        List<Character> capturedPieces = new LinkedList<>();
        readBoard(reader, board);
        int invalidMoves = 0;
        int outsideBoard = 0;

        String startPosition = reader.readLine();

        String line;
        while (!"END".equals((line = reader.readLine()))) {

            String[] move = line.split(" -> ");

            String[] origin = move[0].split("");
            int originRow = Integer.parseInt(origin[0]);
            int originCol = Integer.parseInt(origin[1]);

            String[] destination = move[1].split("");
            int destRow = Integer.parseInt(destination[0]);
            int destCol = Integer.parseInt(destination[1]);

            if (isValidKnightMove(originCol, originRow, destRow, destCol)) {

                if (moveIsInsideBoard(destRow, destCol)) {

                    if (capturedPiece(board, destRow, destCol)) {

                        capturedPieces.add(board[destRow][destCol]);
                        board[destRow][destCol] = ' ';
                    }
                }
                else{
                    outsideBoard++;
                }
            }
            else{
                invalidMoves++;
            }
        }
        System.out.printf("Pieces take: %s%n", capturedPieces.toString().replaceAll("[\\[\\]]", ""));
        System.out.printf("Invalid moves: %d%n", invalidMoves);
        System.out.printf("Board out moves: %d%n", outsideBoard);
    }

    private static boolean capturedPiece(char[][] board, int destRow, int destCol) {

        if (board[destRow][destCol] != ' '){
            return  true;
        }
        return false;
    }

    private static boolean moveIsInsideBoard(int destRow, int destCol) {

        if (destRow >= 0 && destRow <= 7 && destCol >= 0 && destCol <= 7) {
            return true;
        }
        return false;
    }

    private static boolean isValidKnightMove(int originCol, int originRow, int destRow, int destCol) {

        if (
                (destRow == originRow - 2 && destCol == originCol + 1) ||
                        (destRow == originRow - 1 && destCol == originCol + 2) ||
                        (destRow == originRow + 1 && destCol == originCol + 2) ||
                        (destRow == originRow + 2 && destCol == originCol + 1) ||

                        (destRow == originRow + 2 && destCol == originCol - 1) ||
                        (destRow == originRow + 1 && destCol == originCol - 2) ||
                        (destRow == originRow - 1 && destCol == originCol - 2) ||
                        (destRow == originRow - 2 && destCol == originCol - 1)
        ) {

            return true;
        }
        return false;
    }

    private static void readBoard(BufferedReader reader, char[][] board) throws IOException {
        for (int i = 0; i < 8; i++) {

            String row = reader.readLine();
            row = row.replaceAll("\\|", "");
            char[] currentRow = row.toCharArray();
            board[i] = currentRow;

        }
    }
}
