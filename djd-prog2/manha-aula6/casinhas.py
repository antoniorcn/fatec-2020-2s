import pygame
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
VERMELHO = (255, 0, 0)

jogando = True
while jogando:          # Loop do Jogo
    # Calcular Regras
    x = 500
    y = 400
    altura = 100
    largura = 100
    altura_telhado = altura * 3//4
    x1 = x - largura // 2
    y1 = y - altura // 2
    x2 = x
    y2 = y1 - altura_telhado
    x3 = x1 + largura
    y3 = y1

    # Pintar na Tela
    pygame.draw.rect(tela, VERMELHO, ((x1, y1), (largura, altura)), 0)
    pygame.draw.line(tela, VERMELHO, (x1, y1), (x2, y2), 2)
    pygame.draw.line(tela, VERMELHO, (x2, y2), (x3, y3), 2)
    pygame.display.update()

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False
