package AlgorithmsAndDatastructures.Recursion;

public class RecursionExamples {

    public static void main(String[] args) {
        iterPrint(5);
        System.out.println();

        recurPrint(5);
        System.out.println();

        System.out.println(power(5, 2));
        System.out.println(powerRec(5, 2));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("%5d", routes(i, j));
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(routes(4, 5));
        System.out.println();

        int[][] desk = new int[8][8];
        knightMove(desk, 1, 0, 1);
        printDesk(desk);
        System.out.println();

        queens(1);
        printBoard();
    }

    private static void iterPrint(int i) {
        while (i >= 0) {
            System.out.print(i + " ");
            i--;
        }
        System.out.print(i + "h");
    }

    private static void recurPrint(int i) {
        if (i >= 0) {
            System.out.print(i + " ");
            recurPrint(--i);
        }
        System.out.print(i + "h ");
    }

    private static int power(int number, int power) {
        int res = 1;
        for (int i = 0; i < power; i++) {
            res *= number;
        }
        return res;
    }

    private static int powerRec(int number, int power) {
        return (power == 0) ? 1 : powerRec(number, power - 1) * number;
    }

    // Задачка king routes – обход королем
    private static int routes(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        } else {
            return routes(x - 1, y) + routes(x, y - 1);
        }
    }

    // Задачка chess knight – обход конём
    // варианты ходов коня
    private static int[][] kMoves = {
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };

    // проверка на пустоту
    private static boolean isPossible(int[][] desk, int x, int y) {
        return x >= 0 && x < desk.length &&
                y >= 0 && y < desk[0].length &&
                desk[x][y] == 0;
    }

    // сам алгоритм
    private static boolean knightMove(int[][] desk, int currentX, int currentY, int moveNum) {
        desk[currentX][currentY] = moveNum;
        if (moveNum > desk.length * desk[0].length - 1) return true; // последний ли был это ход

        int nextX, nextY;
        for (int i = 0; i < 7; i++) {
            nextX = currentX + kMoves[i][1];
            nextY = currentY + kMoves[i][0];
            if (isPossible(desk, nextX, nextY) && knightMove(desk, nextX, nextY, moveNum + 1)) { // если следующий ход возможен, то мы его делаем
                return true;
            }
        }
        desk[currentX][currentY] = 0;
        return false;
    }

    private static void printDesk(int[][] desk) {
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[0].length; j++) {
                System.out.printf("%3d", desk[i][j]);
            }
            System.out.println();
        }
    }

    // 8 queens board
    private static int[][] board = new int[8][8];

    // main algorithm
    /**
     * @param n - place first queen
     */
    private static boolean queens(int n) {
        if (!checkBoard()) return false; // если никто никого не бьет, значит все ок
        if (n == 9) return true; // условие выхода из рекурсии. Если ставим 9 ферзя, значит все ок
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = n;
                    if (queens(n + 1)) return true;
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    // checks if queen hits someone
    private static boolean checkQueen(int x, int y) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 0) {
                    if (!(i == x && j == y)) {
                        if (i - x == 0 || j - y == 0) return false;
                        if (Math.abs(i - x) == Math.abs(j - y)) return false;
                    }
                }
            }
        }
        return true;
    }

    // checks if field is taken (!=0) then we check if queen hits someone else
    private static boolean checkBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 0) {
                    if (!checkQueen(i, j)) return false;
                }
            }
        }
        return true;
    }

    // prints board for 8 queens
    private static void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // hanoi tower
    private static int operations = 0;

    private static void put(int from, int to) {
        System.out.printf("%d -> %d | ", from, to);
        if (++operations % 10 == 0) System.out.print('\n');
    }

    private static void tower(int height, int from, int to) {
        int temp = from ^ to; // 1^2=3; 1^3=2; 2^3=1
        if (height == 1) {
            put(from, to);
        } else {
            tower(height - 1, from, temp);
            put (from, to);
            tower(height - 1, temp, to);
        }
    }
}
