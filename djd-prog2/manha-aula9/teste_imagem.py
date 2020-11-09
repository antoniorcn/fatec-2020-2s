import pygame

tela = pygame.display.set_mode((800, 600))

# img_original = pygame.image.load("./fusca.png")
# img_fusca = img_original.convert_alpha()
img_fusca = pygame.image.load("./fusca.png").convert_alpha()

jogar = True
while jogar:
    tela.fill((255, 0, 0))
    tela.blit(img_fusca, (400, 0))
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False