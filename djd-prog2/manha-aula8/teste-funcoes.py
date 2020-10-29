from funcoes import cabecalho, calcular_quadrado, calcular_raizes

print("Inicio do Jogo")
cabecalho("Mario", "Joao Silva")
cabecalho(nome_autor="Antonio Rodrigues", nome_jogo="Pacman")
a = calcular_quadrado(5)
b = a / 4
print(b)

r1, r2 = calcular_raizes(9)
print(r1)
print(r2)
r3, r4 = calcular_raizes()
print("Fim do Jogo")


