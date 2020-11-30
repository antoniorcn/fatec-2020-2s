import pygame

tela = pygame.display.set_mode((800, 600))
sprite_sheet_sara = pygame.image.load("./sara.png").convert_alpha()
sprite_sheet_tiles = pygame.image.load("./basictiles.png").convert_alpha()
sprite_sheet_characters = pygame.image.load("./characters.png").convert_alpha()

estado = "JOGANDO"

GRAVIDADE = 0.009

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
    "P..PPPPP.......................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",
]


cenario_inimigos = [
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "................................................................................",
    "...EGEGEGFF......E...............E......................G................G......",
    "................................................................................",
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


def desenhar_cenario(matriz, grupo):
    for linha, nivel in enumerate(matriz):
        for coluna, caracter in enumerate(nivel):
            spr = None
            if caracter == '.':
                # spr = Fundo(coluna, linha)
                pass
            elif caracter == 'P':
                spr = Plataforma(coluna, linha)
            elif caracter == 'E':
                spr = Esqueleto(coluna, linha)
            elif caracter == 'F':
                spr = Fantasma(coluna, linha)
            elif caracter == 'G':
                spr = Geleia(coluna, linha)
            if spr is not None:
                grupo.add(spr)


class Animacao:
    def __init__(self, frames, tempo_animacao=5):
        self.frames = []
        self.frames.extend(frames)
        self.frame_indice = 0
        self.tempo_animacao = tempo_animacao
        self.contador_tempo = 0

    def get_frame(self):
        self.contador_tempo += 1
        if self.contador_tempo > self.tempo_animacao:
            self.frame_indice += 1
            self.contador_tempo = 0
        if self.frame_indice >= len(self.frames):
            self.frame_indice = 0
        frame = self.frames[self.frame_indice]
        return frame


class Fundo(pygame.sprite.Sprite):
    def __init__(self, coluna, linha):
        pygame.sprite.Sprite.__init__(self)
        self.image = pegar_imagem_por_gid(sprite_sheet_tiles, 22, colunas=8)
        x = coluna * 64
        y = linha * 64
        self.rect = pygame.Rect((x, y), (64, 64))


class Plataforma(pygame.sprite.Sprite):
    def __init__(self, coluna, linha):
        pygame.sprite.Sprite.__init__(self)
        self.image = pegar_imagem_por_gid(sprite_sheet_tiles, 15, colunas=8)
        x = coluna * 64
        y = linha * 64
        self.rect = pygame.Rect((x, y), (64, 64))


class Esqueleto(pygame.sprite.Sprite):
    def __init__(self, coluna, linha):
        pygame.sprite.Sprite.__init__(self)
        self.animacao = Animacao([10, 9, 10, 11], tempo_animacao=50)
        self.image = self.get_image()
        x = coluna * self.image.get_width()
        y = linha * self.image.get_height()
        self.rect = pygame.Rect((x, y), self.image.get_size())

    def get_image(self):
        frame = self.animacao.get_frame()
        return pegar_imagem_por_gid(sprite_sheet_characters, frame, colunas=12)

    def update(self):
        self.image = self.get_image()


class Fantasma(pygame.sprite.Sprite):
    def __init__(self, coluna, linha):
        pygame.sprite.Sprite.__init__(self)
        self.animacao = Animacao([55, 54, 55, 56], tempo_animacao=50)
        self.image = self.get_image()
        x = coluna * self.image.get_width()
        y = linha * self.image.get_height()
        self.rect = pygame.Rect((x, y), self.image.get_size())

    def get_image(self):
        frame = self.animacao.get_frame()
        return pegar_imagem_por_gid(sprite_sheet_characters, frame, colunas=12)

    def update(self):
        self.image = self.get_image()


class Geleia(pygame.sprite.Sprite):
    def __init__(self, coluna, linha):
        pygame.sprite.Sprite.__init__(self)
        self.animacao = Animacao([49, 48, 49, 50], tempo_animacao=50)
        self.image = self.get_image()
        x = coluna * self.image.get_width()
        y = linha * self.image.get_height()
        self.rect = pygame.Rect((x, y), self.image.get_size())

    def get_image(self):
        frame = self.animacao.get_frame()
        return pegar_imagem_por_gid(sprite_sheet_characters, frame, colunas=12)

    def update(self):
        self.image = self.get_image()


class Tiro(pygame.sprite.Sprite):
    def __init__(self, x, y):
        pygame.sprite.Sprite.__init__(self)
        self.animacao = Animacao([60, 61], tempo_animacao=50)
        self.image = self.get_image()
        self.vel_x = 1
        self.vida = 400
        self.rect = pygame.Rect((x, y), self.image.get_size())

    def get_image(self):
        frame = self.animacao.get_frame()
        return pegar_imagem_por_gid(sprite_sheet_tiles, frame, colunas=8)

    def update(self):
        self.rect.x += self.vel_x
        self.image = self.get_image()
        self.vida -= 1
        if self.vida <= 0:
            self.kill()


class Sara(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.frame_indice = 0
        self.andando_cima = [104, 105, 106, 107, 108, 109, 110, 111, 112]
        self.parado_cima = [1]
        self.andando_baixo = [130, 131, 132, 133, 134, 135, 136, 137, 138]
        self.parado_baixo = [27]
        self.andando_esquerda = [117, 118, 119, 120, 121, 122, 123, 124, 125]
        self.parado_esquerda = [14]
        self.andando_direita = [143, 144, 145, 146, 147, 148, 149, 150, 151]
        self.parado_direita = [40]
        self.tempo_animacao = 5
        self.contador_tempo = 0
        self.lista_frames = self.parado_direita
        self.image = self.get_frame()
        self.vel_x = 0
        self.vel_y = 0
        self.rect = pygame.Rect((200, 200), self.image.get_size())
        self.intencao_pos = list(self.rect.center)

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
        self.vel_y += GRAVIDADE
        self.image = self.get_frame()
        self.intencao_pos[0] = self.rect.center[0] + self.vel_x
        self.intencao_pos[1] = self.rect.center[1] + self.vel_y

    def teste_colisao(self, grupo):
        pos_anterior = list(self.rect.center)
        self.rect.center = self.intencao_pos
        for obj in grupo:
            if type(obj) == Plataforma and pygame.sprite.collide_rect(self, obj):
                self.rect.center = pos_anterior
                self.intencao_pos = pos_anterior

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


class Camera:
    def __init__(self, posicao, tamanho):
        self.window = pygame.Rect(posicao, tamanho)
        self.posicao = posicao
        self.offset_x = 0
        self.offset_y = 0
        self.folha_escura = pygame.Surface(self.window.size)
        self.folha_escura.fill((0, 0, 0))
        self.area_desenho = pygame.Surface(self.window.size)

    def na_janela(self, r):
        return self.window.colliderect(r)

    def iniciar_desenho(self):
        self.area_desenho.blit(self.folha_escura, (0, 0))

    def desenhar_grupo(self, grupo):
        for spr in grupo:
            if self.na_janela(spr.rect):
                self.area_desenho.blit(spr.image, (spr.rect.x - self.offset_x,
                                                   spr.rect.y - self.offset_y))

    def mover(self, posicao):
        self.window.center = posicao
        self.offset_x = self.window.x
        self.offset_y = self.window.y

    def pintar(self, tela):
        tela.blit(self.area_desenho, self.posicao)


player1 = Sara()
player1.rect.topleft = (300, 300)
jogadores = pygame.sprite.Group(player1)
blocos = pygame.sprite.Group()
inimigos = pygame.sprite.Group()
tiros = pygame.sprite.Group()
desenhar_cenario(cenario, blocos)
desenhar_cenario(cenario_inimigos, inimigos)
camera = Camera((0, 0), (800, 600))
jogar = True
clk = pygame.time.Clock()
while jogar:
    # Calcular regras
    if estado == "JOGANDO":
        inimigos.update()
        jogadores.update()
        tiros.update()
        player1.teste_colisao(blocos)
        camera.mover(player1.rect.center)


    # Pintar na tela
    if estado == "JOGANDO":
        camera.iniciar_desenho()
        camera.desenhar_grupo(blocos)
        camera.desenhar_grupo(inimigos)
        camera.desenhar_grupo(jogadores)
        camera.desenhar_grupo(tiros)
        camera.pintar(tela)
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
            if e.key == pygame.K_SPACE:
                tiro = Tiro(player1.rect.x, player1.rect.centery)
                tiros.add(tiro)
        player1.processar_evento(e)



