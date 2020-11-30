import pygame

pygame.init()

tela = pygame.display.set_mode((800, 600), 0)
img_ssheet_fundo = pygame.image.load("./assets/basictiles.png").convert_alpha()
img_ssheet_characters = pygame.image.load("./assets/characters.png").convert_alpha()

estado = "JOGANDO"

matriz = [
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P......................................................PPPPPP..................P",
    "P........................................PPPPPPP...............................P",
    "P.....................PPPPPPP..................................................P",
    "P......PPPPPP..................................................................P",
    "P..............................................................................P",
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"
]


def get_image_by_gid(spritesheet, gid, columns=8, w=16, h=16,
                     spc_h=0, spc_v=0, margin_left=0, margin_top=0):
    linha = gid // columns
    coluna = gid % columns
    x = margin_left + (coluna * (w + spc_h))
    y = margin_top + (linha * (h + spc_v))
    return spritesheet.subsurface((x, y), (w, h))


img_plataforma = get_image_by_gid(img_ssheet_fundo, 4)


def pintar_linha(linha, conteudo):
    y = linha * img_plataforma.get_height()
    for coluna, caracter in enumerate(conteudo):
        x = coluna * img_plataforma.get_width()
        if caracter == "P":
            tela.blit(img_plataforma, (x, y))
        elif caracter == ".":
            pass


def pintar_cenario():
    for linha, conteudo_linha in enumerate(matriz):
        pintar_linha(linha, conteudo_linha)


class Player(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.vel_x = 0
        self.vel_y = 0
        self.cicle_pause = 10
        self.cicle_count = 0
        self.indice = 0
        self.andando_cima = [40, 39, 40, 41]
        self.andando_baixo = [4, 3, 4, 5]
        self.andando_esquerda = [16, 15, 16, 17]
        self.andando_direita = [28, 27, 28, 29]
        self.parado_cima = [40]
        self.parado_baixo = [4]
        self.parado_esquerda = [16]
        self.parado_direita = [28]
        self.frames = self.andando_baixo
        self.image = self.get_image(4)
        self.rect = pygame.Rect((0, 0), (16, 16))

    def get_image(self, gid):
        img = get_image_by_gid(spritesheet=img_ssheet_characters, gid=gid, columns=12,
                               w=16, h=16, spc_v=0, spc_h=0, margin_left=0, margin_top=0)
        return img

    def update(self):
        self.cicle_count += 1
        if self.cicle_count > self.cicle_pause:
            self.cicle_count = 0
            self.indice += 1
        if self.indice >= len(self.frames):
            self.indice = 0
        gid = self.frames[self.indice]
        self.image = self.get_image(gid)
        self.rect.x += self.vel_x
        self.rect.y += self.vel_y

    def tratar_eventos(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                self.vel_x = -1
                self.frames = self.andando_esquerda
            if e.key == pygame.K_RIGHT:
                self.vel_x = 1
                self.frames = self.andando_direita
            if e.key == pygame.K_UP:
                self.vel_y = -1
                self.frames = self.andando_cima
            if e.key == pygame.K_DOWN:
                self.vel_y = 1
                self.frames = self.andando_baixo
        if e.type == pygame.KEYUP:
            if e.key == pygame.K_LEFT:
                self.vel_x = 0
                self.frames = self.parado_esquerda
            if e.key == pygame.K_RIGHT:
                self.vel_x = 0
                self.frames = self.parado_direita
            if e.key == pygame.K_UP:
                self.vel_y = 0
                self.frames = self.parado_cima
            if e.key == pygame.K_DOWN:
                self.vel_y = 0
                self.frames = self.parado_baixo



player1 = Player()
players = pygame.sprite.Group(player1)


jogar = True
while jogar:
    # calcular as regras
    if estado == "JOGANDO":
        players.update()

    # pintar a tela
    tela.fill((0, 0, 0))
    pintar_cenario()
    players.draw(tela)
    pygame.display.update()
    # pygame.time.delay(100)

    # captura os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_p:
                if estado == "JOGANDO":
                    estado = "PAUSADO"
                else:
                    estado = "JOGANDO"

        if estado == "JOGANDO":
            player1.tratar_eventos(e)
