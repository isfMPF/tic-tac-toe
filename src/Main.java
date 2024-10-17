import java.util.Scanner;

public class Main {

    static Scanner in = null;
    public static int p1Cor1;
    public static int p1Cor2;
    public static int p2Cor1;
    public static int p2Cor2;
    public static String player1;
    public static String player2;
    public static char[][] board;

    public static void main(String[] args) {

        in = new Scanner(System.in);
        System.out.print("Игрок 1, вводите своё имя: ");
        player1 = in.nextLine();
        System.out.print("Игрок 2, вводите своё имя: ");
        player2 = in.nextLine();

        boolean isPlayer1 = true;

        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        drawBoard(board);


        while (true) {
            if (isPlayer1) {
                inputDataPlayer1();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == 'x' || board[i][j] == 'o') {
                            continue;
                        }
                        if (i == p1Cor1 - 1 && j == p1Cor2 - 1) {
                            board[i][j] = 'x';
                        } else {
                            board[i][j] = '-';
                        }
                    }
                }

                isPlayer1 = false;

            } else {
                inputDataPlayer2();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == 'x' || board[i][j] == 'o') {
                            continue;
                        }
                        if (i == p2Cor1 - 1 && j == p2Cor2 - 1) {
                            board[i][j] = 'o';
                        } else {
                            board[i][j] = '-';
                        }

                    }
                }

                isPlayer1 = true;
            }
            drawBoard(board);
        }
    }

    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void inputDataPlayer1() {
        do {
            System.out.print(player1 + " ваш ход (x). Вводите первую координату (1, 2, 3): ");
            p1Cor1 = in.nextInt();
            System.out.print(player1 + " ваш ход (x). Вводите вторую координату (1, 2, 3): ");
            p1Cor2 = in.nextInt();

            if (p1Cor1 < 1 || p1Cor1 > 3 || p1Cor2 < 1 || p1Cor2 > 3) {
                System.out.println("Координаты должны быть от 1 до 3. Введите заново.");
                continue;
            }


            if (board[p1Cor1 - 1][p1Cor2 - 1] == 'x' || board[p1Cor1 - 1][p1Cor2 - 1] == 'o') {
                System.out.println("Ячейка занята. Вводите заново координаты.");
            } else {
                break;
            }
        } while (true);

    }

    public static void inputDataPlayer2() {
        do {
            System.out.print(player2 + " ваш ход (0). Вводите первую координату (1,2,3): ");
            p2Cor1 = in.nextInt();
            System.out.print(player2 + " ваш ход (0). Вводите вторую координату (1,2,3): ");
            p2Cor2 = in.nextInt();
            if (p2Cor1 < 1 || p2Cor1 > 3 || p2Cor2 < 1 || p2Cor2 > 3) {
                System.out.println("Координаты должны быть от 1 до 3. Введите заново.");
                continue;
            }
            if(board[p2Cor1 - 1][p2Cor2 - 1] == 'x' || board[p2Cor1 - 1][p2Cor2 - 1] == 'o'){
                System.out.println("Ячейка занята. Вводите заново координаты");
            }else {
                break;
            }
        }while (true);

    }
}