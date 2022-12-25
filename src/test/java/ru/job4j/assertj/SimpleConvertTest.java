package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert sc = new SimpleConvert();
        String[] array = sc.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert sc = new SimpleConvert();
        List<String> exp = sc.toList("first", "second", "three", "four", "five");
        assertThat(exp).first().isEqualTo("first");
        assertThat(exp).element(0).isNotNull().isEqualTo("first");
        assertThat(exp).last().isNotNull().isEqualTo("five");

    }

    @Test
    void checkSet() {
        SimpleConvert sc = new SimpleConvert();
        Set<String> exp = sc.toSet("first", "second", "three", "four", "five");
        assertThat(exp).hasSize(5)
                .contains("four")
                .contains("first", "five", "four", "three")
                .containsAnyOf("five", "minus one", "nineteen");
    }

    @Test
    void checkMap() {
        SimpleConvert sc = new SimpleConvert();
        Map<String, Integer> exp = sc.toMap("first", "second", "three", "four", "five");
        assertThat(exp).hasSize(5)
                .containsKeys("five", "first", "three")
                .doesNotContainKey("nine")
                .isNotEmpty();
    }
}