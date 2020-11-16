import pygame

tela = pygame.display.set_mode((800, 600))
imgSpriteSheet = pygame.image.load("./EpicArmor.png")
estado = "JOGANDO"


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


class Cavaleiro(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.frame_indice = 0
        self.andando_cima = [1, 2, 3, 4, 5, 6, 7, 8]
        self.parado_cima = [0]
        self.andando_baixo = [19, 20, 21, 22, 23, 24, 25, 26]
        self.parado_baixo = [18]
        self.andando_esquerda = [10, 11, 12, 13, 14, 15, 16, 17]
        self.parado_esquerda = [9]
        self.andando_direita = [28, 29, 30, 31, 32, 33, 34, 35]
        self.parado_direita = [27]

        self.lista_frames = self.andando_esquerda
        self.image = self.get_frame()
        self.rect = pygame.Rect((200, 200), self.image.get_size())

    def get_frame(self):
        self.frame_indice += 1
        if self.frame_indice >= len(self.lista_frames):
            self.frame_indice = 0
        frame = self.lista_frames[self.frame_indice]
        return pegar_imagem_por_gid(imgSpriteSheet, frame,
                                    largura=64, altura=64, colunas=9)

    def update(self):
        self.image = self.get_frame()

    def processar_evento(self, e):
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_LEFT:
                self.lista_frames = self.andando_esquerda
            if e.key == pygame.K_RIGHT:
                self.lista_frames = self.andando_direita
            if e.key == pygame.K_UP:
                self.lista_frames = self.andando_cima
            if e.key == pygame.K_DOWN:
                self.lista_frames = self.andando_baixo
        if e.type == pygame.KEYUP:
            if e.key == pygame.K_LEFT:
                self.lista_frames = self.parado_esquerda
            if e.key == pygame.K_RIGHT:
                self.lista_frames = self.parado_direita
            if e.key == pygame.K_UP:
                self.lista_frames = self.parado_cima
            if e.key == pygame.K_DOWN:
                self.lista_frames = self.parado_baixo


player1 = Cavaleiro()
player2 = Cavaleiro()
player2.rect.topleft = (300, 300)
jogadores = pygame.sprite.Group(player1, player2)
jogar = True
clk = pygame.time.Clock()
while jogar:
    # Calcular regras
    if estado == "JOGANDO":
        jogadores.update()

    # Pintar na tela
    if estado == "JOGANDO":
        tela.fill((0, 0, 0))
        jogadores.draw(tela)
        pygame.display.update()

    clk.tick(10)

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
        player2.processar_evento(e)



