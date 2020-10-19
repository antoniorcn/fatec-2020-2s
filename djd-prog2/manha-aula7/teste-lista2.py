lista = [2, 3, 4, 5, 6]

lista2 = ["c", "a", "b", "c"]

lista.extend(lista2)
lista.insert(0, "A")
lista.remove("b")
print(lista)


a = lista[3]
print("Antes do POP", lista)
b = lista.pop(3)
print("Depois do POP", lista)

try:
    pos = lista.index(99)
    print("Numero 99 esta na posicao", pos)
except ValueError as e:
    print("Numero 99 não encontrado")

print("Letras (c) existenes na lista", lista.count("c"))

lista.reverse()
print(lista)

mesma_lista = lista
lista_nova = lista.copy()
lista_nova2 = lista[::]

a = lista[5]
print('A: ', a,  '\t\tLista: ', lista)

b = lista.pop(5)
print('B: ', b,  '\t\tLista: ', lista)
