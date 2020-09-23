//   CSci 1913 Lab 8
//   Chenyi Wang 5513416

//   RUNNYSTACK. Stack of BASEs, implementated using linked list, run-length encoding.
class RunnyStack<Base>
{
    //   RUN. Node that represents a run of Base's, used to implement the stack.

    private class Run
    {
        private Base base;
        private int  length;
        private Run  next;

        //   Node constructor.

        private Run(Base base, int length, Run next)
        {
            this.base   = base;
            this.length = length;
            this.next   = next;
        }
    }

    //   Represent the first node, total number of elements in the stack (depth), and number of runs, respectively.

    private Run top;
    private int totalCount;
    private int runCount;
    
    //   Stack constructor.

    public RunnyStack()
    {
        top        = null;
        totalCount = 0;
        runCount   = 0;
    }

    //   DEPTH. Sum of all the length of all the runs in the stack.

    public int depth()
    {
        return totalCount;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    //   PEEK. Return the Base at the top of the stack, if non-empty.

    public Base peek()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Empty Stack");
        }
        else
        {
            return top.base;
        }
    }

    //   POP. If non-empty, decrement the length of the top run/remove the top run if length == 0.

    public void pop()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Empty Stack");
        }
        else
        {
            top.length -= 1;
            totalCount -= 1;
            
            if (top.length == 0)
            {
                //   Move to the next node if the top node length == 0.

                top = top.next;
                runCount -= 1;
            }
        }
    }

    //   PUSH. Add a new Base to the stack, by adding 1 to the length of the top run, or by adding a new run.

    public void push(Base base)
    {
        if (isEmpty())
        {
            //   Make a new top Run node linked to null, if the stack is empty.

            top = new Run(base, 1, null);
            totalCount += 1;
            runCount   += 1;
        }
        else
        {
            if (isEqual(base, top.base))
            {
                top.length += 1;
                totalCount += 1;
            }
            else
            {
                top = new Run(base, 1, top);
                totalCount += 1;
                runCount   += 1;
            }
        }
    }

    //   RUNS. Number of runs in the stack.

    public int runs()
    {
        return runCount;
    }

    //   ISEQUAL. Compare the value of two Base's if neither is null, return true if equal.

    private boolean isEqual(Base base1, Base base2)
    {
        if (base1 == null || base2 == null)
        {
            return base1 == base2;
        }
        else
        {
            return base1.equals(base2);
        }
    }
}


//
//  Tests for CSci 1913 Lab 8
//  James Moen
//  20 Mar 17
//
//  The TRY-CATCH statements catch exceptions thrown by RUNNY STACK's methods,
//  so that the program can continue to run even if a method fails. We still
//  haven't talked about TRY-CATCH'es in the lectures yet.
//
//  Most tests have comments that show what they should print, and how many
//  points they are worth, for a total of 40 points.
//
//  Camembert is a soft French cheese. It may be runny. It can be stacked.
//

class Camembert
{
  public static void main(String [] args)
  {
    RunnyStack<String> s = new RunnyStack<String>();

    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      s.pop();
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No pop");          //  No pop     1 point
    }

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
 
    s.push("A");
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    System.out.println(s.isEmpty());         //  false      1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  2          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  6          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    s.pop();
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    s.pop();
    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
  }
}

/* Results:
    true
    0
    0
    No pop
    No peek
    A
    1
    1
    false
    B
    2
    2
    B
    3
    2
    B
    4
    2
    C
    5
    3
    C
    6
    3
    C
    5
    3
    B
    4
    2
    B
    3
    2
    A
    1
    1
    true
    0
    0
    No peek
*/