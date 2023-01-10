package ru.job4j.generics;

public class Animal {
    private String sound;
    private String eat;
    private int sleap;

    public Animal(String sound, String eat, int sleap) {
        this.sound = sound;
        this.eat = eat;
        this.sleap = sleap;
    }

    public String getSound() {
        return sound;
    }

    public String getEat() {
        return eat;
    }

    public int getSleap() {
        return sleap;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "sound='" + sound + '\''
                + ", eat='" + eat + '\''
                + ", sleap=" + sleap
                + '}';
    }
}
