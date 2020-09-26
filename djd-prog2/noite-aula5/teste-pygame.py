import pygame
import random

pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
AMARELO = (255, 255, 0)

while True:             # Loop do Jogo
    # Calcular as regras

    # Pintar a tela
    # RGB (Red, Green, Blue)
    # tela.fill((0, 0, 0))
    tela.set_at((400, 300), AMARELO)
    # tela.set_at((400, 300), (255, 255, 0))
    r = random.randint(0, 255)
    g = random.randint(0, 255)
    b = random.randint(0, 255)
    x = random.randint(0, 750)
    y = random.randint(0, 550)
    w = random.randint(20, 200)
    h = random.randint(20, 200)
    pygame.draw.rect(tela, (r, g, b), ((x, y), (w, h)), 0)
    pygame.display.update()

    # Capturar eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

