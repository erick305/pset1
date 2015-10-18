
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main
{
    static String result = "";
    static int counter= 0;

    //creates mario pyramid with recursion.
    public static void createpyramid(int a)
    {
        counter++;
        if( a == 1)
        {
            counter = counter-1;
            for(int i=0; i < counter; i++)
            {
                result = result + " ";
            }
            result = result + "##";
            System.out.println(result);
            return;
        }

        createpyramid(a-1);

        result = result.substring(1) + "#";
        System.out.println(result);


    }

    //creates mario pyramid with recursion//ouput to file

    public static void createpyramid(int a, PrintWriter writerx)
    {
        counter++;
        if( a == 1)
        {
            counter = counter-1;
            for(int i=0; i < counter; i++)
            {
                result = result + " ";
            }
            result = result + "##";
            writerx.println(result);

            return;
        }

        createpyramid(a-1,writerx);

        result = result.substring(1) + "#";
        writerx.println(result);

    }
    public static void main(String[] args) {


        JFrame frame = new JFrame("InputDialog");

        // prompt the user to enter the number
        String n = JOptionPane.showInputDialog(frame, "Please enter an integer?");
        if(n == null)
        {
            System.out.println("You have canceled the program");
            System.exit(0);
        }
        else
        {
            while (!n.matches("^?\\d+$")) {
                n = JOptionPane.showInputDialog(frame, "Please enter an integer?");
                if(n == null)
                {
                    System.out.println("You have canceled the program");
                    System.exit(0);
                    break;
                }

            }

        }


        Object[] options = {"Console",
                "Text File"};
        int m = JOptionPane.showOptionDialog(frame,
                "Please select output method",
                "Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title



        if(m == -1)
        {
            System.out.println("You have canceled the program");
        }
        if(m == 0)
        {
            createpyramid(Integer.parseInt(n));
        }
        if(m == 1)
        {
            try
            {

                PrintWriter writer = new PrintWriter("mario.txt", "UTF-8");
                createpyramid(Integer.parseInt(n), writer);
                writer.close();
            } catch (FileNotFoundException e) {
               System.out.println("File not found " + e.getMessage());
            } catch (UnsupportedEncodingException e) {
                System.out.println("Unsupported encoding " + e.getMessage());
            }



        }



    System.exit(0);
    }
}
