public class QuestionGrader {

    public abstract static class Question {
        String questionText;
        int maxMarks;

        public Question(String questionText, int maxMarks) {
            this.questionText = questionText;
            this.maxMarks = maxMarks;
        }

        public abstract int grade(String studentAnswer);
    }

    public static class MultipleChoiceQuestion extends Question {
        String correctAnswer;

        public MultipleChoiceQuestion(String text, int marks, String correctAnswer) {
            super(text, marks);
            this.correctAnswer = correctAnswer;
        }

        @Override
        public int grade(String studentAnswer) {
            return correctAnswer.equalsIgnoreCase(studentAnswer.trim()) ? maxMarks : 0;
        }
    }

    public static class EssayQuestion extends Question {
        int minWords;

        public EssayQuestion(String text, int marks, int minWords) {
            super(text, marks);
            this.minWords = minWords;
        }

        @Override
        public int grade(String studentAnswer) {
            int words = studentAnswer.trim().split("\\s+").length;
            return words >= minWords ? maxMarks : (maxMarks / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Examination Question Grader ===");
        Question q1 = new MultipleChoiceQuestion("Capital of India?", 5, "New Delhi");
        Question q2 = new EssayQuestion("Explain OOP concepts.", 10, 5);

        int s1 = q1.grade("New Delhi");
        int s2 = q2.grade("OOP stands for Object Oriented Programming with classes.");

        System.out.println("MCQ Score: " + s1);
        System.out.println("Essay Score: " + s2);
        System.out.println("Total Score: " + (s1 + s2));
    }
}
