package ru.job4j.generics;

public class Predator extends Animal{
    public Predator(String sound, String eat, int sleap) {
        super(sound, eat, sleap);
    }

    @Override
    public String toString() {
        return "Predator{"
                + "sound='" + super.getSound() + '\''
                + "eat='" + super.getEat() + '\''
                + "sleap='" + super.getSleap()
                + '}';
    }
}
