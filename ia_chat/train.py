import json
import numpy as np
from model import NeuralNet
from nltk_utils import tokenize, stem, bag_of_words

import torch
import torch.nn as nn
from torch.utils.data import Dataset, DataLoader

class ChatDataset(Dataset):
  def __init__(self, x_train, y_train) -> None:
    self.n_samples = len(x_train)
    self.x_data = x_train
    self.y_data = y_train

  def __getitem__(self, index):
    return self.x_data[index], self.y_data[index]

  def __len__(self):
    return self.n_samples

def train():
  with open('intents.json', 'r') as file:
    intents = json.load(file)

  all_words = []
  tags = []
  xy = []

  for intent in intents['intents']:
    tag = intent['tag']
    tags.append(tag)
    for pattern in intent['patterns']:
      w = tokenize(pattern)
      all_words.extend(w)
      xy.append((w, tag))

  ignore_words = ['?', '!', '.', ',']
  all_words = [stem(w) for w in all_words if w not in ignore_words]
  all_words = sorted(set(all_words))
  tags = sorted(set(tags))
  print(tags)

  x_train = []
  y_train = []
  for (pattern_sentence, tag) in xy:
    bag = bag_of_words(pattern_sentence, all_words)
    x_train.append(bag)

    label = tags.index(tag)
    y_train.append(label)

  x_train = np.array(x_train)
  y_train = np.array(y_train)

  # Hyprparameters
  batch_size = 8
  input_size = len(all_words)
  hidden_size = 8
  output_size = len(tags)
  learning_rate = 0.001
  num_epochs = 1000

  dataset = ChatDataset(x_train, y_train)
  train_loader = DataLoader(dataset=dataset, batch_size=batch_size, shuffle=True, num_workers=0)

  device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
  model = NeuralNet(input_size, hidden_size, output_size).to(device)

  # Loss and optimizer
  criterion = nn.CrossEntropyLoss()
  optimizer = torch.optim.Adam(model.parameters(), lr=learning_rate)

  for epoch in range(num_epochs):
    for (words, labels) in train_loader:
      words = words.to(device)
      labels = labels.long().to(device)  # Converte as labels para LongTensor

      # Forward
      outputs = model(words)
      loss = criterion(outputs, labels)

      # Backward and optimizer
      optimizer.zero_grad()
      loss.backward()
      optimizer.step()

    if (epoch + 1) % 100 == 0:
      print(f"epoch {epoch + 1}/{num_epochs}, loss={loss.item():.4f}")

  print(f"final_loss={loss.item():.4f}")

  data = {
    "model_state": model.state_dict(),
    "input_size": input_size,
    "output_size": output_size,
    "hidden_size": hidden_size,
    "all_words": all_words,
    "tags": tags,
  }

  FILE = "data.pth"
  torch.save(data, FILE)

  print(f"Training complete. File saved to {FILE}")

def main():
  train()

if __name__ == "__main__":
  main()