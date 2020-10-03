lista = []

lista = list()

mochila_do_link = ["poção", "flecha", "pedra", "pena"]

palavra = list("FATEC")
print(palavra)

numeros = [i for i in range(0, 150)]
print(numeros)

tabuleiro = [[(i + j) % 2 == 0 for j in range(0, 8)] for i in range(0, 8)]
for linha in tabuleiro:
    print(linha)

vogais = ["A", "E", "I", "O", "U"]
vogais.append("Y")
for v in vogais:
    print(v)

lista1 = []
lista1.append(randint(1, 100))


