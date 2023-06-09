package org.example;

import org.assertj.core.api.Assertions;
import org.example.meet.Person;
import org.example.meet.Point;
import org.example.meet.Solution;
import org.example.meet.TeacherSolution;
import org.junit.jupiter.api.Test;

class SolutionTest {

    TestUtil testUtil = new TestUtil();
    Solution s = new Solution();

    @Test
    void testUtilTest3() throws Exception{
        int age1 = testUtil.run(new Person(), "getAge"); // 10 이 리턴됨
        int age2 = testUtil.run(new Person(), "getAge", 10); // 20 이 리턴됨
        int age3 = testUtil.run(new Person(), "getAge", 10, 20); // 40 이 리턴됨
        int age4 = testUtil.run(new Person(), "getAge", "100"); // 110 이 리턴됨
        String name1 = testUtil.run(new Person(), "getName"); // "폴" 리턴
        String name2 = testUtil.run(new Person(), "getName", "님"); // "폴님" 리턴
        Person me = testUtil.run(new Person(), "getMe"); // person 객체가 리턴

        Assertions.assertThat(age1).isEqualTo(10);
        Assertions.assertThat(age2).isEqualTo(20);
        Assertions.assertThat(age3).isEqualTo(40);
        Assertions.assertThat(age4).isEqualTo(110);
        Assertions.assertThat(name1).isEqualTo("폴");
        Assertions.assertThat(name2).isEqualTo("폴님");
        Assertions.assertThat(me).isOfAnyClassIn(Person.class);
    }

    @Test
    void testUtilTest2() throws Exception {
        Point normalCall = new TeacherSolution().intersection(
                new int[]{1, -1, 0},
                new int[]{2, -1, 0}
        );

        Point reflection = testUtil.run(
                new TeacherSolution(),
                "intersection",
                new int[]{1, -1, 0},
                new int[]{2, -1, 0}
        );

        Assertions.assertThat(normalCall).isEqualTo(reflection);
    }

    @Test
    void testUtilTest() throws Exception {
        int[][] line = {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
        };
        Assertions.assertThat((String[]) testUtil.run(s, "solution", (Object) line))
                .containsExactly("....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*");
    }

    @Test
    void test() {
        int[][] line = {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
        };
        Assertions.assertThat(s.solution(line))
                .containsExactly("....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*");
    }

    @Test
    void test2() {
        int[][] line = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 0, 1},
        };
        Assertions.assertThat(s.solution(line))
                .containsExactly("*.*");

    }

    @Test
    void test3() {
        int[][] line = {
                {1, -1, 0},
                {2, -1, 0},
        };
        Assertions.assertThat(s.solution(line))
                .containsExactly("*");

    }

    @Test
    void test4() {
        int[][] line = {
                {1, -1, 0},
                {2, -1, 0},
                {4, -1, 0},
        };
        Assertions.assertThat(s.solution(line))
                .containsExactly("*");

    }
}