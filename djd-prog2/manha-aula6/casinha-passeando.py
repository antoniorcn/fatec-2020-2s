import pygame

pygame.init()
AMARELO = (255, 255, 0)
VERMELHO = (255, 0, 0)
PRETO = (0, 0, 0)

tela = pygame.display.set_mode((800, 600), 0)


def desenhar_casinha(x, y=0):
    altura = 100
    largura = 100
    altura_telhado = altura * 3//4
    x1 = x - largura // 2
    y1 = y - altura // 2
    x2 = x
    y2 = y1 - altura_telhado
    x3 = x1 + largura
    y3 = y1
    pygame.draw.rect(tela, VERMELHO, ((x1, y1), (largura, altura)), 0)
    pygame.draw.line(tela, VERMELHO, (x1, y1), (x2, y2), 2)
    pygame.draw.line(tela, VERMELHO, (x2, y2), (x3, y3), 2)

x = 10
velocidade = 0.3
jogando = True
while jogando:
    # Calculo regras
    x = x + velocidade
    if x > 800:
        velocidade = -0.3

    if x < 0:
        velocidade = 0.3

    # Pintar
    tela.fill(PRETO)
    # pygame.draw.circle(tela, AMARELO, (int(x), 250), 20, 0)
    desenhar_casinha(int(x), 250)
    pygame.display.update()

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False