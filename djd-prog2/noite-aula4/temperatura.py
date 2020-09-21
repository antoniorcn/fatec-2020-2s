# <= -10;  Congelando
# < 5;    Muito frio
# < 10;   Frio
# < 20;   Agradavel
# < 30;   Calor
# >= 30;  Muito Calor

# if temperatura <= -10:
#     print("Congelando")
# else:
#     if temperatura < 5:
#        print("Muito Frio")
#     else:
#         if temperatura < 10:
#             print("Frio")
#         else:
#             if temperatura < 20:
#                 print("Agradavel")
#             else:
#                 if temperatura < 30:
#                     print("Calor")
#                 else:
#                     print("Muito Calor")
temperatura = 19

if temperatura <= -10:
    print("Congelando")
elif temperatura < 5:
    print("Muito Frio")
elif temperatura < 10:
    print("Frio")
elif temperatura < 20:
    print("Agradavel")
elif temperatura < 30:
    print("Calor")
else:
    print("Muito Calor")
