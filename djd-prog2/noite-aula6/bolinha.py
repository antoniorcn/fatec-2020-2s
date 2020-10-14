import pygame
import math
pygame.init()
tela = pygame.display.set_mode((1280, 768), 0)
PRETA = (0, 0, 0)
AMARELO = (255, 255, 0)
x = 0
y = 0
vel_x = 0.3
vel_y = 0.3
sair = False

# clk = pygame.time.Clock()

# tempo = 0
while not sair:
    # Calcular regras

    # tempo = tempo + 0.1
    # x = math.sin(45) * tempo
    x = x + vel_x;
    y = y + vel_y;
    if x > tela.get_width():
        vel_x = -0.3
    if x < 0:
        vel_x = 0.3
    if y > tela.get_height():
        vel_y = -0.3
    if y < 0:
        vel_y = 0.3

    # Pintar
    tela.fill(PRETA)
    pygame.draw.circle(tela, AMARELO, (int(x), int(y)), 10, 0)
    pygame.display.update()
    # clk.tick(30)

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            sair = True
