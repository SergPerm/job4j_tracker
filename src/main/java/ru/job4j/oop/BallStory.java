package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Fox fox = new Fox();
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        hare.tryEat(ball);
        wolf.tryEat(ball);
        fox.tryEat(ball);
    }
}
