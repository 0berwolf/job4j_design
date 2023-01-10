package ru.job4j.generics;

public class Tiger extends Predator {
    public Tiger(String sound, String eat, int sleap) {
        super(sound, eat, sleap);
    }

    @Override
    public String toString() {
        return "Tiger{"
                + "sound='" + super.getSound() + '\''
                + "eat='" + super.getEat() + '\''
                + "sleap='" + super.getSleap()
                + '}';
    }
}
