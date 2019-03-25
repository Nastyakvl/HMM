# Hidden Markov Model 
Generator of observations in Hidden Markov Model

## Parameters

1. Name of file with starting probabilities
    
**Example:**
```
2        #dimension
0,6 0,4  #starting probabilities
```

2. Name of file with transition probabilities

**Example:**
```
# matrix with the transition probabilities
0,6 0,4
0,3 0,7
```

3. Name of file with hidden states and emission probabilities

**Example:**
```
3                                         #dimension
OneIceCream TwoIceCream ThreeIceCream     # states
0,2 0,5                                   # matrix with the emission probabilities
0,4 0,4
0,4 0,1
```

4. Number of transition and observations
