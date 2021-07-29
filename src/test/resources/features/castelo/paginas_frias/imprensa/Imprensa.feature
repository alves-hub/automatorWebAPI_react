#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @imprensa @regressionSite
Funcionalidade: Imprensa
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Imprensa
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Imprensa
    Dado que acessei a página Imprensa
    Entao a pagina Imprensa é apresentada contendo o texto "<Titulo>"

    Exemplos: 
      | Titulo                        |
      | Veja aqui as novidades da Elo |

	@e2eSite
  Esquema do Cenário: Validar acesso aos detalhes de uma notícia
    Dado que estou na página de Imprensa
    Quando clico no saiba mais da notícia "<Noticia>"
    Entao a página "<URI>" é carregada
    E será apresentado os textos "<Titulo>" e "<Subtitulo>"

    Exemplos: 
      | Noticia                                 | URI             | Titulo                                  | Subtitulo                                                                                             |
      | Elo lança 3DS 2.0 com Bradesco e Pefisa | /elo-lanca-3ds/ | Elo lança 3DS 2.0 com Bradesco e Pefisa | Protocolo de autenticação oferece aos clientes a compra online no crédito e débito com mais segurança |
