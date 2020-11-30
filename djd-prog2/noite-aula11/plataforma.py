import pygame

pygame.init()

matrix = [
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",
    "P..............................................................................P",
    "P.......PPPPP..................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P.....................PPPPP....................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
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


class Boy(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.vel_x = 0
        self.vel_y = 0
        self.direita = [28, 27, 28, 29]
        self.estado = self.direita
        self.frame_index = 0
        self.image = self.get_image(self.direita[0])
        self.rect = pygame.Rect((0, 0), self.image.get_size())

    def get_image(self, gid):
        return get_image_by_gid(img_caracters, gid, top=0, margin=0,
                                dist_h=0, dist_v=0, largura=16, altura=16,
                                colunas=12)

    def update(self):
        self.rect.centerx += self.vel_x
        self.rect.centery += self.vel_y

        self.frame_index += 1
        if self.frame_index >= len(self.estado):
            self.frame_index = 0
        gid = self.estado[self.frame_index]
        self.image = self.get_image(gid)

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


def pintar_cenario():
    for linha, conteudo_linha in enumerate(matrix):
        for coluna, caracter in enumerate(conteudo_linha):
            x = coluna * 16
            y = linha * 16
            if caracter == 'P':
                tela.blit(img, (x, y))


player = Boy()
players = pygame.sprite.Group(player)
jogando = True
while jogando:
    # Calcular Regras
    players.update()

    # Pintar
    tela.fill((0, 0, 0))
    pintar_cenario()
    players.draw(tela)
    pygame.display.update()

    # Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False
        player.tratar_evento(e)

