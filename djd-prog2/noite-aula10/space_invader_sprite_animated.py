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


class Aliada(pygame.sprite.Sprite):
    def __init__(self, c, x, y):
        pygame.sprite.Sprite.__init__(self)
        self.vel_x = 0
        self.animacao_parada = SpriteSheetAnimation(img_naves, pausa=30,
                                                     top=9, margin=8, dist_v=1,
                                                     dist_h=1, largura=24, altura=23, colunas=6,
                                                     lista_gids=[69, 70, 71, 0, 1, 2, 1, 0, 71, 70])
        self.animacao_direita = SpriteSheetAnimation(img_naves, pausa=30,
                                             top=9, margin=8, dist_v=1,
                                             dist_h=1, largura=24, altura=23, colunas=6,
                                             lista_gids=range(72))
        self.animacao_esquerda = SpriteSheetAnimation(img_naves, pausa=30,
                                             top=9, margin=8, dist_v=1,
                                             dist_h=1, largura=24, altura=23, colunas=6,
                                             lista_gids=range(71, -1, -1))
        self.animacao = self.animacao_parada
        self.image = self.animacao.get_image()
        self.rect = pygame.Rect((x, y), self.image.get_size())

    def update(self):
        self.image = self.animacao.get_image()
        self.rect.move_ip(self.vel_x, 0)

    def processar_eventos(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                self.animacao = self.animacao_direita
                self.vel_x = 1
            if e.key == pygame.K_LEFT:
                self.animacao = self.animacao_esquerda
                self.vel_x = -1
        if e.type == pygame.KEYUP:
            if e.key in [pygame.K_LEFT, pygame.K_RIGHT]:
                self.animacao = self.animacao_parada
                self.vel_x = 0


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


player = Aliada((255, 255, 0), 400, 550)
a1 = Asteroid()
a2 = Asteroid()
a2.rect.x = 300

jogadores = pygame.sprite.Group(player)
asteroids = pygame.sprite.Group(a1)

clk = pygame.time.Clock()

jogar = True
while jogar:

    # Calcular regras
    asteroids.update()
    jogadores.update()

    obj = pygame.sprite.groupcollide(asteroids, jogadores, False, True)
    # if obj:
    #     print("Colidiu", obj)
    #     obj.kill()

    tela.fill((0, 0, 0))
    jogadores.draw(tela)
    asteroids.draw(tela)
    pygame.display.update()

    # clk.tick(20)

    for e in pygame.event.get():
        player.processar_eventos(e)
        if e.type == pygame.QUIT:
            jogar = False