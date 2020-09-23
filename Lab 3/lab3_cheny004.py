# CSci 1913 Lab 3
# Chenyi Wang 5513416

# Recursive function that returns a new sorted tuple of T 
def Sort(T):

    # (Base condition) Return T if no elements within
    if T == ():
        return T

    # (Recursively) Return function Sort() with new tuple
    # which the largest number is removed, then concatenated to the end
    else:

        # Identify the largest number ahead to avoid calling the  
        # Maximum() function twice, which improves efficiency
        M = Maximum(T)

        return Sort(Remove(T, M)) + (M,)


# Recursive function that returns a new tuple of T
# with the first appearance of E removed
def Remove(T, E):

    # (Base condition) Return T if no elements within
    if T == ():
        return T

    # Once E appears as the first element, 
    # stop recurring and return the tuple without the first element
    elif T[0] == E:
        return T[1:]

    # (Recursively) Return a tuple of the first element not equal to E and
    # results from calling Remove() on T from the second element
    else:
        return (T[0],) + Remove(T[1:], E)
    

# Recursive function that return the maximum integer in tuple T 
# Assumed at least 1 element in T
def Maximum(T):

    # Return T if only 1 element within
    if len(T) == 1:
        return T[0]

    # If the first element is larger than the second,
    # return Maximum() call on T with the second element removed
    elif T[0] > T[1]:
        return Maximum((T[0],)+T[2:])
    
    # (The second element is larger)
    # Return Maximum() call on T without the first element
    else:
        return Maximum(T[1:])




#
#  TESTS. Tests for CSci 1913 Lab 3.
#
#    James Moen
#    11 Feb 19
#
#  Each test is worth 2 points, for 40 points total. Comments show what must be
#  printed to receive credit. Note that your function SORT must work for tuples
#  with negative elements.
#

print(Maximum((1,)))                      #  1                            2 pt.
print(Maximum((-2, -1)))                  # -1                            2 pt.
print(Maximum((1, 1)))                    #  1                            2 pt.
print(Maximum((1, 2, 3)))                 #  3                            2 pt.

print(Remove((), 1))                      #  ()                           2 pt.
print(Remove((1,), 1))                    #  ()                           2 pt.
print(Remove((0, 1), 0))                  #  (1,)                         2 pt.
print(Remove((0, 1, 2, 1, 3), 1))         #  (0, 2, 1, 3)                 2 pt.
print(Remove((0, 1, 2, 1, 3), 2))         #  (0, 1, 1, 3)                 2 pt.
print(Remove((1, 2, 3), 3))               #  (1, 2)                       2 pt.

print(Sort(()))                           #  ()                           2 pt.
print(Sort((0,)))                         #  (0,)                         2 pt.
print(Sort((0, -1)))                      #  (-1, 0)                      2 pt.
print(Sort((1, 0)))                       #  (0, 1)                       2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)                    2 pt.
print(Sort((0, -1, 0)))                   #  (-1, 0, 0)                   2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)                    2 pt.

print(Sort((9, 8, 7, 6, 5, 4, 3, 2, 1)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt.
print(Sort((1, 2, 3, 4, 5, 6, 7, 8, 9)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt.
print(Sort((1, 2, 1, 4, 2, 5, 4, 5, 3)))  #  (1, 1, 2, 2, 3, 4, 4, 5, 5)  2 pt.



# Test Results
# 1
# -1
# 1
# 3
# ()
# ()
# (1,)
# (0, 2, 1, 3)
# (0, 1, 1, 3)
# (1, 2)
# ()
# (0,)
# (-1, 0)
# (0, 1)
# (0, 0, 1)
# (-1, 0, 0)
# (0, 0, 1)
# (1, 2, 3, 4, 5, 6, 7, 8, 9)
# (1, 2, 3, 4, 5, 6, 7, 8, 9)
# (1, 1, 2, 2, 3, 4, 4, 5, 5)