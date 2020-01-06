import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private static final int CHECKPOINT_NUM = 3;
    private static final String QUESTIONS_FILE = "questions.txt";
    private static final String QUIZ_FILE = "quiz.txt";

    private static final String INTRO_TEXT1 = "\nQuiz Checkpoint %d\n";
    private static final String INTRO_TEXT2 = "\nN'utilise que ta mémoire pour répondre aux %d questions.";
    private static final String INTRO_TEXT3 = "\nPas de soucis si tu te trompes sur une question, tu pourras éditer le fichier `%s` à la fin.\n";
    private static final String ANSWER_TEXT1 = "\nRéponse : ";
    private static final String OUTRO_TEXT1 = "\nLe fichier %s a été généré, tu peux l'éditer manuellement si tu souhaites le corriger.\n";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get(QUIZ_FILE);

        ArrayList<String> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(QUESTIONS_FILE))) {
            while (br.ready()) {
                questions.add(br.readLine());
            }

            System.out.printf(INTRO_TEXT1, CHECKPOINT_NUM);
            System.out.printf(INTRO_TEXT2, questions.size());
            System.out.printf(INTRO_TEXT3, QUIZ_FILE);

            try (BufferedWriter init = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                init.close();

                for (int i = 0; i < questions.size(); i++) {
                    try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                            StandardOpenOption.APPEND)
                    ) {
                        String question = String.format("%d. %s", i + 1, questions.get(i));
                        System.out.print("\n" + question);
                        System.out.print(ANSWER_TEXT1);
                        String answer = scanner.nextLine();

                        writer.write(question + "\n" + answer + "\n\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.out.printf(OUTRO_TEXT1, QUIZ_FILE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}