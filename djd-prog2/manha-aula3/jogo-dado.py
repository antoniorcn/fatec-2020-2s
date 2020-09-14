import random

print("J O G O   D O   D A D O")
numero = 0
while numero < 1 or numero > 6:
    # texto = input("Escolha um numero (entre 1 e 6)")
    # if texto.isnumeric():
    #     numero = int(texto)
    # else:
    #     print("Por favor digite um numero inteiro")

    try:
        numero = int(input("Escolha um numero (entre 1 e 6)"))
    except ValueError as e:
        print("Por favor digite um numero inteiro")
        numero = 0
dado = random.randint(1, 6)

print("Jogando o dado, o numero que mostrou foi ", dado)
if dado == numero:
    print("PARABÉNS")
    print("VOCÊ")
    print("G A N H O U")
else:
    print("QUE PENA")
    print("VOCÊ")
    print("P E R D E U")
print("Fim do jogo")
