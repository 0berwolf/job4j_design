package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username")).isEqualTo("postgres");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("#User")).isEqualTo(null);
        assertThat(config.value("hibernate.connection.password")).isEqualTo("password");
    }

    @Test
    void throwNewIllegalException2() {
        String path = "./data/throw_exception.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class);
    }
}