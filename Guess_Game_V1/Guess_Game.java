package Guess_Game_V1;

public class Guess_Game {
    protected Player p1;
    protected Player p2;
    protected Player p3;

    public void startGame () {
        p1 = new Player(); // создаем 3 объекта Guess_Game_V1.Player
        p2 = new Player(); // и присваиваем их трем переменным экземпляра
        p3 = new Player();

        int guessPlayer1 = 0; // объявляем 3 переменные
        int guessPlayer2 = 0; // для хранения вариантов
        int guessPlayer3 = 0; // от каждого игрока

        boolean player1IsRight = false; // объявляем 3 переменные
        boolean player2IsRight = false; // для хранения правильности
        boolean player3IsRight = false; // и неправильности ответов

        int numberToGuess = (int) (Math.random() * 10); // создаем число которое нужно угадать
        System.out.println("Я загадываю число от 0 до 9...");

        while (true) {
            System.out.println("Число которое нужно угадать, - " + numberToGuess);

            p1.guess();
            p2.guess();
            p3.guess();

            /**
             * извлекаем варианты каждого игрока (результаты работы их методов guess()),
             * получая доступ к их переменным number
             */
            guessPlayer1 = p1.number;
            System.out.println("Первый игрок думает, что это " + guessPlayer1);

            guessPlayer2 = p2.number;
            System.out.println("Второй игрок думает, что это " + guessPlayer2);

            guessPlayer3 = p3.number;
            System.out.println("Третий игрок думает, что это " + guessPlayer3);

            if (guessPlayer1 == numberToGuess) {
                player1IsRight = true;
            }
            if (guessPlayer2 == numberToGuess) {
                player2IsRight = true;
            }
            if (guessPlayer3 == numberToGuess) {
                player3IsRight = true;
            }
            if (player1IsRight || player2IsRight || player3IsRight) {
                System.out.println("У нас есть победитель!");
                System.out.println("Первый игрок угадал " + player1IsRight);
                System.out.println("Второй игрок угадал " + player2IsRight);
                System.out.println("Третий игрок угадал " + player3IsRight);
                break; // игра окончена, так что прерываем цикл
            } else {
                System.out.println("Игроки должны попробовать еще раз!");
            }
        }
    }
}