# link_mochila_0 = "espada"
# link_mochila_1 = "escudo"
# link_mochila_2 = "vida"
# link_mochila_3 = "flecha"

# print(link_mochila_0, link_mochila_1, link_mochila_2, link_mochila_3)

mochila = ["espada", "escudo", "vida", "flecha"]
mochila[3] = "concha"  #  ["espada", "escudo", "vida", "concha"]
print(mochila[3])

texto = "As strings são elementos iteraveis"
lista_texto = []
print(lista_texto)
lista_texto = list(texto)
print(lista_texto)

b = [1000, [3, 4, 5], True, "Bianca"]

print(b[1][0])



# Criar lista com os numeros de 1 a 10000
# numeros = []
# for i in range(1, 10000):
#     numeros.append(i)
# print(numeros)

numeros = [i for i in range(1, 100, 2)]
print(numeros)

novalista = numeros[::]
print(novalista)

lista = [5, 7, 9, 11]
lista2 = lista
lista[3] = 20
print(lista2[3])