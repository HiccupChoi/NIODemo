package com.practice.matrix;

import java.util.HashMap;

/**
 * testHashMap
 *
 * @author chen
 */
public class TestHashMap {

    static class TestClass {
        private int a;
        private int b;

        public TestClass(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestClass testClass = (TestClass) o;
            return a == testClass.a &&
                    b == testClass.b;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
    public static void main(String[] args) {
        HashMap map = new HashMap();
        TestClass a = new TestClass(1,2);
        TestClass b = new TestClass(1,3);
        TestClass c = new TestClass(1,4);
        map.put(a, 1);
        map.put(b, 1);
        map.put(c, 1);
        System.out.println("x");
    }

}