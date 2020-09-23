// CSci 1913 Lab 12
// Chenyi Wang 5513416

// Priority Queue using BST

class PriorityQueue<Base>
{
// BST Node class.

    private class Node
    {
        private Base object;
        private int  rank;
        private Node left;
        private Node right;

        private Node(Base object, int rank)
        {
            this.object = object; 
            this.rank = rank; 
            left = null; 
            right = null; 
        }
    }

    private Node root; // Root node of the BST.

// CONSTRUCTOR.

    public PriorityQueue()
    {
        root = new Node(null, 8); // Initialize to Head Node. Subtree on the right.
    }

// DEQUEUE. Dequeue and return the object with highest rank (smallest rank number).

    public Base dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Empty queue.");
        }
        else
        {
            Node above = root; // Node immediately above.
            Node below = root.right; // Node currently visited.
            while (below.right != null)
            {
                above = below;
                below = below.right;
            }
            // Link the objects ranked less-or-equal to below (the highest ranked found) 
            // but higher than above, to above, if any.
            if (below.left != null)
            {
                above.right = below.left;
            }
            else
            {
                above.right = null;
            }
            return below.object;   
        }

    }

// ENQUEUE.
    public void enqueue(Base object, int rank)
    {
        if (rank < 0)
        {
            throw new IllegalArgumentException("Rank cannot be negative.");
        }
        else
        {
            Node subtree = root;
            while (true)
            {
                if (rank < subtree.rank) // New object ranked higher, add to the right.
                {
                    if (subtree.right == null)
                    {
                        subtree.right = new Node(object, rank);
                        return;
                    }
                    else
                    {
                        subtree = subtree.right;
                    }
                }
                else // New object ranked equal or lower, add to the left.
                {
                    if (subtree.left == null)
                    {
                        subtree.left = new Node(object, rank);
                        return;
                    }
                    else
                    {
                        subtree = subtree.left;
                    }
                }
            }
        }

    }

// ISEMPTY. Return true if the BST is empty.
    public boolean isEmpty()
    {
        return root.left == null && root.right == null;
    }
}

//  SNOBBERY. How the aristocracy behaves in a queue. 20 points.

class Snobbery
{

//  MAIN. Queue them up.

  public static void main(String[] args)
  {
    PriorityQueue<String> queue = new PriorityQueue<String>();

    System.out.println(queue.isEmpty());  //  true        2 points

    try
    {
      System.out.println(queue.dequeue());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("Blimey!");      //  Blimey!     2 points
    }

    queue.enqueue("Lancelot",  5);
    queue.enqueue("Fawlty",    7);
    queue.enqueue("Elizabeth", 0);
    queue.enqueue("Charles",   1);
    queue.enqueue("Turing",    7);

    try
    {
      queue.enqueue("Zeus", -100);
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No gods!");     //  No gods!    2 points
    }

    System.out.println(queue.isEmpty());  //  false       2 points

    System.out.println(queue.dequeue());  //  Elizabeth   2 points
    System.out.println(queue.dequeue());  //  Charles     2 points
    System.out.println(queue.dequeue());  //  Lancelot    2 points
    System.out.println(queue.dequeue());  //  Turing      2 points
    System.out.println(queue.dequeue());  //  Fawlty      2 points

//  It's OK if Fawlty comes out before Turing, but both must come out last.

    System.out.println(queue.isEmpty());  //  true        2 points.
  }

}


/*
Result:
    true
    Blimey!
    No gods!
    false
    Elizabeth
    Charles
    Lancelot
    Fawlty
    Turing
    true
*/