package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Set<User> addedVsChanged = new HashSet<>(current);
        addedVsChanged.removeAll(previous);
        HashMap<Integer, User> addedVsChangedMap = new HashMap<>();
        for (User user: addedVsChanged) {
            addedVsChangedMap.put(user.getId(), user);
        }
        int changed = 0;
        int added = addedVsChanged.size();
        Set<User> deletedVsChanged = new HashSet<>(previous);
        deletedVsChanged.removeAll(current);
        for (User dVCh: deletedVsChanged) {
            if (addedVsChangedMap.containsKey(dVCh.getId())) {
                changed++;
                added--;
            }
        }
        int deleted = deletedVsChanged.size() - changed;
        return new Info(added, changed, deleted);
    }
}
