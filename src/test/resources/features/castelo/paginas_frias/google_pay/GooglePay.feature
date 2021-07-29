#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @googlePay @regressionSite
Funcionalidade: Google Pay
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Google Pay
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Google Pay
    Dado que acessei a página Google Pay
    Entao a pagina Google Pay é apresentada contendo os textos "<Titulo>" e "<Subtitulo>"

    Exemplos: 
      | Titulo              | Subtitulo                            |
      | Viu como é simples? | Agora é só aproveitar. Boas compras! |
