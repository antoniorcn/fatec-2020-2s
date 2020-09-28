import pygame
import random
AMARELO = (255, 255, 0)
VERMELHO = (255, 0, 0)
pygame.init()

tela = pygame.display.set_mode((800, 600), 0)

while True:
    # Calculo de Regras

    # Pintar
    # Red Green Blue
    # tela.set_at((400, 300), (255, 255, 0))
            #        Tela    Cor            Inicio    Fim     Espessura
    # pygame.draw.line(tela, (255, 255, 0), (0, 600), (800, 0), 5)
    # pygame.draw.line(tela,
    #                  (random.randint(1, 255), random.randint(1, 255), random.randint(1, 255)),
    #                  (400, 300),
    #                  (random.randint(1, 800), random.randint(1, 600)), 5)

    # Telhado
    pygame.draw.line(tela, VERMELHO, (400, 0), (600, 150), 5)
    pygame.draw.line(tela, VERMELHO, (400, 0), (200, 150), 5)

    # Paredes
    # pygame.draw.line(tela, AMARELO, (200, 150), (200, 450), 5)
    # pygame.draw.line(tela, AMARELO, (600, 150), (600, 450), 5)
    # pygame.draw.line(tela, AMARELO, (200, 450), (600, 450), 5)

    # Teto
    # pygame.draw.line(tela, AMARELO, (200, 150), (600, 150), 5)

    pygame.draw.rect(tela, AMARELO, ((200, 150), (400, 300)), 0)

    pygame.display.update()

    # Captura os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            pygame.quit()
