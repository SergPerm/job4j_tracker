package ru.job4j.stream;

public class Dog {
    private String name;
    private String titleName;
    private byte age;
    private float weight;
    private String color;
    private Human own;
    private String gender;

    static class Builder {
        private String name;
        private String titleName;
        private byte age;
        private float weight;
        private String color;
        private Human own;
        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildTitleName(String titleName) {
            this.titleName = titleName;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildWeight(float weight) {
            this.weight = weight;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildOwn(Human own) {
            this.own = own;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Dog build() {
            Dog dog = new Dog();
            dog.name = name;
            dog.titleName = titleName;
            dog.age = age;
            dog.color = color;
            dog.own = own;
            dog.gender = gender;
            dog.weight = weight;
            return dog;
        }
    }

    @Override
    public String toString() {
        return "Dog{"
                + "name='" + name + '\''
                + ", titleName='" + titleName + '\''
                + ", age=" + age
                + ", weight=" + weight
                + ", color='" + color + '\''
                + ", own=" + own
                + ", gender='" + gender + '\''
                + '}';
    }

    public static void main(String[] args) {
        Dog dog = new Builder()
                .buildName("charly")
                .buildTitleName("charly Marya Antuanetta")
                .buildAge((byte) 2)
                .buildGender("m")
                .buildWeight(3.5f)
                .buildColor("grey")
                .buildOwn(new Human("Marya"))
                .build();
        System.out.println(dog);
    }
}
