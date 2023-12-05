import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int userScore;
    private Timer timer;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.userScore = 0;
        this.timer = new Timer();
    }

    public void startQuiz() {
        System.out.println("Welcome to the Quiz!\n");

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Moving to the next question.\n");
                nextQuestion();
            }
        }, 20000, 20000); 

        presentQuestion(questions.get(currentQuestionIndex));
    }

    private void presentQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());

        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        getUserAnswer(question);
    }

    private void getUserAnswer(QuizQuestion question) {
        Scanner scanner = new Scanner(System.in);
        int userAnswer;

        do {
            System.out.print("Your answer (1-" + question.getOptions().size() + "): ");
            userAnswer = scanner.nextInt();
        } while (userAnswer < 1 || userAnswer > question.getOptions().size());

        checkAnswer(question, userAnswer - 1); // Convert to 0-based index
    }

    private void checkAnswer(QuizQuestion question, int userAnswerIndex) {
        if (userAnswerIndex == question.getCorrectOptionIndex()) {
            System.out.println("Correct!\n");
            userScore++;
        } else {
            System.out.println("Incorrect. The correct answer is: " +
                    question.getOptions().get(question.getCorrectOptionIndex()) + "\n");
        }

        nextQuestion();
    }

    private void nextQuestion() {
        currentQuestionIndex++;

        if (currentQuestionIndex < questions.size()) {
            if (currentQuestionIndex == questions.size() - 1) {
                
                timer.cancel();
            }

            if (currentQuestionIndex < questions.size()) {
                System.out.println("Next question:");
                presentQuestion(questions.get(currentQuestionIndex));
            }
        } else {
            displayResult();
        }
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + userScore + "/" + questions.size());

        System.out.println("Correct/Incorrect Answers:");

        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion q = questions.get(i);
            String status = (i == userScore) ? "Correct" : "Incorrect";
            System.out.println("Q" + (i + 1) + ": " + status);
        }
    }
}

public class QuizApp {
    public static void main(String[] args) {
        
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?", List.of("Berlin", "Madrid", "Paris", "Rome"), 2));
        questions.add(new QuizQuestion("Which planet is known as the Red Planet?", List.of("Mars", "Venus", "Jupiter", "Saturn"), 0));
        questions.add(new QuizQuestion("What is the largest mammal?", List.of("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 1));

        
        Quiz quiz = new Quiz(questions);

        
        quiz.startQuiz();
    }
}
