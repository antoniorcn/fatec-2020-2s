import pygame

pygame.init()

tela = pygame.display.set_mode((800, 600), 0)
img_ssheet_fundo = pygame.image.load("./assets/basictiles.png").convert_alpha()

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
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
    "P..............................................................................P",
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


def pintar_cenario():
    img = get_image_by_gid(img_ssheet_fundo, 4)
    tela.blit(img, (100, 100))


jogar = True
while jogar:

    # calcular as regras

    # pintar a tela
    pintar_cenario()
    pygame.display.update()

    # captura os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogar = False