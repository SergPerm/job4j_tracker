package ru.job4j.oop;

import static java.lang.Math.*;

    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Point that) {
            return sqrt(pow(x - that.x, 2) + pow(y - that.y, 2));
        }

        public static void main(String[] args) {
            Point first = new Point(0, 0);
            Point second = new Point(3, 4);
            double result = first.distance(second);
            System.out.println("result (0, 0) to (3, 4) " + result);
        }
}
