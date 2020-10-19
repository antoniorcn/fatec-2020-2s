import random

lista = [random.randint(1, 100) for i in range(100)]
lista.sort()
print(lista)

numero = int(input("Digite um numero"))

if numero in lista:
    print("O numero está na lista")
else:
    print("O numero não esta na lista")