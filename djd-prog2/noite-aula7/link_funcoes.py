link = {}
link['arma'] = 'espada'
link['defesa'] = 'escudo bronze'
link['hp'] = 100
link['vidas'] = 3


def cabecalho():
    print("*" * 80)
    print(("*" * 20 + "{:^40s}" + "*" * 20).format("Jogo do Link"))
    print(("*" * 20 + "{:<40s}" + "*" * 20).format("  Mochila"))
    print(("*" * 20 + "{:<40s}" + "*" * 20).format(str(link.keys())))
    print("*" * 80)


def verificaItem(item):
    if item in link:
        print(link[item])
    else:
        print("Não há chapeu na lista de itens")


def calculaTotalHP():
    total = link['hp'] * link['vidas']
    return total


jogar = True
while jogar:
    cabecalho()
    v = input("Qual item você deseja ver: ")

    verificaItem(v)

    t = calculaTotalHP()
    print("Link possui no total {} hp".format(t))

    cabecalho()
    continuar = input("Deseja continuar jogando ? (S/N)")
    if continuar == "N":
        jogar = False



