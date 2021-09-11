[0 for i in range(len(dNidt)+3)]
dydt = numpy.zeros(len(dNidt)+3, float)
y = 0
for i in range(len(Y)):
    y += Z[i]*H[i]