#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @trabalheConosco @regressionSite
Funcionalidade: Trabalhe Conosco
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Trabalhe Conosco
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Trabalhe Conosco
    Dado que acessei a página Trabalhe Conosco
    Entao a pagina Trabalhe Conosco é apresentada contendo os textos "<Titulo>" e "<Subtitulo>"

    Exemplos: 
      | Titulo                       | Subtitulo                                                                         |
      | Venha trabalhar com a gente! | A Elo foi reconhecida como uma das melhores empresas para se trabalhar no Brasil. |
