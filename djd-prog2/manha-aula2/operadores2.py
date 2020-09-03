temperatura = 14
frio = temperatura < 15
horas_acordado = 18
sono = horas_acordado > 16
ficar_casa = sono and frio

print("Ficar em casa: ", ficar_casa)
