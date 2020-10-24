class Notebook:
    def __init__(self):
        self.cor = "preto"
        self.polegadas = 15
        self.entradas = 5
        self.marca = "acer"
        self.processador = "i5"

    def print(self):
        print("NOTEBOOK")
        print("Cor: ", self.cor)
        print("Polegadas: ", self.polegadas)
        print("Entradas: ", self.entradas)
        print("Marca: ", self.marca)
        print("Processador: ", self.processador)

    def ligar(self):
        print("Ligado")

    def desligar(self):
        print("desligado")

class carro():
    def __init__(self):
        self.tipo = "fiat"
        self.cor = ""
        self.cambio = ""
        self.freio = ""
        self.aceleracao = int()

    def correr(self, aceleracao):
        aceleracao.km ((self.velocidade, self.quilometragem))


class vinhos():
    def __init__(self):
        self.tipo = ""
        self.idade = int()
        self.uva = ""
        self.pais = ""
        self.premios = ""
    def crescer(self, tamanho):
        tamanho.centimetros((self.altura, self.largura))

class plantas():
    def __init__(self):
        self.tipo = "alecrim"
        self.cor = "dourado"
        self.especie = ""
        self.solo = "calcario"
        self.tamanho = int()

    def crescer(self, tamanho):
        tamanho.centimetros((self.altura, self.largura))

class personagem():
    def __init__(self):
        self.cor = "vermelho"
        self.genero = "trans"
        self.altura = ""
        self.largura = ""
        self.armas = ""
    def defesa(self, arma):
        arma.defesa((self.escudo, self.portal))

class bandas():
    def __init__(self):
        self.tipo = "alecrim"
        self.quantidadedeintegrantes = "dourado"
        self.shows = int()
        self.tempo_de_banda = int()
        self.quantidade_musicas = int()

    def turne(self):
        pass