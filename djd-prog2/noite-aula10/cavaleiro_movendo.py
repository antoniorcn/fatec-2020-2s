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


class Cavaleiro(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.image = get_image_by_gid(img_spritesheet, 0)
        self.rect = pygame.Rect((0, 300), self.image.get_size())
        self.vel_x = 0

    def update(self):
        self.rect.move_ip(self.vel_x, 0)


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
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                player.vel_x = 1
            if e.key == pygame.K_LEFT:
                player.vel_x = -1
        if e.type == pygame.KEYUP:
            if e.key == pygame.K_RIGHT:
                player.vel_x = 0
            if e.key == pygame.K_LEFT:
                player.vel_x = 0
