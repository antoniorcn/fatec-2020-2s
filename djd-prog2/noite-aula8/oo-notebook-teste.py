class Notebook:
    def __init__( self ):
        self.cor = "preto"      # Variavel de instância
        self.polegadas = 15
        self.entradas = 5
        self.marca = "acer"
        self.processador = "i5"
        self.ligado = False

    def imprimir( self ):
        modelo = "A50018"       # Variavel Local
        print("NOTEBOOK")
        print("Cor: ", self.cor)
        print("Polegadas: ", self.polegadas)
        print("Entradas: ", self.entradas)
        print("Marca: ", self.marca)
        print("Processador: ", self.processador)

    def ligar( self ):
        print("Ligado")
        c = 5
        self.ligado = True

    def desligar( self ):
        print("desligado")
        self.ligado = False