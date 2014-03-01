package big.java.chap9;
import java.util.Scanner;

/**
   This program shows a simple quiz with two question types.
*/
public class QuestionDemo3
{
   public static void main(String[] args)
   {
      QuestionVer3 first = new QuestionVer3();
      first.setText("Who was the inventor of Java?");
      first.setAnswer("James Gosling");      

      ChoiceQuestionVer3 second = new ChoiceQuestionVer3();
      second.setText("In which country was the inventor of Java born?");
      second.addChoice("Australia", false);
      second.addChoice("Canada", true);
      second.addChoice("Denmark", false);
      second.addChoice("United States", false);

      presentQuestion(first);
      presentQuestion(second);
   }

   /**
      Presents a question to the user and checks the response.
      @param q the question
   */
   public static void presentQuestion(QuestionVer3 q)
   {
      q.display();
      System.out.print("Your answer: ");
      Scanner in = new Scanner(System.in);
      String response = in.nextLine();
      System.out.println(q.checkAnswer(response));
   }
}

