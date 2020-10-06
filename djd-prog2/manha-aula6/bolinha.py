import pygame

pygame.init()
AMARELO = (255, 255, 0)
VERMELHO = (255, 0, 0)
PRETO = (0, 0, 0)

tela = pygame.display.set_mode((800, 600), 0)
x = 10
y = 10
velocidade_x = 0.3
velocidade_y = 1.3
cor = AMARELO
jogando = True
while jogando:
    # Calculo regras
    x = x + velocidade_x
    y = y + velocidade_y
    if x > 800:
        velocidade_x = -0.3
    if x < 0:
        velocidade_x = 0.3

    if y > 600:
        cor = VERMELHO
        velocidade_y = -1.3
    if y < 0:
        cor = AMARELO
        velocidade_y = 1.3

    # Pintar
    tela.fill(PRETO)
    pygame.draw.circle(tela, cor, (int(x), int(y)), 20, 0)
    pygame.display.update()

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False
