package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(nl::getMap)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkMessage() {
        NameLoad nl = new NameLoad();
        assertThatThrownBy(nl::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }

    @Test
    void whenDoesNotContainSymbol() {
        NameLoad nl = new NameLoad();
        String word = "name";
        assertThatThrownBy(() -> nl.parse(word))
                .isNotInstanceOf(IllegalStateException.class)
                .hasMessageMatching("this name: name does not contain the symbol \"=\"")
                .hasMessageContaining(word)
                .hasMessageContaining("=");
    }

    @Test
    void whenStratsWithSymbolAndIndexdOfEqualToTheLength() {
        NameLoad nl = new NameLoad();
        String word = "=";
        assertThatThrownBy(() -> nl.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("this name: = does not contain a key")
                .hasMessageContaining(word)
                .hasMessageContaining("=");
    }
}