package stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class DownStreamMain2 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Han", 2, 73),
                new Student("Lee", 2, 92),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        // 1단계: 학년별로 학생들을 그룹화해라
        Map<Integer, List<Student>> grouped1 = students.stream()
                .collect(groupingBy(Student::getGrade));
        System.out.println("grouped1 = " + grouped1);

        // 2단계: 학년별로 가장 점수가 높은 학생을 구해라. reducing 사용
        Map<Integer, Optional<Student>> grouped2 = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        reducing((student, student2) -> {
                            if (student.getScore() < student2.getScore()) {
                                return student2;
                            }
                            return student;
                        })));
        System.out.println("grouped2 = " + grouped2);

        // 3단계: 학년별로 가장 점수가 높은 학생을 구해라. maxBy 사용
        Map<Integer, Optional<Student>> grouped3 = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        maxBy(Comparator.comparingInt(Student::getScore))
                ));
        System.out.println("grouped3 = " + grouped3);

        // 4단계: 학년별로 가장 점수가 높은 학생의 이름을 구해라 (collectingAndThen, maxBy 사용)
        Map<Integer, String> grouped4 = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        collectingAndThen(
                                maxBy(Comparator.comparingInt(Student::getScore)),
                                sOpt -> sOpt.get().getName()
                        )
                ));
        System.out.println("grouped4 = " + grouped4);
    }
}
