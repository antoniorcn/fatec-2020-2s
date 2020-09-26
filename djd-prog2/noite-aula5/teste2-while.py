import random
print("Jogo dos dados")
jogar = True
# while jogar == True:
while jogar:
    numero = int(input("Escolha um numero entre 1 e 6"))
    dado = random.randint(1, 6)
    if numero == dado:
        print("Parabens vocês acertou")
    else:
        print(f"Que pena você erro, o dado deu o numero {dado}")
    strNovamente = input("Você deseja jogar novamente (S/N)? ")
    if strNovamente == 'N':
        jogar = False
    # if strNovamente == 'S':
    #    continue
    # else:
    #    break
else:
    print("Obrigado por jogar o jogo de dados")

print("Fim do jogo")
