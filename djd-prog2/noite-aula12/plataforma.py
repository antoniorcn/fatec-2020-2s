import pygame

pygame.init()

GRAVIDADE = 0.0009

matrix = [
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",
    "P..............................................................................P",
    "P.......PPPPP..................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P.....................PPPPP....................................................P",
    "P..............................................................................P",
    "P.......................J......................................................P",
    "P.....PPPPP....................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"
]


def get_image_by_gid(img_spritesheet, gid,
                     top=0, margin=0,
                     dist_v=0, dist_h=0,
                     largura=16, altura=16, colunas=8):
    coluna = gid % colunas
    linha = gid // colunas
    x = margin + (coluna * (largura + dist_h))
    y = top + (linha * (altura + dist_v))
    img = img_spritesheet.subsurface((x, y), (largura, altura))
    return img


tela = pygame.display.set_mode((800, 600), 0)
img_tileset = pygame.image.load("./basictiles.png").convert_alpha()
img_caracters = pygame.image.load("./characters.png").convert_alpha()
img = get_image_by_gid(img_tileset, 15)
font = pygame.font.SysFont("arial", 40, False, False)


class Bloco(pygame.sprite.Sprite):
    def __init__(self, linha, coluna):
        pygame.sprite.Sprite.__init__(self)
        self.image = img
        x = coluna * img.get_width()
        y = linha * img.get_height()
        self.rect = pygame.Rect((x, y), img.get_size())


class Tiro(pygame.sprite.Sprite):
    def __init__(self, pos):
        pygame.sprite.Sprite.__init__(self)
        self.life = 100
        self.vel_x = 1
        self.frames = [60, 61]
        self.frame_index = 0
        self.frame_pausa = 50
        self.frame_ciclo= 0
        self.image = self.get_image()
        self.rect = pygame.Rect(pos, self.image.get_size())

    def get_image(self):
        self.frame_ciclo += 1
        if self.frame_ciclo > self.frame_pausa:
            self.frame_index += 1
            self.frame_ciclo = 0
        if self.frame_index >= len(self.frames):
            self.frame_index = 0
        gid = self.frames[self.frame_index]
        return get_image_by_gid(img_tileset, gid, top=0, margin=0,
                                dist_h=0, dist_v=0, largura=16, altura=16,
                                colunas=8)

    def update(self):
        self.image = self.get_image()
        self.rect.centerx += self.vel_x
        self.life -= 0.3
        if self.life <= 0:
            self.kill()


class Boy(pygame.sprite.Sprite):
    def __init__(self, linha, coluna):
        pygame.sprite.Sprite.__init__(self)
        self.vel_x = 0
        self.vel_y = 0
        self.pontos = 0
        self.direita = [28, 27, 28, 29]
        self.estado = self.direita
        self.frame_index = 0
        self.image = self.get_image(self.direita[0])
        x = coluna * self.image.get_width()
        y = linha * self.image.get_height()
        self.rect = pygame.Rect((x, y), self.image.get_size())
        self.intencao = list(self.rect.center)

    def get_image(self, gid):
        return get_image_by_gid(img_caracters, gid, top=0, margin=0,
                                dist_h=0, dist_v=0, largura=16, altura=16,
                                colunas=12)

    def update(self):
        self.vel_y += GRAVIDADE
        self.intencao[0] += self.vel_x
        self.intencao[1] += self.vel_y

        self.frame_index += 1
        if self.frame_index >= len(self.estado):
            self.frame_index = 0
        gid = self.estado[self.frame_index]
        self.image = self.get_image(gid)

    def testar_colisao(self, grupo):
        temp = list(self.rect.center)
        self.rect.center = self.intencao
        if pygame.sprite.spritecollide(self, grupo, False):
            self.intencao = temp
            self.rect.center = temp
            self.vel_x = 0
            self.vel_y = 0
            self.pontos -= 1
        else:
            self.pontos += 0.001
        if self.pontos < 0:
            self.pontos = 0

    def tratar_evento(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                self.vel_x = 1
            if e.key == pygame.K_LEFT:
                self.vel_x = -1
            if e.key == pygame.K_UP:
                self.vel_y = -1
            if e.key == pygame.K_DOWN:
                self.vel_y = 1
        if e.type == pygame.KEYUP:
            if e.key in [pygame.K_RIGHT, pygame.K_LEFT]:
                self.vel_x = 0
            if e.key in [pygame.K_UP, pygame.K_DOWN]:
                self.vel_y = 0


def criar_cenario(grupo):
    player = None
    for linha, conteudo_linha in enumerate(matrix):
        for coluna, caracter in enumerate(conteudo_linha):
            if caracter == 'P':
                blk = Bloco(linha, coluna)
                grupo.add(blk)
            if caracter == 'J':
                player = Boy(linha, coluna)
    return player


plataformas = pygame.sprite.Group()
player = criar_cenario(plataformas)
players = pygame.sprite.Group(player)
tiros = pygame.sprite.Group()
jogando = True
while jogando:
    # Calcular Regras
    players.update()
    tiros.update()
    player.testar_colisao(plataformas)

    # Pintar
    txt_pontos = font.render("Pontos: {0:.2f}".format(player.pontos), True, (255, 255, 0))
    tela.fill((0, 0, 0))
    plataformas.draw(tela)
    players.draw(tela)
    tiros.draw(tela)
    tela.blit(txt_pontos, (100, 50))
    pygame.display.update()

    # Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False
        player.tratar_evento(e)
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_SPACE:
                tiro = Tiro((player.rect.centerx, player.rect.top))
                tiros.add(tiro)

