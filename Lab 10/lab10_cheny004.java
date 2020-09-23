// CSci 1913 Lab 10
// Chenyi Wang 5513416

class AssociationList<Key, Value>
{
    private Node head;

    private class Node
    {
        // Constructor that initializes all three slots
        public Node(Key key, Value value, Node next)
        {
            this.key   = key;
            this.value = value;
            this.next  = next;
        }

        private Key key; 
        private Value value;
        private Node next;
    }

    // Constructor
    public AssociationList()
    {
        head = new Node(null, null, null);
    }
    
    // DELETE
    public void delete(Key key)
    {
        // Left-right trick
        Node left = head;
        Node right;

        while (left.next != null)
        {
            right = left.next;

            if (isEqual(right.key, key))
            {
                left.next = right.next;
                return;
            }
            else
            {
                left  = right;
                right = right.next;
            }
        }
        // If no such key found, do nothing.
    }

    // GET
    public Value get(Key key)
    {
        Node current = head;

        while (current.next != null)
        {
            current = current.next;
            if (isEqual(current.key, key))
            {
                return current.value;
            }
        }
        // No key found after loop, throw exception.
        throw new IllegalArgumentException("Key not found.");
    }

    // ISEQUAL
    private boolean isEqual(Key leftKey, Key rightKey)
    {
        if (leftKey == null || rightKey == null)
        {
            return leftKey == rightKey;
        }
        else
        {
            return leftKey.equals(rightKey);
        }
    }

    // ISIN
    public boolean isIn(Key key)
    {
        Node current = head;

        while (current.next != null)
        {
            current = current.next;
            if (isEqual(current.key, key))
            {
                return true;
            }
        }
        // No such key found after loop, return false.
        return false;
    }

    // PUT
    public void put(Key key, Value value)
    {
        Node current = head;
        
        while (current.next != null)
        {
            current = current.next;
            if (isEqual(current.key, key))
            {
                current.value = value;
                return;
            }
        }
        // No existing key, create a new node at last.
        current.next = new Node(key, value, null);
    }
}


//
//  Tests for CSci 1913 Lab 10
//  James Moen
//  08 Apr 19
//
//  The TRY-CATCH statements catch exceptions thrown by ASSOCIATION LIST's
//  methods, so that the program can continue to run even if a method fails.
//
//  Each test has a comment that shows what it should print and how many points
//  it is worth, for a total of 40 points.

//  HOGWARTS. The Hogwarts dating service.

class Hogwarts
{

//  MAIN. Make an instance of ASSOCIATION LIST and test it.

  public static void main(String[] args)
  {
    AssociationList<String,String> list = new AssociationList<String,String>();

    System.out.println(list.isIn(null));         //  false         2 points.

    try
    {
      System.out.println(list.get(null));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No null");             //  No null       2 points.
    }

    list.put(null,        "Wormtail");
    list.put("Ron",       "Lavender");
    list.put("Voldemort", null);
    list.put("Dean",      "Ginny");

    System.out.println(list.isIn("Dean"));       //  true          2 points.
    System.out.println(list.isIn("Ginny"));      //  false         2 points.
    System.out.println(list.isIn("Ron"));        //  true          2 points.
    System.out.println(list.isIn("Voldemort"));  //  true          2 points.
    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.isIn("Joanne"));     //  false         2 points.

    System.out.println(list.get("Ron"));         //  Lavender      2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Voldemort"));   //  null          2 points.
    System.out.println(list.get(null));          //  Wormtail      2 points.

    try
    {
      System.out.println(list.get("Joanne"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne");           //  No Joanne     2 points.
    }

    list.delete(null);

    System.out.println(list.isIn(null));         //  false         2 points.

    list.put(null,    null);
    list.put("Harry", "Ginny");
    list.put("Ron",   "Hermione");

    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.get(null));          //  null          2 points.
    System.out.println(list.get("Harry"));       //  Ginny         2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Ron"));         //  Hermione      2 points.

    list.delete("Dean");

    try
    {
      System.out.println(list.get("Dean"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Dean");             //  No Dean       2 points.
    }
  }
}

/*
Results:
    false
    No null
    true
    false
    true
    true
    true
    false
    Lavender
    Ginny
    null
    Wormtail
    No Joanne
    false
    true
    null
    Ginny
    Ginny
    Hermione
    No Dean
*/