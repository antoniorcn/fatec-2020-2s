class CarroFusca:
    def __init__(self):
        self.porta_aberta = False
        self.velocidade_atual = 0
        self.potencia_motor = 1500
        self.ligado = False
        self.cor = "AMARELO"

    def acelerar(self):
        if self.ligado and not self.porta_aberta:
            self.velocidade_atual = self.velocidade_atual + 10
            print("Acelerando para", self.velocidade_atual)
        else:
            print("Não foi possivel acelerar, o carro precisa estar ligado e com a porta fechada")

    def frear(self):
        print("Freando o carro")
        self.velocidade_atual = 0

    def abrir_porta(self):
        self.porta_aberta = True
        print("A porta está aberta")

    def ligar(self):
        self.ligado = True
        print("O carro foi ligado")

    def desligar(self):
        self.ligado = False
        print("O carro foi desligado")

    def fechar_porta(self):
        self.porta_aberta = False
        print("A porta está fechada")


fusca1 = CarroFusca()
fusca2 = CarroFusca()


fusca1.abrir_porta()
fusca1.ligar()
fusca1.fechar_porta()
fusca1.acelerar()
fusca1.frear()
fusca1.acelerar()
fusca1.acelerar()


fusca2.ligar()
fusca2.acelerar()

print("Velocidade do Fusca1: ", fusca1.velocidade_atual)
print("Velocidade do Fusca2: ", fusca2.velocidade_atual)