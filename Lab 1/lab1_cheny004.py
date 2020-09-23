#  CSci 1913 Lab 1
#  Chenyi Wang 5513416

#  Import necessary package: types
import types

#  Representation function definition
def left(e):
    return e[0]

def op(e):
    return e[1]

def right(e):
    return e[2]

#  Implementation function definition
def isInside(v, e):
    if (v == e):
        return True
    elif(type(e) == tuple):
        if (isInside(v, left(e)) == True):
            return True
        elif (isInside(v, right(e)) == True):
            return True
        return False
    else:
        return False

def solve(v, q):
    if (isInside(v, left(q)) == True):
        return solving(v, q)
    elif (isInside(v, right(q)) == True):
        return solving(v, (right(q), op(q), left(q)))
    elif (isInside(v, q) == 1):
        return q
    else:
        return None

def solving(v, q):
    if (v == left(q)):
        return q
    elif (type(left(q)) == tuple):
        if (op(left(q)) == '+'):
            return solvingAdd(v, q)
        elif (op(left(q)) == '-'):
            return solvingSubtract(v, q)
        elif (op(left(q)) == '*'):
            return solvingMultiply(v, q)
        elif (op(left(q)) == '/'):
            return solvingDivide(v, q)
    else:
        return None


def solvingAdd(v, q):
    if (isInside(v, left(left(q))) == True):
        return solving(v, (left(left(q)), '=', (right(q), '-', right(left(q)))))
    else:
        return solving(v, (right(left(q)), '=', (right(q), '-', left(left(q)))))

def solvingSubtract(v, q):
    if (isInside(v, left(left(q))) == True):
        return solving(v, (left(left(q)), '=', (right(q), '+', right(left(q)))))
    else:
        return solving(v, (right(left(q)), '=', (left(left(q)), '-', right(q))))

def solvingMultiply(v, q):
    if (isInside(v, left(left(q))) == True):
        return solving(v, (left(left(q)), '=', (right(q), '/', right(left(q)))))
    else:
        return solving(v, (right(left(q)), '=', (right(q), '/', left(left(q)))))

def solvingDivide(v, q):
    if (isInside(v, left(left(q))) == True):
        return solving(v, (left(left(q)), '=', (right(q), '*', right(left(q)))))
    else:
        return solving(v, (right(left(q)), '=', (left(left(q)), '/', right(q))))


#
#  Test Script
#
#  TESTS. Test the equation solver for CSci 1913 Lab 1.
#
#    James Moen
#    10 Sep 18
#
#  Every test is followed by a comment which shows what must be printed if your
#  code works correctly. It also shows how many points the test is worth, for a
#  total of 35 possible points.
#
print(isInside('x', 'x'))                          #  True   1 point
print(isInside('x', 'y'))                          #  False  1 point
print(isInside('x', ('x', '+', 'y')))              #  True   2 points
print(isInside('x', ('a', '+', 'b')))              #  False  2 points
print(isInside('+', ('a', '+', 'b')))              #  False  2 points
print(isInside('x', (('m', '*', 'x'), '+', 'b')))  #  True   2 points

print(solve('x', (('a', '+', 'x'), '=', 'c')))
#  ('x', '=', ('c', '-', 'a'))  2 points

print(solve('x', (('x', '+', 'b'), '=', 'c')))
#  ('x', '=', ('c', '-', 'b'))  2 points

print(solve('x', (('a', '-', 'x'), '=', 'c')))
#  ('x', '=', ('a', '-', 'c'))  2 points

print(solve('x', (('x', '-', 'b'), '=', 'c')))
#  ('x', '=', ('c', '+', 'b'))  2 points

print(solve('x', (('a', '*', 'x'), '=', 'c')))
#  ('x', '=', ('c', '/', 'a'))  2 points

print(solve('x', (('x', '*', 'b'), '=', 'c')))
#  ('x', '=', ('c', '/', 'b'))  2 points

print(solve('x', (('a', '/', 'x'), '=', 'c')))
#  ('x', '=', ('a', '/', 'c'))  2 points

print(solve('x', (('x', '/', 'b'), '=', 'c')))
#  ('x', '=', ('c', '*', 'b'))  2 points

print(solve('y', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('y', '=', (('m', '*', 'x'), '+', 'b'))  2 points

print(solve('x', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('x', '=', (('y', '-', 'b'), '/', 'm'))  2 points

print(solve('a', (('b', '+', 'c'), '=', ('d', '*', (('a', '/', 'e'), '-', 'f')))))
# ('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))  5 points

#
#  Test Results
#
#
#  True
#  False
#  True
#  False
#  False
#  True
#  ('x', '=', ('c', '-', 'a'))
#  ('x', '=', ('c', '-', 'b'))
#  ('x', '=', ('a', '-', 'c'))
#  ('x', '=', ('c', '+', 'b'))
#  ('x', '=', ('c', '/', 'a'))
#  ('x', '=', ('c', '/', 'b'))
#  ('x', '=', ('a', '/', 'c'))
#  ('x', '=', ('c', '*', 'b'))
#  ('y', '=', (('m', '*', 'x'), '+', 'b'))
#  ('x', '=', (('y', '-', 'b'), '/', 'm'))
#  ('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))
#