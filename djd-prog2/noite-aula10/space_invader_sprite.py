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
        self.vel_x = 1
        self.vel_y = 1

    def update(self):
        self.rect.move_ip(self.vel_x, self.vel_y)
        if self.rect.right > 800:
            self.vel_x = -1
        if self.rect.left < 0:
            self.vel_x = 1
        if self.rect.bottom > 600:
            self.vel_y = -1
        if self.rect.top < 0:
            self.vel_y = 1


i1 = Inimiga((255, 255, 0), 700, 0)
i2 = Inimiga((0, 0, 255), 150, 300)
a1 = Asteroid()
a2 = Asteroid()
a2.rect.x = 300

inimigas = pygame.sprite.Group(i1, i2)
asteroids = pygame.sprite.Group(a1, a2)

jogar = True
while jogar:

    # Calcular regras
    asteroids.update()

    obj = pygame.sprite.groupcollide(asteroids, inimigas, True, True)
    # if obj:
    #     print("Colidiu", obj)
    #     obj.kill()

    tela.fill((0, 0, 0))
    inimigas.draw(tela)
    asteroids.draw(tela)
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False