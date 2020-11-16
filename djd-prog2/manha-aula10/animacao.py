import pygame

tela = pygame.display.set_mode((800, 600))

imgSpriteSheet = pygame.image.load("./EpicArmor.png")

gid = 10
jogar = True
clk = pygame.time.Clock()
while jogar:
    # Calcular regras
    gid += 1
    if gid > 17:
        gid = 10

    # Pintar na tela
    colunas = 9
    coluna = gid % colunas
    linha = gid // colunas
    x = coluna * 64
    y = linha * 64
    r = pygame.Rect((x, y), (64, 64))
    img = imgSpriteSheet.subsurface(r)

    tela.fill((0, 0, 0))
    tela.blit(img, (100, 100))
    pygame.display.update()

    clk.tick(10)

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False


