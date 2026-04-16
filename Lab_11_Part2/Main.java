package Lab_11_Part2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Address add1 = new Address("500 E Broadway Ave", "Fairfield", "IA", 52556);
        Address add2 = new Address("103 W Adams Ave", "Fairfield", "IA", 52556);

        Section cs545_1 = new Section(900, "CS545");
        Section cs545_2 = new Section(901, "CS545");
        Section cs401 = new Section(902, "CS401");
        Section cs221 = new Section(903, "CS221");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(111, "Yasmeen", new ArrayList<>(Arrays.asList(3.9, 4.0, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs545_1, cs401))),
                new Student(112, "Mira", new ArrayList<>(Arrays.asList(4.0, 4.0, 3.9)), add1,
                        new ArrayList<>(Arrays.asList(cs545_2, cs401, cs221))),
                new Student(113, "Zaina", new ArrayList<>(Arrays.asList(3.6, 3.3, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs221, cs401))),
                new Student(114, "Khaled", new ArrayList<>(Arrays.asList(3.0, 2.8, 3.1)), add2)
        ));

        // 1.  Find all the students that are taking a given course
       List<String> names = students.stream()
                .filter(student ->
                        Optional.ofNullable(student.sections).orElse(new ArrayList<>()).stream()
                                .anyMatch(section -> section.getCourseCode().equals("CS401"))
                )
                .map(student -> student.getName())
                .collect(Collectors.toList());
        System.out.println("1) ");
        System.out.println(names);
        //2.   Get the address of any student that is taking a given course (e.g., "CS401")
                Optional<Address> address= students.stream()
                        .filter(student -> student.sections.stream()
                                .anyMatch(section->section.getCourseCode().equals("CS401"))
                        )
                        .map(student->student.address)
                        .findAny();
        System.out.println("2) ");
        System.out.println(address);
        //3. Calculate the GPA for a given student
              double totalGpa= students.get(0).grades.stream()
                      .reduce(0.0,(x,y)->x+y)/students.get(0).grades.size();
        System.out.println("3) ");
        System.out.println(totalGpa);
        // 4.Find the student with the highest GPA
            Optional<Student> topStudent=students.stream()
                    .max(Comparator.comparing(student -> student.grades.stream()
                                    .reduce(0.0,(x,y)->x+y)/student.grades.size()

                    ));
        System.out.println("4) ");
        System.out.println(topStudent);

        // 5. Get a list of all unique courses taken by students
        List<String> course = students.stream()
                .flatMap(student ->
                        Optional.ofNullable(student.sections)
                                .orElse(new ArrayList<>())
                                .stream()
                )
                .map(section -> section.getCourseCode())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("5) ");
        System.out.println(course);

        // 6. Find all students who live in a given city (e.g., "Fairfield") sorted in alphabetical order
        List<Student> studentInFairfield= students.stream()
                .filter(student -> student.address.getCity().equals("Fairfield"))
                .sorted(Comparator.comparing(student -> student.getName()))
                .collect(Collectors.toList());
        System.out.println("6) ");
        System.out.println(studentInFairfield);

        // 7. Count the number of students enrolled in a specific course (e.g., "CS401")
               long count=students.stream()
                       .filter(student -> Optional.ofNullable(student.sections)  // ← handles null safely
                               .orElse(new ArrayList<>()).stream()
                               .anyMatch(section -> section.getCourseCode().equals("CS401"))
                       )
                       .count();
        System.out.println("7) ");
        System.out.println(count);

        // 8. Get a list of students in a specific section
              List<Student> studentList=students.stream()
                      .filter(student -> Optional.ofNullable(student.sections)  // ← handles null safely
                              .orElse(new ArrayList<>()).stream()
                              .anyMatch(section -> section.getId()==900)
                      )
                      .collect(Collectors.toList());
        System.out.println("8) ");
        System.out.println(studentList);

        // 9.  Get the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)
                 List<String> namesOfS=students.stream()
                         .filter(student -> Optional.ofNullable(student.sections)  // ← handles null safely
                                 .orElse(new ArrayList<>()).size()>2)
                         .map(student -> student.getName())
                         .collect(Collectors.toList());
        System.out.println("9) ");
        System.out.println(namesOfS);

        // 10. Get a list of unique course names taken by students who live in a given city (e.g., "Fairfield")
                List<String> uniqueCourse=students.stream()
                        .filter(student -> student.address.getCity().equals("Fairfield"))
                        .flatMap(student -> Optional.ofNullable(student.sections)  // ← handles null safely
                                .orElse(new ArrayList<>()).stream())
                        .map(section -> section.getCourseCode())
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println("10) ");
        System.out.println(uniqueCourse);
        // 11 .Get a list of distinct addresses of students who are taking a specific course (e.g., "CS401")
                   List<Address> addresses=students.stream()
                           .filter(student -> Optional.ofNullable(student.sections)  // ← handles null safely
                                   .orElse(new ArrayList<>()).stream()
                                   .anyMatch(section -> section.getCourseCode().equals("CS401"))
                           )
                           .map(student -> student.address)
                           .distinct()
                           .collect(Collectors.toList());
        System.out.println("11) ");
        System.out.println(addresses);
        // 12. Get a mapping of students' names to the list of courses they are taking
        Map<String,List<String>> map=students.stream()
                .collect(Collectors.toMap(student -> student.getName(),student -> Optional.ofNullable(student.sections)  // ← handles null safely
                        .orElse(new ArrayList<>()).stream()
                        .map(section -> section.getCourseCode())
                        .collect(Collectors.toList())));
        System.out.println("12) ");
        System.out.println(map);

    }
}
