package ru.job4j.generics;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenRoleIsFireman() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Fireman"));
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Fireman");
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Fireman"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    public void whenAddDuplicateAndFindRoleNameIsFireman() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Fireman"));
        store.add(new Role("1", "Mechanic"));
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Fireman");
    }

    @Test
    public void whenReplaceThenRoleNameIsMechanic() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Fireman"));
        store.replace("1", new Role("1", "Mechanic"));
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Mechanic");
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Mechanic"));
        store.replace("10", new Role("10", "Fireman"));
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Mechanic");
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Mechanic"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    public void whenNoDeleteRoleThenRoleNameIsMechanic() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Mechanic"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Mechanic");
    }
}