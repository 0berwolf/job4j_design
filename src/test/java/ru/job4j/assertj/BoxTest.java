package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 4);
        String name = box.whatThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 6);
        String name = box.whatThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isEqualTo("Cube");
    }

    @Test
    void howNumberOfVerticesToTetrahedron() {
        Box box = new Box(4, 4);
        int number = box.getNumberOfVertices();
        assertThat(number).isGreaterThan(3)
                .isLessThan(5);
    }

    @Test
    void howNumberOfVerticesToCube() {
        Box box = new Box(8, 6);
        int number = box.getNumberOfVertices();
        assertThat(number).isGreaterThan(7)
                .isLessThan(9);
    }

    @Test
    void checkToAreaToSphere() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isCloseTo(1256.63d, withPrecision(0.01d))
                .isGreaterThan(1256.63d)
                .isLessThan(1256.64d);
    }

    @Test
    void checkToAreaToCube() {
        Box box = new Box(8, 6);
        double area = box.getArea();
        assertThat(area).isEqualTo(216d, withPrecision(0.003d))
                .isGreaterThan(215.9d)
                .isLessThan(216.3);
    }

    @Test
    void isExistTetrahedron() {
        Box box = new Box(4, 4);
        boolean rsl = box.isExist();
        assertThat(rsl).isEqualTo(true)
                .isTrue();
    }

    @Test
    void isNotExistCube() {
        Box box = new Box(7, 5);
        boolean rsl = box.isExist();
        assertThat(rsl).isEqualTo(false)
                .isFalse();
    }
}