#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @sessaoExpirada @regressionSite
Funcionalidade: Sessão Expirada
  Eu como usuario do site Elo 
  Desejo validar a realização da renovação da sessão do usuário
  Para continuar a ter acesso a área logada

  Contexto: 
    Dado que estou no site Elo
    E fiz login com usuário "824.738.612-77" e senha "Qwe123?!"

  @availableSite
  Cenario: Validar exibição do modal de renovação de sessão do usuário
    Quando expirar a sessão do usuário
    E acessar a página Meus Cartões com sessão expirada
    Entao o modal de sessão expirada é exibido

  Esquema do Cenario: Validar renovação de sessão do usuário com senha inválida
    Quando expirar a sessão do usuário
    E exibir o modal de sessão expirada
    E preencher o modal de sessão expirada com a senha "<Senha>"
    E clicar no botão Continuar do modal de sessão expirada
    Entao será exibido o modal de erro com o texto "<Mensagem>"

    Exemplos: 
      | Senha    | Mensagem                                          |
      | Qwe123@$ | Ops! Algo deu errado. Por favor, tente novamente. |

  @e2eSite
  Esquema do Cenario: Validar renovação de sessão do usuário
    Quando expirar a sessão do usuário
    E exibir o modal de sessão expirada
    E preencher o modal de sessão expirada com a senha "<Senha>"
    E clicar no botão Continuar do modal de sessão expirada
    Entao a sessão do usuário será renovada, com a página Meus Cartoes recarregada

    Exemplos: 
      | Senha    |
      | Qwe123?! |
