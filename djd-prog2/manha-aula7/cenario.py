import pygame

cenario = [
    ".PPPPP.........................PPPPPP...",
    "....PPPPPPPP............................",
    ".............PPPPPPP....................",
    ".........................PPPPPP.........",
    "................PPPP....................",
    "..DDD.................PPPPPPPPPPPP......",
    "........PPPPPP..........................",
    "....................PPPPP...............",
    "..............PPPPP.....................",
    "......PPPP...........................PPP",
    "PPPPP...................................",
    "............PPPPPPPP....................",
    ".................................PPPPPPP",
    "........................................",
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"
]

WIDTH = 800
HEIGHT = 600
PRETA = (0, 0, 0)
AMARELA = (255, 255, 0)
VERMELHA = (255, 0, 0)

largura = WIDTH // 40
altura = HEIGHT // 15

tela = pygame.display.set_mode((WIDTH, HEIGHT), 0)
sair = False
while not sair:
    # Calcular regras

    # Pintar
    for linha in range(len(cenario)):
        for coluna in range(len(cenario[linha])):
            letra = cenario[linha][coluna]
            x = coluna * largura
            y = linha * altura
            cor = PRETA
            if letra == 'P':
                cor = AMARELA
            elif letra == 'D':
                cor = VERMELHA
            pygame.draw.rect(tela, cor, ((x, y), (largura, altura)), 0)
    pygame.display.update()

    # Capturar Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            sair = True
