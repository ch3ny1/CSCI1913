// CSci 1913 Lab 4
// Chenyi Wang 5513416

class Zillion
{
    // Pointer to array of integers for storage
    private int[] digits;

    // Constructor
    public Zillion(int size){
        // Create and point to a new array of the size
        digits = new int[size];

        // Initialize the array to 0s
        for(int i = 0; i < digits.length; i++)
        {
            digits[i] = 0;
        }
    }

    public void increment()
    {
        // Loop from the last digit to the first
        for(int i = digits.length - 1; i >= 0; i--)
        {
            if(digits[i] == 9)
            {
                digits[i] = 0;
            }   
            else // Stop looping once a non-9 digit is changed
            {
                digits[i] += 1;
                break;
            }
        }

    }

    public String toString(){
        // String used for concatenation and return
        String digitsString = "";
        
        for(int i = 0; i < digits.length; i++)
        {
            digitsString += digits[i];
        }

        return digitsString;
    }
}

//  DRIVER. The MAIN method has tests for your class ZILLION. Each test has a
//  comment that shows what the test should print if your code is correct. It
//  also has the number of points you will receive if the test is successful.
//  These tests are worth a total of 25 points.

class Driver
{
  public static void main(String[] args)
  {
    Zillion z = new Zillion(2);
    System.out.println(z);  //  00  2 points

    z.increment();
    System.out.println(z);  //  01  2 points

    z.increment();
    System.out.println(z);  //  02  2 points

    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();

    System.out.println(z);  //  10  2 points
    z.increment();
    System.out.println(z);  //  11  2 points

    z = new Zillion(4);
    System.out.println(z);  //  0000  2 points

    for (int j = 1; j <= 999; j += 1)
    {
      z.increment();
    }
    System.out.println(z);  //  0999  2 points

    z.increment();
    System.out.println(z);  //  1000  2 points

    for (int j = 1; j <= 999; j += 1)
    {
      z.increment();
    }
    System.out.println(z);  //  1999  2 points

    z.increment();
    System.out.println(z);  //  2000  2 points

    for (int j = 1; j <= 7999; j += 1)
    {
      z.increment();
    }
    System.out.println(z);  //  9999  2 points

    z.increment();
    System.out.println(z);  //  0000  2 points

    z.increment();
    System.out.println(z);  //  0001  1 point
  }
}

// Test Results

// 00
// 01
// 02
// 10
// 11
// 0000
// 0999
// 1000
// 1999
// 2000
// 9999
// 0000
// 0001