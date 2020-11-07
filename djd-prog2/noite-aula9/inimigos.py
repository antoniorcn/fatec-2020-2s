AMARELO = (255, 255, 0)


class Alien:
    def __init__(self, c, x, y):
        self.cor = c
        self.pos_x = x
        self.pos_y = y


a1 = Alien("AMARELO", 100, 500)
a2 = Alien("AZUL", 150, 350)

print("A1 Cor:", a1.cor)
print("A2 Cor:", a2.cor)
