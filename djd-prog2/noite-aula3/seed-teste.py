import random
numeros = [1, 2, 3]
novo_seed = random.choice(numeros)
random.seed(novo_seed)
numero1 = random.randint(0, 100)
numero2 = random.randint(0, 100)
numero3 = random.randint(0, 100)
numero4 = random.randint(0, 100)
numero5 = random.randint(0, 100)
numero6 = random.randint(0, 100)
print(numero1, numero2, numero3, numero4, numero5, numero6)