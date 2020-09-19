capacidade = 50
pessoas = 70

if capacidade > pessoas:
    locais_vagos = capacidade - pessoas
    # print("Há locais disponíveis para {} pessoas".format(locais_vagos))
    print(f'Há locais disponíveis para {locais_vagos} pessoas')
else:
    if capacidade == pessoas:
        print("O estabelecimento está com a capacidade total")
    else:
        print("O estabelecimento está super lotado, com mais pessoas do que o permitido")

print("Terminou o programa")


