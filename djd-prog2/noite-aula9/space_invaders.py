import pygame

AMARELO = (255, 255, 0)
tela = pygame.display.set_mode((800, 600))


class Inimiga:
    def __init__(self, c, x, y):
        self.cor = c
        self.x = x
        self.y = y

    def desenhar(self):
        pygame.draw.circle(tela, self.cor, (self.x, self.y), 30, 0)


i1 = Inimiga((255, 0, 0), 100, 150)
i2 = Inimiga((255, 255, 0), 150, 150)
i3 = Inimiga((255, 0, 255), 200, 200)
i4 = Inimiga((0, 255, 255), 250, 200)
i5 = Inimiga((0, 255, 0), 300, 250)

inimigos = [i1, i2, i3, i4, i5]

jogar = True
while jogar:

    for i in inimigos:
        i.desenhar()
        
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False
