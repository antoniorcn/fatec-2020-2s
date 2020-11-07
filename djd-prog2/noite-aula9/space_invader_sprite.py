import pygame

tela = pygame.display.set_mode((800, 600))
nave = pygame.image.load("./nave-small.png")
asteroid = pygame.image.load("./asteroid-small.png")


class Inimiga(pygame.sprite.Sprite):
    def __init__(self, c, x, y):
        pygame.sprite.Sprite.__init__(self)
        self.cor = c
        self.image = nave
        self.rect = pygame.Rect((x, y), self.image.get_size())


class Asteroid(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.image = asteroid
        self.rect = pygame.Rect((0, 0), self.image.get_size())


i1 = Inimiga((255, 255, 0), 100, 200)
i2 = Inimiga((0, 0, 255), 150, 300)
a1 = Asteroid()

inimigas = pygame.sprite.Group(i1, i2)
asteroids = pygame.sprite.Group(a1)

jogar = True
while jogar:

    inimigas.draw(tela)
    asteroids.draw(tela)
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False