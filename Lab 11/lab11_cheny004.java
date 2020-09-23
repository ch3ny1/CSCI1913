// CSci 1913 Lab 11
// Chenyi Wang 5513416

// Implementation of Dequeue using double linked list
class Deque<Base>
{
  private Node head;
	
  private class Node
  {
    private Base object;
    private Node left;
    private Node right;
		
  // Constructor for Node.
    private Node(Base object, Node left, Node right)
    {
      this.object = object;
      this.left = left;
      this.right = right;
    }
  }

  // Constructor for an empty Dequeue.
  public Deque()
  {
    head       = new Node(null, null, null);
    head.left  = head;
    head.right = head;
  }
	
  public void enqueueFront(Base object)
  {
    Node front      = new Node(object, head, head.right); // New Node ready to enqueue.
    head.right.left = front; // Link from the left.
    head.right      = front; // Link from the right.
  }
	
  public void enqueueRear(Base object)
  {
    Node rear       = new Node(object, head.left, head); // New Node ready to enqueue.
    head.left.right = rear; // Link from the left.
    head.left       = rear; // Link from the right.
  }
	
  public Base dequeueFront()
  {
    if (isEmpty())
    {
      throw new IllegalStateException();
    }
    else
    {
      Node front       = head.right;
      head.right       = front.right;
      front.right.left = head;

      return front.object;
    }
  }
	
  public Base dequeueRear()
  {
    if (isEmpty())
    {
      throw new IllegalStateException();
    }
    else
    {
      Node rear       = head.left;
      head.left       = rear.left;
      rear.left.right = head;

      return rear.object;
    }
  }
	
  public boolean isEmpty()
  {
    return (head.left == head && head.right == head);
  }
}

//  OBSERVATION DEQUE. Test the class DEQUE. 40 points total.

class ObservationDeque
{

//  MAIN. Test the DEQUE on various example arguments.

  public static void main(String [] args)
  {
    Deque<String> deque = new Deque<String>();

    System.out.println(deque.isEmpty());       // true                2 points.

    try
    {
      System.out.println(deque.dequeueFront());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No dequeueFront.");  //  No dequeueFront.   2 points.
    }

    try
    {
      System.out.println(deque.dequeueRear());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No dequeueRear.");   //  No dequeueRear.    2 points.
    }

//  Enqueueing to the rear and dequeueing from the rear makes the DEQUE act
//  like a stack.

    deque.enqueueRear("A");
    deque.enqueueRear("B");
    deque.enqueueRear("C");

    System.out.println(deque.isEmpty());       //  false              2 points.

    System.out.println(deque.dequeueRear());   //  C                  2 points.
    System.out.println(deque.dequeueRear());   //  B                  2 points.
    System.out.println(deque.dequeueRear());   //  A                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the rear and dequeueing from the front makes the DEQUE act
//  like a queue.

    deque.enqueueRear("A");
    deque.enqueueRear("B");
    deque.enqueueRear("C");

    System.out.println(deque.dequeueFront());  //  A                  2 points.
    System.out.println(deque.dequeueFront());  //  B                  2 points.
    System.out.println(deque.dequeueFront());  //  C                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the front and dequeueing from the front makes the DEQUE act
//  like a stack.

    deque.enqueueFront("A");
    deque.enqueueFront("B");
    deque.enqueueFront("C");

    System.out.println(deque.dequeueFront());  //  C                  2 points.
    System.out.println(deque.dequeueFront());  //  B                  2 points.
    System.out.println(deque.dequeueFront());  //  A                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the front and dequeueing from the rear makes the DEQUE act
//  like a queue.

    deque.enqueueFront("A");
    deque.enqueueFront("B");
    deque.enqueueFront("C");

    System.out.println(deque.dequeueRear());   //  A                  2 points.
    System.out.println(deque.dequeueRear());   //  B                  2 points.
    System.out.println(deque.dequeueRear());   //  C                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.
  }
}

/*
Result:
  true
  No dequeueFront.
  No dequeueRear.
  false
  C
  B
  A
  true
  A
  B
  C
  true
  C
  B
  A
  true
  A
  B
  C
  true
*/
