package br.com.kelvin.java19spring3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListSetTest {

    @Test
    public void testListSet() {
        final MyObject myObject = new MyObject("1");

        final List<Object> list = new ArrayList<>();
        list.add(myObject);
        list.add(myObject);

        Assertions.assertEquals(2, list.size());

        final Set<Object> set = new HashSet<>();

        set.add(myObject);
        set.add(myObject);

        final Set<Integer> setOfInt = new HashSet<>();
        setOfInt.add(1);
        setOfInt.add(1);

        Assertions.assertEquals(1, set.size());
    }

    @AllArgsConstructor
    @Getter
    static class MyObject {
        private String id;
    }
}
