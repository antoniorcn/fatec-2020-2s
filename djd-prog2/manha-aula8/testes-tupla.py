import pygame
lista_posicao = [200, 150]
lista_posicao[0] = 400
tupla_posicao = (200, 150)
pos = (200, 150)
tamanho = (50, 100)

tamanho_tela = (800, 600)
amarelo = (255, 255, 0)
tela = pygame.display.set_mode(tamanho_tela, 0)
pygame.draw.rect(tela, amarelo, (pos, tamanho))


lista = [1, 2, 3]
tup = ("Texto qualquer", lista)

# l = tup[1]
# l.append(4)
# print(tup[1])

tup[1].append(5)
print(tup)

