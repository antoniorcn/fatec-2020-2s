print("Inicio do Jogo")
i = 1
while i <= 3:
    print("Contra")
    print(".")
    i = i + 1
    if i < 3:
        continue
    if i == 3:
        break
else:
    print("Encerramento do laço while")
print("Fim do Jogo")
