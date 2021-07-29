#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @canaisDeContato @regressionSite
Funcionalidade: Canais de Contato
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Canais de Contato
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Canais de Contato
    Dado que acessei a página Canais de Contato
    Entao a pagina Canais de Contato é apresentada contendo os textos "<Titulo>" e "<Subtitulo>"

    Exemplos: 
      | Titulo               | Subtitulo                                                               |
      | Contato de Parceiros | Encontre contato de Emissores, Credenciadores e Subcredenciadores Elo . |

  @e2eSite
  Esquema do Cenário: Busca de Parceiro com resultado do tipo "<Tipo>"
    Dado que estou na página de Canais de Contato
    Quando preencho o campo de busca com o valor "<ValorBusca>"
    Então é exibido o contato "<Contato>" do tipo "<Tipo>"
    E a classificação do contato é da classificação "<Classificacao>"

    Exemplos: 
      | ValorBusca   | Contato         | Tipo                   | Classificacao                          |
      | Banco do Bra | Banco do Brasil | Instituição Financeira | Emissores Elo                          |
      | Ciel         | Cielo           | Credenciador           | Credenciadores e Subcredenciadores Elo |

  @e2eSite
  Esquema do Cenário: Busca de Parceiro sem resultado
    Dado que estou na página de Canais de Contato
    Quando preencho o campo de busca com o valor "<ValorBusca>"
    Então será exibido a mensagem "<Mensagem>"

    Exemplos: 
      | ValorBusca          | Mensagem                                    |
      | Sem Valor Retornado | Sua pesquisa não retornou nenhum resultado! |
