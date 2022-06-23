# desafio-elo7
 
a rota usada foi ("/")
http://localhost:8080/

com o Json:
{
    "mapa": "5 5" ,
    "sondaForm": [
    {
        "entradaPosicaoDir": "1 2 n" ,
        "comandos": "LMLMLMLMM"
    },
    {
        "entradaPosicaoDir":  "3 3 E" ,
        "comandos": "MMRMMRMRRM"
    }
  ]
}

Foi considerado apenas dois cenários de teste,
-> onde para as entradas apresentadas obteve as saidas esperadas 
-> e outro com comando inválido "G" do exemplo ("GMMRMMRMRRM") que e retorna um 404.