import pygame

AMARELO = (255, 255, 0)
tela = pygame.display.set_mode((800, 600))


def casinha(x, y):
    pygame.draw.line(tela, AMARELO, (x, y), (x - 50, y + 50), 2)
    pygame.draw.line(tela, AMARELO, (x, y), (x + 50, y + 50), 2)
    pygame.draw.rect(tela, AMARELO, ((x - 50, y + 50), (100, 100)), 2)


sair = False
while not sair:
    # Calcular regras

    # Desenhar
    casinha(100, 0)
    casinha(400, 0)
    casinha(700, 250)
    pygame.display.update()

    # Capturar eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            sair = True