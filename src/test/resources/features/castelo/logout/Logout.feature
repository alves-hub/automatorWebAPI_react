#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @logout @regressionSite @availableSite @e2eSite
Funcionalidade: Logout
  Eu como usuario do site Elo 
  Desejo validar a realização de logout
  Para encerrar minha sessão no site

  Contexto: 
    Dado que estou no site Elo
    E realizei o login no site com usuario "824.738.612-77" e senha "Qwe123?!"

  Esquema do Cenario: Validar logout realizado com sucesso
    Quando clico no link Sair
    Entao é exibido a home deslogada com o texto "<TextoHomeDeslogada>" após o logout
    E os botões CadastreSe e Login é exibido no canto superior direito
    E o cookie "loggedUser" foi removido da lista de cookies

    Exemplos: 
      | TextoHomeDeslogada                                   |
      | Cartão Elo: O Cartão com mais Benefícios e Promoções |
