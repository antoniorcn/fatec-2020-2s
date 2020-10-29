def cabecalho(nome_jogo, nome_autor="desconhecido"):
    print("*" * 80)
    print("*" * 9, "{:^60}".format("Jogo: " + nome_jogo), "*" * 9)
    print("*" * 9, "{:^60}".format("Autor: " + nome_autor), "*" * 9)
    print("*" * 80)


def calcular_quadrado(numero):
    quadrado = numero ** 2
    print(quadrado)
    calcular_raizes(3)
    return quadrado


def calcular_raizes(numero):
    """
    Calcula as raizes do numero e retorna-as
    :param numero:
    :return:
    """
    raiz = numero ** 0.5
    return raiz, -raiz