[![Apache 2.0 License](https://img.shields.io/badge/license-apache%202.0-green.svg) ](https://github.com/wmixvideo/nfe/blob/master/LICENSE)

# reconhecimento-de-voz-android
#Software de reconhecimento de voz no sistema android

##Objetivo
Criar um software que reconhecesse a voz do usuário e realizasse alguma ação a partir desse comando

##Requisitos do sistema
Conexão com a internet para uso da API do google

###Este projeto já está implementando as seguintes funcionalidades: 

####1. Reconhecimento da voz
       Utiliza das ferramentas da plataforma android para captar o sinal de voz

####2. Requisição de reconhecimento: 
       Enviar o sinal de voz captado para a API do google que se encarrega de fazer todos os procedimentos para tratamento do sinal e renochecimento do sinal obtido e devolve um array de string com as palavras com % de acerto maiores.    
    
####3. Tratamento do retorno da API 
       Software tem um dicionário de palavras proprias que usa para comparação com as palavras obtidas pelo retorno do API do google.

####4. Ação
       A ação definida para esse software foi de trocar a cor do fundo de uma activity para uma cor dita pelo usuário.
       
## Observações
Este sistema foi utiliado para fins acadêmicos então possui diversas limitações como:

#### * Necessita de conexão com a internet para funcionamento da API do google, não implemetado o reconhecimetno offline.
#### * Não foi realizado o tratamento para palavras que não estejam no dicionário do software.
#### * Inteface gráfica pobre.
#### * Não foi dado enfaze à OO.
       
## Licença
Apache 2.0
