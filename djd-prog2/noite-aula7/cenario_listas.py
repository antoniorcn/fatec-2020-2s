import pygame

cenario = ["-####------#---------------###----------",
           "--#####---------------------------------",
           "----------####--------------------------",
           "-------------#--------------------------",
           "-------------#--------------------------",
           "------------##--------------------------",
           "--------------##--------------##--------",
           "----------------------------------------",
           "-----##-------------------------##------",
           "----------------------------------##----"]

AMARELO = (255, 255, 0)
PRETO = (0, 0, 0)

pygame.init()

tela = pygame.display.set_mode((800, 600), 0)

largura = 800 // 40
altura = 600 // 10


jogar = True
while jogar:
    # Calcular Regras

    # Desenhar

    for lin in range(len(cenario)):
        linha = cenario[lin]
        for col in range(len(linha)):
            celula = linha[col]
            cor = AMARELO
            if celula == '-':
                cor = PRETO
            x = col * largura
            y = lin * altura
            r = pygame.Rect((x, y), (largura, altura))
            pygame.draw.rect(tela, cor, r, 0)

    pygame.display.update()

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False;

