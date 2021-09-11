import np

x = 0

for i in range(len(A)):
    x += A[i]*B[i]



try:
    print("x")
except NameError:
    print("Variable x is not defined")
except:
    print("Something else went wrong")
finally:
    print ("something")