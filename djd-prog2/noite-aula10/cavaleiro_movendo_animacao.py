import pygame

tela = pygame.display.set_mode((800, 600))
img_spritesheet = pygame.image.load('./EpicArmor.png').convert_alpha()


def get_image_by_gid(img_spritesheet, gid,
                     top=0, margin=0,
                     dist_v=0, dist_h=0,
                     largura=64, altura=64, colunas=9):
    coluna = gid % colunas
    linha = gid // colunas
    x = margin + (coluna * (largura + dist_h))
    y = top + (linha * (altura + dist_v))
    img = img_spritesheet.subsurface((x, y), (largura, altura))
    return img


class SpriteAnimacao:
    def __init__(self, spritesheet, lista_gid, pausa=0,
                 top=0, margin=0, dist_v=0, dist_h=0,
                 largura=64, altura=64, colunas=9):
        self.img_spritesheet = spritesheet
        self.lista_gid = lista_gid
        self.pausa = pausa
        self.top = top
        self.margin = margin
        self.dist_v = dist_v
        self.dist_h = dist_h
        self.largura = largura
        self.altura = altura
        self.colunas = colunas
        self.frame_index = 0
        self.contador_pausa = 0

    def get_image(self):
        self.contador_pausa += 1
        if self.contador_pausa > self.pausa:
            self.contador_pausa = 0
            self.frame_index += 1
        if self.frame_index >= len(self.lista_gid):
            self.frame_index = 0
        gid = self.lista_gid[self.frame_index]
        img = get_image_by_gid(self.img_spritesheet, gid, self.top, self.margin,
                               self.dist_v, self.dist_h, self.largura, self.altura, self.colunas)
        return img


class Cavaleiro(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.image = get_image_by_gid(img_spritesheet, 0)
        self.rect = pygame.Rect((0, 300), self.image.get_size())
        self.vel_x = 0
        self.vel_y = 0
        self.animacao_parado_direita = SpriteAnimacao(spritesheet=img_spritesheet,
                                       pausa=50,
                                       lista_gid=[27])
        self.animacao_parado_esquerda = SpriteAnimacao(spritesheet=img_spritesheet,
                                       pausa=50,
                                       lista_gid=[9])
        self.animacao_direita = SpriteAnimacao(spritesheet=img_spritesheet,
                                       pausa=10,
                                       lista_gid=[28, 29, 30, 31, 32, 33, 34, 35])
        self.animacao_esquerda = SpriteAnimacao(spritesheet=img_spritesheet,
                                       pausa=10,
                                       lista_gid=[10, 11, 12, 13, 14, 15, 16, 17])
        self.animacao = self.animacao_parado_esquerda

    def update(self):
        self.image = self.animacao.get_image()
        self.rect.move_ip(self.vel_x, self.vel_y)

    def processar_evento(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                self.vel_x = 1
                self.animacao = self.animacao_direita
            if e.key == pygame.K_LEFT:
                self.vel_x = -1
                self.animacao = self.animacao_esquerda
            # if e.key == pygame.K_UP:
            #     player.vel_y = -1
        if e.type == pygame.KEYUP:
            if e.key == pygame.K_RIGHT:
                self.vel_x = 0
                self.animacao = self.animacao_parado_direita
            if e.key == pygame.K_LEFT:
                self.vel_x = 0
                self.animacao = self.animacao_parado_esquerda


player = Cavaleiro()
players = pygame.sprite.Group([player])
jogar = True
while jogar:
    # Calcular regras
    players.update()

    # Pintar personagem
    tela.fill((0, 0, 0))
    players.draw(tela)
    pygame.display.update()

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False
        player.processar_evento(e)

