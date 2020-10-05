import pygame
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
VERMELHO = (255, 0, 0)


def ponto_na_tela(x, y):
    na_tela = x > 0 and x < 800 and y > 0 and y < 600
    return na_tela


def desenhar_casinha(x, y=0):
    # Calcular Regras
    # x = 500
    # y = 400
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
    # dentro_tela = x1 > 0 and x1 < 800 and y1 > 0 and y1 < 600 and x2 > 0 and x2 < 800 and y2 > 0 and y2 < 800
    # dentro_tela = 0 < x1 < 800 and 0 < y1 < 600 and 0 < x2 < 800 and 0 < y2 < 800
    dentro_tela = ponto_na_tela(x1, y1) and ponto_na_tela(x2, y2) and ponto_na_tela(x3, y3)
    return dentro_tela


jogando = True
while jogando:          # Loop do Jogo
    d1 = desenhar_casinha(260, 150)
    pygame.display.update()
    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False
            print("Casinha 1 dentro da tela: ", d1)
