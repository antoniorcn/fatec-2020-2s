import pygame

tela = pygame.display.set_mode((800, 600))
nave = pygame.image.load("./nave-small.png")
img_asteroids = pygame.image.load("./asteroid-spritesheet.png")
asteroid = img_asteroids.subsurface((42, 42), (92, 92))


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
asteroids = pygame.sprite.Group(a1)

clk = pygame.time.Clock()

jogar = True
gid = 0
pausa_animacao = 100
contador = 0
while jogar:

    # Calcular regras
    asteroids.update()

    if contador > pausa_animacao:
        top = 40
        margin = 40
        dist_v = 12
        dist_h = 12
        largura = 92
        altura = 92
        colunas = 8
        coluna = gid % colunas
        linha = gid // colunas
        x = margin + (coluna * (largura + dist_h))
        y = top + (linha * (altura + dist_v))
        a1.image = img_asteroids.subsurface((x, y), (largura, altura))
        gid = gid + 1
        if gid >= 32:
            gid = 0
        contador = 0

    contador = contador + 1

    obj = pygame.sprite.groupcollide(asteroids, inimigas, False, True)
    # if obj:
    #     print("Colidiu", obj)
    #     obj.kill()

    tela.fill((0, 0, 0))
    inimigas.draw(tela)
    asteroids.draw(tela)
    pygame.display.update()

    # clk.tick(20)

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False