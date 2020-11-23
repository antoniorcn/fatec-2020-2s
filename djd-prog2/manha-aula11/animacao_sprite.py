import pygame

tela = pygame.display.set_mode((800, 600))
sprite_sheet_sara = pygame.image.load("./sara.png")
sprite_sheet_tiles = pygame.image.load("./basictiles.png")
estado = "JOGANDO"

cenario = [
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
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",
]


def pegar_imagem_por_gid(spritesheet, gid=0, largura=64, altura=64,
                         margin=0, top=0, espac_h=0, espac_v=0,
                         colunas=9):
    coluna = gid % colunas
    linha = gid // colunas
    x = ((coluna + espac_h) * largura) + margin
    y = ((linha + espac_v) * altura) + top
    r = pygame.Rect((x, y), (largura, altura))
    img = spritesheet.subsurface(r)
    return img


def desenhar_cenario(surface, matriz):
    for linha, nivel in enumerate(matriz):
        for coluna, caracter in enumerate(nivel):
            gid = 22
            if caracter == 'P':
                gid = 15
            x = coluna * 64
            y = linha * 64
            img = pegar_imagem_por_gid(sprite_sheet_tiles, gid, colunas=8)
            surface.blit(img, (x, y))


class Sara(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.frame_indice = 0
        self.andando_cima = [104, 105, 106, 107, 108, 109, 110, 111, 112]
        self.parado_cima = [0, 1, 2, 3, 4, 5, 6]
        self.andando_baixo = [130, 131, 132, 133, 134, 135, 136, 137, 138]
        self.parado_baixo = [26, 27, 28, 29, 30, 31, 32]
        self.andando_esquerda = [117, 118, 119, 120, 121, 122, 123, 124, 125]
        self.parado_esquerda = [13, 14, 15, 16, 17, 18, 19]
        self.andando_direita = [143, 144, 145, 146, 147, 148, 149, 150, 151]
        self.parado_direita = [39, 40, 41, 42, 43, 44, 45]
        self.tempo_animacao = 5
        self.contador_tempo = 0
        self.lista_frames = self.andando_cima
        self.image = self.get_frame()
        self.vel_x = 0
        self.vel_y = 0
        self.rect = pygame.Rect((200, 200), self.image.get_size())

    def get_frame(self):
        self.contador_tempo += 1
        if self.contador_tempo > self.tempo_animacao:
            self.frame_indice += 1
            self.contador_tempo = 0
        if self.frame_indice >= len(self.lista_frames):
            self.frame_indice = 0
        frame = self.lista_frames[self.frame_indice]
        return pegar_imagem_por_gid(sprite_sheet_sara, frame,
                                    largura=64, altura=64, colunas=13)

    def update(self):
        self.image = self.get_frame()
        self.rect.left += self.vel_x
        self.rect.top += self.vel_y

    def processar_evento(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                self.lista_frames = self.andando_esquerda
                self.vel_x = -1
            if e.key == pygame.K_RIGHT:
                self.lista_frames = self.andando_direita
                self.vel_x = 1
            if e.key == pygame.K_UP:
                self.lista_frames = self.andando_cima
                self.vel_y = -1
            if e.key == pygame.K_DOWN:
                self.lista_frames = self.andando_baixo
                self.vel_y = 1
        if e.type == pygame.KEYUP:
            if e.key == pygame.K_LEFT:
                self.lista_frames = self.parado_esquerda
                self.vel_x = 0
            if e.key == pygame.K_RIGHT:
                self.lista_frames = self.parado_direita
                self.vel_x = 0
            if e.key == pygame.K_UP:
                self.lista_frames = self.parado_cima
                self.vel_y = 0
            if e.key == pygame.K_DOWN:
                self.lista_frames = self.parado_baixo
                self.vel_y = 0


player1 = Sara()
player1.rect.topleft = (300, 300)
jogadores = pygame.sprite.Group(player1)
jogar = True
clk = pygame.time.Clock()
while jogar:
    # Calcular regras
    if estado == "JOGANDO":
        jogadores.update()

    # Pintar na tela
    if estado == "JOGANDO":
        tela.fill((0, 0, 0))
        desenhar_cenario(tela, cenario)
        jogadores.draw(tela)
        pygame.display.update()

    # clk.tick(60)

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_ESCAPE:
                if estado == "JOGANDO":
                    estado = "PAUSADO"
                else:
                    estado = "JOGANDO"
        player1.processar_evento(e)



