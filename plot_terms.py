import matplotlib.pyplot as plt
import numpy as np
import collections
# generated from parsing
data = open("terms.txt","r").read().splitlines();
# from professor
stopwords = open("stopwords.txt","r").read().splitlines();
terms = []
term_data = {}
for line in data:
    line = line.split("\t")
    if line[0] not in stopwords:
        if line[1] not in term_data.keys():
            term_data[line[1]] = 1
        else:
            term_data[line[1]] += 1

for k, v in term_data.items():
    terms.append(int(k))
terms = sorted(terms, reverse = True)
plt.plot(terms)
plt.title('Total Number of Term Occurance (No Stopwords)')
plt.ylabel('Number of Terms')
plt.xlabel('Total Occurance of Terms')
plt.show()
