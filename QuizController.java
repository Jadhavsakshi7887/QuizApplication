package com.console.QuizApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizController {

    static class Question {
        String question;
        List<String> options;
        int answerIndex;

        Question(String question, List<String> options, int answerIndex) {
            this.question = question;
            this.options = options;
            this.answerIndex = answerIndex;
        }
    }

    public static void startQuiz(List<Question> questions) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.question);
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ". " + q.options.get(j));
            }

            System.out.print("Your answer (1-" + q.options.size() + "): ");
            int userAnswer = scanner.nextInt() - 1;

            if (userAnswer == q.answerIndex) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + q.options.get(q.answerIndex) + "\n");
            }
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }

    public static void main(String[] args) {
        // Sample questions
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the capital of France?",
                List.of("Berlin", "Madrid", "Paris", "Rome"), 2));

        questions.add(new Question("What is the largest planet in our solar system?",
                List.of("Earth", "Mars", "Jupiter", "Saturn"), 2));

        questions.add(new Question("What is the chemical symbol for gold?",
                List.of("Au", "Ag", "Pb", "Fe"), 0));

        questions.add(new Question("Which language is primarily used for web development?",
                List.of("Python", "Java", "JavaScript", "C++"), 2));

        startQuiz(questions);
    }
}
