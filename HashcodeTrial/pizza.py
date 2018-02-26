import sys

def checkSlice(rows, r1i, c1i, r2i, c2i, minRequirement, maxNrcells):
	tCount, mCount = 0, 0
	nrOfIngredientsMet = False
	nrOfCells = 0
	for i1 in range(r1i, r2i):
		for j1 in range(c1i, c2i):
				if(rows[i1][j1] == 'T'):
					tCount += 1
				elif(rows[i1][j1] == 'M'):
					mCount += 1
				else:
					return False
				nrOfCells+=1
				if((tCount >= minRequirement) & (mCount >= minRequirement)):
					nrOfIngredientsMet = True
				if(nrOfCells > maxNrcells):
					return False
	return nrOfIngredientsMet

def markSlice(rows, r1i, c1i, r2i, c2i):
	for i1 in range(r1i, r2i):
		for j1 in range(c1i, c2i):
				rows[i1][j1] = '0'

def getNextFreePosition(rows, nrRows, nrCols, alreadyTriedPositions):
	for i in range(0, nrRows):
		for j in range(0, nrCols):
			if(rows[i][j] != 0 & alreadyTriedPositions[i][j] != 1):
				return i, j
	return -1, -1

def initializeArray(array):
	for i in range(0,R):
		columns = []
		for j in range(0,C):
			columns.append(0)
		alreadyTriedPositions.append(columns)

if(len(sys.argv)<2):
	print("Not enough arguments.")
	quit()

inputFile = open(sys.argv[1], "r")
R, C, L, H = inputFile.readline().split(' ')
R = int(R)
C = int(C)
L = int(L)
H = int(H)

rows = inputFile.read().split('\n')

nrOfSlices = 0
outputText = ''

r1, c1, r2, c2 = 0, 0, 0, 1
switch = True
alreadyTriedPositions = []
initializeArray(alreadyTriedPositions)
hasUnregisteredSlice = True

while ((r1 < R) & (c1 < C) & (r2 < R) & (c2 < C)):
	if(checkSlice(rows, r1, c1, r2, c2, L, H)):
		hasUnregisteredSlice = True
		if(switch):
			# in order to advance on the main diagonal, r2 and c2 are incremented in turns
			r2 +=1
		else:
			c2 +=1
		switch = not switch
	else:
		if(not hasUnregisteredSlice):
			if(switch):
				# in order to advance on the main diagonal, r2 and c2 are incremented in turns
				r2 +=1
			else:
				c2 +=1
			switch = not switch
			continue
		#decrement to the last good slice
		if(not switch):
			r2 -=1
		else:
			c2 -=1
		#mark slice in pizza
		markSlice(rows, r1, c1, r2, c2)
		#save the values
		nrOfSlices += 1
		outputText += "{0} {1} {2} {3}\n".format(r1, c1, r2, c2)
		r1, c1 = getNextFreePosition(rows, R, C, alreadyTriedPositions)
		alreadyTriedPositions[r1][c1] = 1;
		if(r1 == -1):
			#there are no more valid positions
			break
		r2, c2 = r1, c1+1
		hasUnregisteredSlice = False

inputFile.close()
print(outputText)