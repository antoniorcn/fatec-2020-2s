link = {}

link['arma'] = 'espada'

link['defesa'] = 'escudo bronze'

link['flechas'] = ["flecha", "flecha", "flecha"]

print(link)

palavra = "arma"
if palavra in link:
    print(link[palavra])
else:
    print(f"Não tem  {palavra} com o link")

print(len(link))

del link['flechas']
print(link)

print(link.items())

print(link.keys())

print(link.values())

li = (1, 2, 3)
a = li[0]
print(a)
print(li)

AMARELO = (255, 255, 0)
# AMARELO[0] = 0
am = list(AMARELO)
am[0] = 0
print(am)