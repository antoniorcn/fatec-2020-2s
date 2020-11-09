import pygame

tela = pygame.display.set_mode((800, 600))
img_fusca = pygame.image.load("./fusca.png").convert_alpha()
img_tartaruga = pygame.image.load("./tartaruga.png").convert_alpha()


class Inimigo(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.image = img_tartaruga
        self.rect = pygame.Rect( (0, 0), self.image.get_size())


class Fusca(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.vel_x = 1
        self.vel_y = 1
        self.hp = 100
        self.image = img_fusca
        self.rect = pygame.Rect((0, 0), img_fusca.get_size())

    def update(self):
        self.rect.move_ip(self.vel_x, self.vel_y)
        if self.rect.right > 800:
            self.vel_x = -1
        if self.rect.left < 0:
            self.vel_x = 1
        if self.rect.bottom > 600:
            self.vel_y = -1
        if self.rect.top < 0:
            self.vel_y = 1


fusca1 = Fusca()
fusca2 = Fusca()
carros = pygame.sprite.Group(fusca1, fusca2)

t1 = Inimigo()
t1.rect.topleft = (300, 200)
t2 = Inimigo()
t2.rect.topleft = (100, 400)
inimigos = pygame.sprite.Group(t1, t2)

jogar = True
fusca2.vel_x = 2
while jogar:
    # Calcular regras
    carros.update()
    colisoes = pygame.sprite.groupcollide(carros, inimigos, False, False)
    if colisoes:
        for c in colisoes:
            # c.kill()
            c.hp = c.hp - 1
            print(c.hp)

    # inimigo_colidido = pygame.sprite.spritecollide(fusca1, inimigos, True)
    # if inimigo_colidido:
        # print("Colisão")
        # fusca1.kill()
        # for i in inimigo_colidido:
        #     i.kill()

    # Pinta a tela
    tela.fill((0, 0, 0))
    carros.draw(tela)
    inimigos.draw(tela)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False