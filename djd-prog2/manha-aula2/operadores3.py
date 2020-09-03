heroi_life = 10
coragem = heroi_life > 50
possui_machado = True
matou_ogro = possui_machado or coragem

if matou_ogro:
    print("Parabens você venceu")
else:
    print("Que pena o Ogro matou você")