package stream.collectors;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class DownStreamMain1 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Han", 2, 73),
                new Student("Lee", 2, 92),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        // 1단계: 학년별로 학생들을 그룹화 한다.
        Map<Integer, List<Student>> grouped1 = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        toList()
                ));
        System.out.println("grouped1 = " + grouped1);

        // toList() 는 생략 가능
        Map<Integer, List<Student>> grouped2 = students.stream()
                .collect(groupingBy(Student::getGrade));
        System.out.println("grouped2 = " + grouped2);

        // 2단계: 학년 별로 학생들의 이름을 출력한다.
        Map<Integer, List<String>> grouped3 = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        mapping(Student::getName, toList())
                ));
        System.out.println("grouped3 = " + grouped3);

        // 3단계: 학년별로 학생들의 수를 출력해라.
        Map<Integer, Long> grouped4 = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        counting()
                ));
        System.out.println("grouped4 = " + grouped4);

        // 4단계: 학년별로 학생들의 평균 성적을 출력해라.
        Map<Integer, Double> grouped5 = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        averagingDouble(Student::getScore)
                ));
        System.out.println("grouped5 = " + grouped5);
    }
}
