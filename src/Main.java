
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

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");

        //loop for input, until it gets an int
        while(!reader.hasNextInt())
        {
            reader.next();
            System.out.println("Enter a number: ");
        };

        int n = reader.nextInt();

        createpyramid(n);
    }
}
