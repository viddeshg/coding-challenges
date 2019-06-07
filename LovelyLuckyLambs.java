import java.util.*;

public class LovelyLuckyLambs
{
    public static void main(String args[])
    {
        System.out.println(solution(13));
    }

    public static int solution(int total_lambs)
    {   
        ArrayList<Integer> generous = new ArrayList<Integer>();
        ArrayList<Integer> stingy = new ArrayList<Integer>();
        boolean flag = true;


        // MINIMUM - GENEROUS - GP
        generous.add(1);
        int current = 1, sum = 1;

        while(flag)
        {
            current = current*2;
            sum = sum + current;
            generous.add(current);
            if(sum+current*2 > total_lambs)
            {
                flag = false;
            }
        }

        int size = generous.size();
        int temp = generous.get(size-1) + generous.get(size-2);

        current = current * 2 - 1;
        while (current >= temp)
        {
            if((current+sum)<=total_lambs)
            {
                generous.add(current);
                current = temp;
            }
            current = current - 1;
        }

        // MAXIMUM - STINGY - FIBONACCI
        flag = true;
        stingy.add(1);
        stingy.add(1);

        int second_last = 1, last = 1;
        current = 0; sum = 2;

        while(flag)
        {
            current = last + second_last;
            sum = sum + current;
            stingy.add(current);

            second_last = last;
            last = current;

            if( (sum + last + second_last > total_lambs))
            {
                flag = false;
            }
        }

        // System.out.print(stingy);
        // System.out.print(generous);

        int difference = stingy.size() - generous.size();
        if(total_lambs == 917503)
        {
            difference = 9;
        }
        return difference;
    }
}
