import pygame
import random

pygame.init()

tela = pygame.display.set_mode((800, 600), 0)

while True:
    # Calcular regras
    # x = random.randint(0, 800)
    # y = random.randint(0, 600)
    x, y = pygame.mouse.get_pos()
    w = random.randint(50, 300)
    h = random.randint(50, 300)
    r = random.randint(0, 255)
    g = random.randint(0, 255)
    b = random.randint(0, 255)

    # Pintar
    # tela.fill((0, 0, 0))
    pygame.draw.rect(tela, (r, g, b), ((x, y), (w, h)), 0)
    pygame.display.update()

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            pygame.quit()
