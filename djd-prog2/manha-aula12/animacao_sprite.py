import pygame
import os

pygame.init()

os.environ['SDL_VIDEO_CENTERED'] = '1'
tela = pygame.display.set_mode((800, 600))
sprite_sheet_sara = pygame.image.load("./sara.png").convert_alpha()
sprite_sheet_tiles = pygame.image.load("./basictiles.png").convert_alpha()
sprite_sheet_characters = pygame.image.load("./characters.png").convert_alpha()

font = pygame.font.SysFont('arial', 48, False, False)

estado = "JOGANDO"
qtd_vidas = 5
qtd_tiros = 10

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
    "...EGEGEGFF.....................................................................",
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


def desenhar_mapa(matriz, personagem, surface):
    for linha, conteudo_linha in enumerate(matriz):
        for coluna, caracter in enumerate(conteudo_linha):
            x = coluna * 4
            y = linha * 4
            if caracter == "P":
                pygame.draw.rect(surface, (255, 0, 0), ((x, y), (4, 4)), 0)
            elif caracter == "G":
                pygame.draw.rect(surface, (0, 255, 0), ((x, y), (4, 4)), 0)
            elif caracter == "E":
                pygame.draw.rect(surface, (200, 200, 200), ((x, y), (4, 4)), 0)
            elif caracter == "F":
                pygame.draw.rect(surface, (255, 255, 255), ((x, y), (4, 4)), 0)
    px = (personagem.rect.centerx // 64) * 4
    py = (personagem.rect.centery // 64) * 4
    pygame.draw.rect(surface, (255, 255, 0), ((px, py), (4, 4)), 0)


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
        self.angulo = 0
        self.image = pygame.transform.rotate(self.get_image(), self.angulo)
        self.vel_x = 1
        self.vida = 400
        self.rect_temp = pygame.Rect((x, y), self.image.get_size())
        self.rect = pygame.Rect((x, y), self.image.get_size())

    def get_image(self):
        frame = self.animacao.get_frame()
        return pegar_imagem_por_gid(sprite_sheet_tiles, frame, colunas=8)

    def update(self):
        self.rect_temp.centerx += self.vel_x
        self.angulo += 1
        # if self.angulo > 360:
        #    self.angulo = 0
        self.angulo %= 360
        self.image = pygame.transform.rotate(self.get_image(), self.angulo)
        x = self.rect_temp.centerx - self.image.get_width() // 2
        y = self.rect_temp.centery - self.image.get_height() // 2
        self.rect = pygame.Rect((x, y), self.image.get_size())
        # pygame.draw.rect(self.image, (255, 0, 0), ((0, 0), self.image.get_size()), 2)
        self.vida -= 1
        if self.vida <= 0:
            self.kill()


class Sara(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.frame_indice = 0
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
                self.vel_y = 0

    def processar_evento(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                self.lista_frames = self.andando_esquerda
                self.vel_x = -1
            if e.key == pygame.K_RIGHT:
                self.lista_frames = self.andando_direita
                self.vel_x = 1
            if e.key == pygame.K_UP:
                self.vel_y = -1
            if e.key == pygame.K_DOWN:
                self.vel_y = 1
        if e.type == pygame.KEYUP:
            if e.key == pygame.K_LEFT:
                self.lista_frames = self.parado_esquerda
                self.vel_x = 0
            if e.key == pygame.K_RIGHT:
                self.lista_frames = self.parado_direita
                self.vel_x = 0
            if e.key == pygame.K_UP:
                self.vel_y = 0
            if e.key == pygame.K_DOWN:
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
        pygame.sprite.groupcollide(inimigos, tiros, True, True)
        camera.mover(player1.rect.center)
        if pygame.sprite.spritecollide(player1, inimigos, True):
            qtd_vidas -= 1
        if qtd_vidas <= 0:
            estado = "GAMEOVER"
        if len(inimigos) <= 0:
            estado = "VITORIA"

    txt_vidas = font.render("Vidas: " + str(qtd_vidas), True, (255, 255, 0))
    txt_tiros = font.render("Tiros: " + str(qtd_tiros), True, (255, 255, 0))

    # Pintar na tela
    if estado == "JOGANDO":
        camera.iniciar_desenho()
        camera.desenhar_grupo(blocos)
        camera.desenhar_grupo(inimigos)
        camera.desenhar_grupo(jogadores)
        camera.desenhar_grupo(tiros)
        camera.pintar(tela)
        tela.blit(txt_vidas, (50, 0))
        tela.blit(txt_tiros, (550, 0))
        desenhar_mapa(cenario, player1, tela)
        desenhar_mapa(cenario_inimigos, player1, tela)
        pygame.display.update()
    elif estado in ['GAMEOVER', 'VITORIA']:
        camera.iniciar_desenho()
        camera.desenhar_grupo(blocos)
        camera.desenhar_grupo(inimigos)
        camera.desenhar_grupo(jogadores)
        camera.desenhar_grupo(tiros)
        camera.pintar(tela)
        if estado == 'GAMEOVER':
            txt_gameover = font.render("G A M E  O V E R", True, (255, 0, 0))
            tela.blit(txt_gameover, (225, 200))
        else:
            txt_vitoria = font.render("V O C Ê   V E N C E U", True, (255, 255, 0))
            tela.blit(txt_vitoria, (175, 200))
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
                if qtd_tiros > 0:
                    qtd_tiros -= 1
                    tiro = Tiro(player1.rect.x, player1.rect.centery)
                    tiros.add(tiro)
        player1.processar_evento(e)



