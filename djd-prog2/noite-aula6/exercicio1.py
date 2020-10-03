# Programa para gerar uma lista de numeros aleatórios
from random import randint
lista = []

# Exercicio 1)
# i = 1           # inicialização
# while i <= 7:   # condição
# for i in range(1, 7, 1):
for i in range(7):
    numero = randint(8, 12)
    lista.append(numero)
#    i = i + 1   # incremento
print(lista)

# Exercicio 2) e 3)
# for i in range(7):
#     valor = lista[i]
#     if valor == 10:
#         print("A lista possui o numero 10 e está na posição: ", i)

# Resolução alternativa
# i = 0
tem10 = False
posicao = 0
for i, valor in enumerate(lista):
    if valor == 10:
        # print("A lista possui o numero 10, na posição: ", i)
        posicao = i
        tem10 = True
    # i = i + 1

if tem10:
    print("A lista possui o numero 10, na posição: ", posicao)
else:
    print("Não tem o valor 10 lista")

# palavras = ["FATEC", "Aluno", "Professor", "Sol", "Calor", "Sabado"]

# for i in range(6):
#     print(palavras[i])

# for p in palavras:
#     print(p)

