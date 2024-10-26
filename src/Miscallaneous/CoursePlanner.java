package Miscallaneous;

import java.util.*;

public class CoursePlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> courses = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",\\s+")));

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("course start")) {
                // Print course list with numbering
                for (int i = 0; i < courses.size(); i++) {
                    int current = i + 1;
                    System.out.printf("%d.%s%n", current, courses.get(i));
                }
                break;
            } else {
                String[] inputParts = input.split(":");
                String command = inputParts[0];
                String lesson = inputParts[1];

                switch (command.toLowerCase()) {
                    case "add": {
                        // Add lesson at the end if it does not exist already
                        if (!courses.contains(lesson)) {
                            courses.add(lesson);
                        }
                        break;
                    }
                    case "insert": {
                        // Add lesson at index if it does not exist already
                        int index = Integer.parseInt(inputParts[2]);
                        if (!courses.contains(lesson)) {
                            courses.add(index, lesson);
                        }
                        break;
                    }
                    case "remove": {
                        // Remove lesson if it exists
                        if (courses.contains(lesson)) {
                            courses.remove(lesson);
                            // Remove the associated exercise, if it exists
                            String exercise = lesson + "-Exercise";
                            courses.remove(exercise);
                        }
                        break;
                    }
                    case "swap": {
                        // Swap two lessons if they exist
                        String lesson2 = inputParts[2];
                        if (courses.contains(lesson) && courses.contains(lesson2)) {
                            int index1 = courses.indexOf(lesson);
                            int index2 = courses.indexOf(lesson2);
                            // Swap the lessons
                            courses.set(index1, lesson2);
                            courses.set(index2, lesson);
                            // Also swap exercises if they exist
                            String exercise1 = lesson + "-Exercise";
                            String exercise2 = lesson2 + "-Exercise";
                            if (courses.contains(exercise1)) {
                                courses.remove(exercise1);
                                courses.add(index2 + 1, exercise1);
                            }
                            if (courses.contains(exercise2)) {
                                courses.remove(exercise2);
                                courses.add(index1 + 1, exercise2);
                            }
                        }
                        break;
                    }
                    case "exercise": {
                        // Add Exercise after the lesson if it exists and no exercise already
                        String exercise = lesson + "-Exercise";
                        if (courses.contains(lesson)) {
                            int lessonIndex = courses.indexOf(lesson);
                            if (!courses.contains(exercise)) {
                                courses.add(lessonIndex + 1, exercise);
                            }
                        } else {
                            // If the lesson does not exist, add the lesson and its exercise at the end
                            courses.add(lesson);
                            courses.add(exercise);
                        }
                        break;
                    }
                }
            }
        }
    }
}

