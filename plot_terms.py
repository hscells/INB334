import matplotlib.pyplot as plt
import numpy as np
import collections
# generated from parsing
data = open("terms.txt","r").read().splitlines();
# from professor
stopwords = open("stopwords.txt","r").read().splitlines();
freq = []
for line in data:
    line = line.split("\t")
    # if line[0] not in stopwords:
    freq.append(int(line[1]))

num_terms = len(freq) + 0.0

prob = [(n/num_terms) for n in freq]
freq = sorted(freq, reverse=True)
prob = sorted(prob, reverse=True)

print freq[len(freq)-1]
print prob[len(prob)-1]


plt.scatter(freq, prob)
plt.xlim(len(freq),0)
plt.title('Probability of Word Occurance')
plt.ylabel('Probability of Occurance')
plt.xlabel('Rank')
plt.grid(True)
plt.show()
