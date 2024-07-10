import java.util.*;

class TASK3 {
    private static final int TIME_LIMIT = 10; 
    private static final List<Question> questions = Arrays.asList(
        new Question("What is the capital of India?", 
                     Arrays.asList("A. chennai", "B. Mumbai", "C. Delhi", "D. Hyderabad"), 
                     'C'),
        new Question("Who is famous hero'?", 
                     Arrays.asList("A. Prabhas", "B. Mahesh Babu", "C. RamCharan", "D.NTR"), 
                     'B'),
        new Question("What is the smallest prime number?", 
                     Arrays.asList("A. 0", "B. 1", "C. 2", "D. 3"), 
                     'C')
    );
    private static int score = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (Question question : questions) {
            boolean answeredCorrectly = askQuestion(question, sc);
            if (answeredCorrectly) {
                score++;
            }
        }

        displayResult();
        sc.close();
    }

    private static boolean askQuestion(Question question, Scanner sc) {
        System.out.println(question.getQuestion());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\nTime's up!");
                sc.nextLine(); 
            }
        };
        
        timer.schedule(task, TIME_LIMIT * 1000);
        System.out.println("You have " + TIME_LIMIT + " seconds to answer:");
        
        long startTime = System.currentTimeMillis();
        String answer = sc.nextLine().trim().toUpperCase();
        long elapsedTime = System.currentTimeMillis() - startTime;

        timer.cancel();
        
        if (elapsedTime > TIME_LIMIT * 1000) {
            System.out.println("You ran out of time!");
            return false;
        }

        return answer.equals(String.valueOf(question.getCorrectAnswer()));
    }

    private static void displayResult() {
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + "/" + questions.size());
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println((i + 1) + ". " + question.getQuestion());
            System.out.println("Correct answer: " + question.getCorrectAnswer());
        }
    }
}

class Question {
    private final String question;
    private final List<String> options;
    private final char correctAnswer;

    public Question(String question, List<String> options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}
