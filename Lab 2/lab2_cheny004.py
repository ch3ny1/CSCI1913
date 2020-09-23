# CSci 1913 Lab 2
# Chenyi Wang 5513416


class Zillion:
    def __init__(self, digits):
        self.__digList = []

        digTest = False
        charTest = True

        for i in digits:
            if i in "0123456789": #Test if it is a number
                digTest = True
            else:
                if i != "," and i !=" ": #Spot non-digit except for comma and space
                    charTest = False

        if digTest and charTest:
            for i in range(len(digits)):
                if digits[i] in "0123456789":
                    self.__digList.append(int(digits[i])) #Create the list
        else:
            raise RuntimeError


    def increment(self):
        done = False
        ind = len(self.__digList) - 1 #Stand for index of the number working on

        while done == False:
            if ind == -1: #Criteria not met til the initial digit
                self.__digList = [1] + self.__digList
                done = True
            elif self.__digList[ind] != 9:
                self.__digList[ind] += 1
                done = True
            else:
                self.__digList[ind] = 0
                ind -= 1
    

    def isZero(self):
        for i in range(len(self.__digList)):
            if self.__digList[i] != 0:
                return False #Any exceptions return False
        return True #True if no exceptions


    def toString(self):
        digString = ""
        for i in range(len(self.__digList)):
            digString += str(self.__digList[i])
        return digString



#
#  TESTS. Test the class Zillion for CSci 1913 Lab 2.
#
#    James Moen
#    18 Sep 17
#
#  Every test is followed by a comment which shows what must be printed if your
#  code works correctly. It also shows how many points the test is worth.
#

try:
  z = Zillion('')
except RuntimeError:
  print('Empty string')

# It must print 'Empty string' without apostrophes. 2 points.

try:
  z = Zillion(' , ')
except RuntimeError:
  print('No digits in the string')

# It must print 'No digits in the string' without apostrophes. 2 points.

try:
  z = Zillion('1+0')
except RuntimeError:
  print('Non-digit in the string')

# It must print 'Non-digit in the string' without apostrophes. 2 points.

try:
  z = Zillion('0')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000000000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000 000 000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('997')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing.  2 points.

print(z.isZero())    #  It must print False. 2 points.

print(z.toString())  #  It must print 997. 2 points.

z.increment()

print(z.toString())  #  It must print 998. 2 points.

z.increment()

print(z.toString())  #  It must print 999. 2 points.

z.increment()

print(z.toString())  #  It must print 1000. 2 points.

try:
  z = Zillion('0 9,9 9')
except:
  print('This must not be printed')

#  It must print nothing.  3 points.

z.increment()
print(z.toString())  #  It must print 1000. 2 points.


## Test Result

# Empty string
# No digits in the string
# Non-digit in the string
# True
# True
# True
# False
# 997
# 998
# 999
# 1000
# 1000