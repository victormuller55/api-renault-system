#!/usr/bin/env python3
import nltk
# nltk.download('punkt')
import numpy as np
from nltk.stem.porter import PorterStemmer
stemmer = PorterStemmer()

def tokenize(sentence):
    return nltk.word_tokenize(sentence)

def stem(word):
    return stemmer.stem(word.lower())

def bag_of_words(tokenized_sentence, all_words):
    tokenized_sentence = [stem(w) for w in tokenized_sentence]
    
    bag = np.zeros(len(all_words), dtype=np.float32)
    # print(bag)
    for idx, w in enumerate(all_words):
        if w in tokenized_sentence:
            bag[idx] = 1.0
            # print(all_words[idx])

    return bag


def main() -> None:
  ...
  # tokenized_sentence = tokenize("palavras varias letras, letras letrass")
  # for i in tokenized_sentence:
    # print(stem(i))

if __name__ == "__main__":
  main()
