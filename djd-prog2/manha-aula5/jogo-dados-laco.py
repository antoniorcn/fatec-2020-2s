import random
print("Jogo de dados")
em_jogo = True
# i = 1
# while i == 1:
while em_jogo:
    numero = int(input("Por favor digite um numero de 1 a 6"))
    dado = random.randint(1, 6)
    if numero == dado:
        print("Parabéns você acertou")
    else:
        # print("Que pena você perdeu o dado mostrou o numero {}".format(dado))
        print(f"Que pena você perdeu o dado mostrou o numero {dado}")
    resposta = input("Você deseja jogar novamente (S/N)")
    if resposta == 'N':
        em_jogo = False
        # i = 2
    # if resposta == 'N':
    #    break
print("Fim do jogo")
