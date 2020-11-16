import pygame

tela = pygame.display.set_mode((800, 600))

imgSpriteSheet = pygame.image.load("./EpicArmor.png")
imgSpriteSheetMario = pygame.image.load("./mario.png")


def pegar_imagem_por_gid(spritesheet, gid = 0, largura = 64, altura = 64,
                         margin = 0, top = 0, espac_h = 0, espac_v = 0,
                         colunas = 9):
    coluna = gid % colunas
    linha = gid // colunas
    x = ((coluna + espac_h) * largura) + margin
    y = ((linha + espac_v) * altura) + top
    r = pygame.Rect((x, y), (largura, altura))
    img = spritesheet.subsurface(r)
    return img


class Mario(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.frame = 0
        self.image = self.get_frame()
        self.rect = pygame.Rect((200, 200), self.image.get_size())

    def get_frame(self):
        return pegar_imagem_por_gid(imgSpriteSheetMario, self.frame,
                                    largura=32, altura=32, colunas=4)

    def update(self):
        self.frame += 1
        if self.frame > 7:
            self.frame = 0
        self.image = self.get_frame()


mario = Mario()
jogadores = pygame.sprite.Group(mario)
jogar = True
clk = pygame.time.Clock()
while jogar:
    # Calcular regras
    jogadores.update()

    # Pintar na tela
    tela.fill((0, 0, 0))
    jogadores.draw(tela)
    pygame.display.update()

    clk.tick(10)

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False


