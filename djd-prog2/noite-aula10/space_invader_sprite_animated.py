import pygame

tela = pygame.display.set_mode((800, 600))
nave = pygame.image.load("./nave-small.png")
img_asteroids = pygame.image.load("./asteroid-spritesheet.png").convert_alpha()
img_naves = pygame.image.load("./nave-spritesheet.png").convert_alpha()
asteroid = img_asteroids.subsurface((42, 42), (92, 92))


def get_image_by_gid(img_spritesheet, gid,
                     top=40, margin=40,
                     dist_v=12, dist_h=12,
                     largura=92, altura=92, colunas=8):
    coluna = gid % colunas
    linha = gid // colunas
    x = margin + (coluna * (largura + dist_h))
    y = top + (linha * (altura + dist_v))
    img = img_spritesheet.subsurface((x, y), (largura, altura))
    return img


class SpriteSheetAnimation:
    def __init__(self, img_spritesheet, lista_gids, pausa=10, top=40, margin=40, dist_v=12,
                 dist_h=12, largura=92, altura=92, colunas=8):
        self.img_spritesheet = img_spritesheet
        self.lista_gids = lista_gids
        self.imagem_indice = 0
        self.animacao_pausa = pausa
        self.animacao_contador = 0
        self.top = top
        self.margin = margin
        self.dist_v = dist_v
        self.dist_h = dist_h
        self.largura = largura
        self.altura = altura
        self.colunas = colunas

    def get_image(self):
        self.animacao_contador += 1
        if self.animacao_contador > self.animacao_pausa:
            self.imagem_indice = self.imagem_indice + 1
            self.animacao_contador = 0
        if self.imagem_indice >= len(self.lista_gids):
            self.imagem_indice = 0
        gid = self.lista_gids[self.imagem_indice]
        img = get_image_by_gid(self.img_spritesheet, gid, top=self.top, margin=self.margin,
                               dist_v=self.dist_v, dist_h=self.dist_h, largura=self.largura,
                               altura=self.altura, colunas=self.colunas)
        return img


class Inimiga(pygame.sprite.Sprite):
    def __init__(self, c, x, y):
        pygame.sprite.Sprite.__init__(self)
        self.cor = c
        self.image = nave
        self.rect = pygame.Rect((x, y), self.image.get_size())
        self.animacao = SpriteSheetAnimation(img_naves, pausa=30,
                                             top=8, margin=8, dist_v=1,
                                             dist_h=1, largura=24, altura=24, colunas=6,
                                             lista_gids=[0, 1, 2, 3, 4, 5, 4, 3, 2, 1])

    def update(self):
        self.image = self.animacao.get_image()


class Asteroid(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.image = asteroid
        self.rect = pygame.Rect((0, 0), self.image.get_size())
        self.vel_x = 0
        self.vel_y = 0
        self.animacao = SpriteSheetAnimation(img_asteroids, pausa=100,
                                             lista_gids=[1, 3, 5, 7, 9, 11, 13, 15, 13, 11, 9, 7, 5, 3])

    def update(self):
        self.image = self.animacao.get_image()
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
while jogar:

    # Calcular regras
    asteroids.update()
    inimigas.update()

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