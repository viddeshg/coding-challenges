
import java.util.ArrayList;
import java.util.Arrays;


public class HeyIAlreadyDidThat
{
    public static void main(String args[])
    {
        System.out.println(solution("210022",3));
    }
    public static int solution(String n, int b)
    {
        ArrayList<String> sequence = new ArrayList<String>();

        // storing length of string k
        int k = n.length();

        while(!sequence.contains(n))
        {
            // Adding n into sequence array
            sequence.add(n);

            // Converting integer from string
            int nInt = Integer.parseInt(n);

            // Pushing each digit into integer array
            int[] nIntegerArray = new int[k];
            int ptr = 0;
            while(nInt>0)
            {
                nIntegerArray[ptr] = nInt % 10;
                nInt = nInt / 10;
                ptr = ptr + 1;
            }
    
            // Sorting Integer Array in ascending order
            Arrays.sort(nIntegerArray);

            // Converting to string from Integer Array
            String nString = "";
            int lenIntegerArray = nIntegerArray.length;
            int temp = 0;
            while(lenIntegerArray!=temp)
            {
                nString = nString + nIntegerArray[temp];
                temp = temp + 1;
            }

            // Converting string from Integer array for reverse string
            String xString = "";
            int index = lenIntegerArray - 1;
            while(index>=0)
            {
                xString = xString + nIntegerArray[index];
                index = index - 1;
            }

            // Parsing  to obtain base 10 Integer
            int xBase10 = Integer.parseInt(xString,b);
            int yBase10 = Integer.parseInt(nString,b);
    
            // Obtaining z and converting it back to base b
            int zBase10 = xBase10 - yBase10;
            String z = Integer.toString(zBase10,b);

            // Adding zeroes to lead if length of z is not equal to k
            boolean flag = true;
            String zero = "0";
            while (flag)
            {
                if (z.length()<k)
                {
                    z = zero + z;
                }
                else
                {
                    flag = false;
                }
            }

            n = z;
        }

        int indexCycle = sequence.indexOf(n);
        int lengthCycle = sequence.size() - indexCycle;

        // System.out.println(sequence);
        return lengthCycle;
    }
}