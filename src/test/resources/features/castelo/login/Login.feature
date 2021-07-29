#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @login @regressionSite
Funcionalidade: Login
  Eu como usuario do site Elo 
  Desejo validar a realização de login no site
  Para ter acesso a área logada

  Contexto: 
    Dado que estou no site Elo
    E acessei a tela de login

  @availableSite
  Cenario: Validar disponibilidade da página de Login
    Entao a pagina de login é apresentada com os campos CPF e Senha

  Esquema do Cenario: Validar mensagens de erro de login "<Cenario>"
    Quando preencher os campos CPF e Senha com os valores "<CPF>" e "<Senha>"
    E clicar em Entrar
    Entao valido na tela de login a mensagem de erro "<Mensagem>"

    Exemplos: 
      | Cenario                                    | CPF            | Senha         | Mensagem                                                                       |
      | sem preencher o cpf                        |                | Teste@123     | CPF inválido!                                                                  |
      | sem preencher a senha                      | 824.738.612-77 |               | Campo senha deve ser preenchido!                                               |
      | preenchendo cpf inválido                   | 824.738.612-75 | Teste@123     | CPF inválido!                                                                  |
      | preenchendo senha incorreta                | 824.738.612-77 | SenhaInválida | Dados de acesso incorretos. Verifique se digitou corretamente seu CPF e senha. |
      | preenchendo cpf válido inexistente na base | 286.763.267-62 | Qwe123?!      | Dados de acesso incorretos. Verifique se digitou corretamente seu CPF e senha. |

	@e2eSite
  Esquema do Cenario: Validar login realizado com sucesso
    Quando preencher os campos CPF e Senha com os valores "<CPF>" e "<Senha>"
    E clicar em Entrar
    Entao a página Meus Cartões é exibida
    E os botões Cadastre-se e Login será substituido pelo texto "<TextoOla>"

    Exemplos: 
      | CPF            | Senha    | TextoOla       |
      | 824.738.612-77 | Qwe123?! | Olá, Automacao |
