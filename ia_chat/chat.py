#!/usr/bin/env python3
import random, json, torch, argparse
from model import NeuralNet
from nltk_utils import bag_of_words, tokenize

device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
with open('ia_chat/intents.json', 'r') as f:
  intents = json.load(f)

FILE = "ia_chat/data.pth"
data = torch.load(FILE)

input_size = data["input_size"]
hidden_size = data["hidden_size"]
output_size = data["output_size"]
all_words = data["all_words"]
tags = data["tags"]
model_state = data["model_state"]

model = NeuralNet(input_size, hidden_size, output_size).to(device)
model.load_state_dict(model_state)
model.eval()

bot_name = "Ai - Jornada"
parser = argparse.ArgumentParser()

# parser.add_argument("-i", "--id", help="get id")
parser.add_argument("-q", "--query", help="get query")

args = parser.parse_args()
if args.query:
  sentence = tokenize(args.query)
  x = bag_of_words(sentence, all_words)
  x = x.reshape(1, x.shape[0])
  x = torch.from_numpy(x).to(device)
  answer = {}
  
  output = model(x)
  _, predicted = torch.max(output, dim=1)
  tag = tags[predicted.item()]
  
  probs = torch.softmax(output, dim=1)
  prob = probs[0][predicted.item()]
  
  if prob.item() > 0.75:
    for intent in intents["intents"]:
      if tag == intent["tag"]:
        # print(random.choice(intent['responses']))
        answer["answer"] = random.choice(intent['responses'])
  else:
    # print("I do not understand...")
    answer["answer"] = "Desculpe, não foi possivel entender sua mensagem, utilize palavras e frases mais simples!"
  print(json.dumps(answer, ensure_ascii=False))


def main() -> None:
  ...

if __name__ == "__main__":
  main()
