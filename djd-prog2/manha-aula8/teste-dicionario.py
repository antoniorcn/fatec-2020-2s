# mochila_link = ["espada", "escudo", ["poção"], "flecha", "arco"]

mochila_link = {"arma": "espada",
                "defesa": "escudo",
                "poções": ["poção cura", "poção vida", "poção força"],
                "arco": "arco-longo",
                "flechas": 2}

mochila_link["flechas"] += 1
mochila_link["poções"].append("poção imortalidade")

print(mochila_link["flechas"])
print(mochila_link["poções"])

print("Len: ", len(mochila_link))

if "arco" in mochila_link:
    print("Há espaço para arco na mochila")
else:
    print("Não há espaço para arco na mochila")

print("Antes de apagar o arco", mochila_link)
del mochila_link["arco"], mochila_link["flechas"]
print("Depois de apagar o arco", mochila_link)

print("Todas as chaves da mochila: ", mochila_link.keys())
print("Todas os items da mochila: ", mochila_link.items())
print("Todas os valores da mochila: ", mochila_link.values())


