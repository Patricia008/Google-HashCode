import sys

def checkSlice(rows, r1i, c1i, r2i, c2i, minRequirement, maxNrcells):
	tCount, mCount = 0, 0
	nrOfIngredientsMet = False
	nrOfCells = 0
	for i1 in range(r1i, r2i+1):
		for j1 in range(c1i, c2i+1):
				if(rows[i1][j1] == 'T'):
					tCount += 1
				elif(rows[i1][j1] == 'M'):
					mCount += 1
				else:
					return False, False
				nrOfCells+=1
				if((tCount >= minRequirement) & (mCount >= minRequirement)):
					nrOfIngredientsMet = True
				if(nrOfCells > maxNrcells):
					return False, True
	return nrOfIngredientsMet, False

def markSlice(alreadyTriedPositions, r1i, c1i, r2i, c2i):
	for i1 in range(r1i, r2i+1):
		for j1 in range(c1i, c2i+1):
				alreadyTriedPositions[i1][j1] = 1

def getNextFreePosition(alreadyTriedPositions, nrRows, nrCols):
	for i in range(0, nrRows):
		for j in range(0, nrCols):
			if(alreadyTriedPositions[i][j] != 1):
				return i, j
	return -1, -1

def initializeArray():
	alreadyTriedPositions = []
	for i in range(0,R):
		columns = []
		for j in range(0,C):
			columns.append(0)
		alreadyTriedPositions.append(columns)
	return alreadyTriedPositions

def processLength(rows, r1, c1, R, C, L, H, alreadyTriedPositions):
	nrOfSlices = 0
	outputText = ''

	r2, c2 = 0, 1
	switch = True
	r1Switch = True
	hasUnregisteredSlice = False

	while ((r1 < R) & (c1 < C) & (r2 < R) & (c2 < C) & (r1 >= 0) & (c1 >= 0) & (r2 >= 0) & (c2 >= 0)):
		tooManyCells = False
		valid, tooManyCells = checkSlice(rows, r1, c1, r2, c2, L, H)
		if(valid):
			hasUnregisteredSlice = True
			if(switch & (r2 < R-1)):
				# in order to advance on the main diagonal, r2 and c2 are incremented in turns
				r2 +=1
			else:
				c2 +=1
			switch = not switch
		else:
			if(not hasUnregisteredSlice):
				if(tooManyCells):
					alreadyTriedPositions[r1][c1] = 1
					if(r1Switch & (r1 < R-1)):
						# in order to advance on the main diagonal, r2 and c2 are incremented in turns
						r1 +=1
					else:
						c1 +=1
					r1Switch = not r1Switch
				else:
					if(switch & (r2 < R-1)):
						# in order to advance on the main diagonal, r2 and c2 are incremented in turns
						r2 +=1
					else:
						c2 +=1
					switch = not switch
				continue
			#decrement to the last good slice
			if(not switch & (r2 > 0)):
				r2 -=1
			else:
				c2 -=1
			#mark slice in pizza
			markSlice(alreadyTriedPositions, r1, c1, r2, c2)
			#save the values
			nrOfSlices += 1
			outputText += "\n{0} {1} {2} {3}".format(r1, c1, r2, c2)
			r1, c1 = getNextFreePosition(alreadyTriedPositions, R, C)
			alreadyTriedPositions[r1][c1] = 1;
			if(r1 == -1):
				#there are no more valid positions
				return nrOfSlices, outputText, alreadyTriedPositions
			r2, c2 = r1, c1+1
			hasUnregisteredSlice = False
	return nrOfSlices, outputText, alreadyTriedPositions


if(len(sys.argv)<3):
	print("Not enough arguments.\nargv[1] = inputFile\nargv[2] = output file")
	quit()

inputFile = open(sys.argv[1], "r")
R, C, L, H = inputFile.readline().split(' ')
R = int(R)
C = int(C)
L = int(L)
H = int(H)

rows = inputFile.read().split('\n')


alreadyTriedPositions = initializeArray()
r1, c1 = 0, 0
nrOfSlices = 0
outputText = ''

while(r1 < C):
	newNrOfSlices, newOutputText, alreadyTriedPositions = processLength(rows, r1, c1, R, C, L, H, alreadyTriedPositions)
	nrOfSlices += newNrOfSlices
	outputText += newOutputText
	r1 += 2

inputFile.close()
outputFile = open(sys.argv[2], "w")
outputFile.write(str(nrOfSlices))
outputFile.write(outputText)
outputFile.close()