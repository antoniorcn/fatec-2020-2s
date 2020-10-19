import random

lista = [random.randint(1, 1000) for i in range(100)]
print(lista)

numero = 99
encontrado = False
posicao = -1
for i in range(100):
    if lista[i] == numero:
        encontrado = True
        posicao = i

if encontrado:
    print("O numero 99 existe na lista na posição ", posicao)
else:
    print("O numero 99 não está na lista")