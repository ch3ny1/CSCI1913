// CSci 1913 Lab 13
// Chenyi Wang 5513416

// Design of a perfect hash function for the following twelve names.
class Test 
{ 
  private static final String [] reserved = 
   { "and", 
     "begin", 
     "define", 
     "do", 
     "else", 
     "end", 
     "if", 
     "not", 
     "or", 
     "return", 
     "then", 
     "while" }; 
 
// HASH. Define h(name) to be: 
// 3 times the int of the 1st char plus 4 times the int of the last char.
  private static int hash(String name) 
  { 
    int hashcode = name.charAt(0) * 3 + name.charAt(name.length()-1) * 4;
    return hashcode;
  } 
 
  public static void main(String [] args) 
  { 
    for (int index = 0; index < reserved.length ; index += 1) 
    { 
      System.out.print("h(\"" + reserved[index] + "\") = "); 
      System.out.print(hash(reserved[index])); 
      System.out.println(); 
    } 
  } 
}

/* 
Result:
    h("and") = 691
    h("begin") = 734
    h("define") = 704
    h("do") = 744
    h("else") = 707
    h("end") = 703
    h("if") = 723
    h("not") = 794
    h("or") = 789
    h("return") = 782
    h("then") = 788
    h("while") = 761
*/