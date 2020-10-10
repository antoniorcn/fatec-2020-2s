def soma_numeros(n1, n2=0):
    return n1 + n2


def soma_multiplica_numeros(n1, n2):
    """
    Esta função soma e multiplica valores
    :param n1: numero 1
    :param n2: numero 2
    :return: soma, multiplicacao
    """
    s = n1 + n2
    m = n1 * n2
    return s, m


s1 = soma_numeros(67, 15)
print(s1)
a, b = soma_multiplica_numeros(3, 4)
print(a, b)
c = soma_multiplica_numeros(2, 9)
print(c)

