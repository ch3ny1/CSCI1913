// CSci 1913 Lab 7
// Chenyi Wang 5513416

class BinaryVsLinear
{

  private static int linearSearch(int key, int[] keys)
  {
    int index = 0;
    for (index = 0; index < keys.length; index += 1)
    {
        if (key == keys[index])
        {
            // Number of comparison made = index + 1
            index += 1;
            return index;
        }
    }

    // Return the length of keys = comparison made, where no match is made
    return index;
  }

  private static int binarySearch(int key, int[] keys)
  {
    int low = 0;
    int high = keys.length - 1;
    int mid;
    int counts = 0;

    while (true)
    {
        if (low > high)
        {
            // Failed to find a match, return total counts
            return counts;
        }
        else
        {
            mid = (low + high) / 2;
     
            if (keys[mid] < key)
            {
                low = mid + 1;
                counts += 1;
            }
            else if (keys[mid] > key)
            {
                high = mid;
                // Results from the above two comparisons
                counts += 2;
            }
            else
            {
                // A match is found, where keys[mid] == key
                // Two comparisons before this block are made
                counts += 2;
                return counts;
            }
        }
    }
  }

  public static void main(String[] args)
  {
    for (int length = 1; length <= 30; length += 1)
    {
      int[] array = new int[length];
      for (int index = 0; index < length; index += 1)
      {
        array[index] = index;
      }

      double linearTotal = 0.0;
      double binaryTotal = 0.0;
      for (int element = 0; element < length; element += 1)
      {
        linearTotal += linearSearch(element, array);
        binaryTotal += binarySearch(element, array);
      }

      double linearAverage = linearTotal / length;
      double binaryAverage = binaryTotal / length;
      System.out.println(length + " " + linearAverage + " " + binaryAverage);
    }
  }
}

/* Results:
1 1.0 2.0
2 1.5 2.5
3 2.0 3.0
4 2.5 3.25
5 3.0 3.8
6 3.5 4.0
7 4.0 4.142857142857143
8 4.5 4.25
9 5.0 4.666666666666667
10 5.5 4.9
11 6.0 5.090909090909091
12 6.5 5.166666666666667
13 7.0 5.3076923076923075
14 7.5 5.357142857142857
15 8.0 5.4
16 8.5 5.4375
17 9.0 5.705882352941177
18 9.5 5.888888888888889
19 10.0 6.052631578947368
20 10.5 6.15
21 11.0 6.285714285714286
22 11.5 6.363636363636363
23 12.0 6.434782608695652
24 12.5 6.458333333333333
25 13.0 6.56
26 13.5 6.615384615384615
27 14.0 6.666666666666667
28 14.5 6.678571428571429
29 15.0 6.724137931034483
30 15.5 6.733333333333333

See also lab7_cheny004.pdf
*/