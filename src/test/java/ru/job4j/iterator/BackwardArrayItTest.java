package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class BackwardArrayItTest {
    @Test
    void whenMultiCallHasNextThenTrue() {
        BackwardArrayIt backwardArrayIt = new BackwardArrayIt(
                new int[] {1, 2, 3, 4});
        assertThat(backwardArrayIt.hasNext()).isTrue();
        assertThat(backwardArrayIt.hasNext()).isTrue();
        assertThat(backwardArrayIt.next()).isEqualTo(4);
        assertThat(backwardArrayIt.next()).isEqualTo(3);
        assertThat(backwardArrayIt.hasNext()).isTrue();
    }

    @Test
    void whenMultiCallHasNextThenNext() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(it.hasNext()).isTrue();
        assertThat(it.hasNext()).isTrue();
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo(3);

    }

    @Test
    void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(it.next()).isEqualTo(3);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void whenNextFromEmpty() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {}
        );
        assertThatThrownBy(it::next)
                .isInstanceOf(NoSuchElementException.class);
    }
}