lista = [i for i in range(0, 11)]
print(lista)


sublista1 = lista[0:5:2]
print(sublista1)

sublista2 = lista[5::-1]
print(sublista2)

lista.append(200)
print(lista)

a = len(lista)
print(a)

lista_inversa = lista[::-1]
print(lista_inversa)

b = [30, 40, 50]
lista.extend(b)
print(lista)

# lista.append(b)
# print(lista)

lista.remove(200)
print(lista)

b = lista.pop(7)
print(b)
print(lista)

lista.append(10)
print(lista)
try:
    pos = lista.index(10, 11)
    print(pos)
except:
    print("Não tem este valor na lista")

c = lista.count(10)
print(c)

lista.reverse()
print(lista)