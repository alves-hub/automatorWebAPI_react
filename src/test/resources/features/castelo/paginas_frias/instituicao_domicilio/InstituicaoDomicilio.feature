#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @instituicaoDomicilio @regressionSite
Funcionalidade: Instituicao de Domicilio
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Instituicao de Domicilio
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Instituicao de Domicilio
    Dado que acessei a página Participantes do Arranjo Elo
    Entao a pagina Instituicao de Domicilio é apresentada contendo os textos "<Titulo>" e "<Subtitulo>"

    Exemplos: 
      | Titulo                                     | Subtitulo                                                                                                                                                                                                               |
      | Participantes do Arranjo Elo de Pagamentos | Em atendimento à determinação do Banco Central do Brasil, a Elo divulga abaixo a lista de participantes dos seus arranjos de pagamento que devidamente se habilitaram junto à CIP - Câmara Interbancária de Pagamentos. |

  @e2eSite
  Esquema do Cenário: Busca de Parceiro com resultado
    Dado que estou na página de Instituicao de Domicilio
    Quando preencho o campo de busca de instituicao com o valor "<ValorBusca>"
    Então é exibido o participante "<Participante>" com CNPJ "<CNPJ>" arranjo "<Arranjo>" e papel no arranjo "<PapelNoArranjo>"

    Exemplos: 
      | ValorBusca          | Participante        | CNPJ               | Arranjo                                                               | PapelNoArranjo |
      | banco bradesco s.a. | Banco Bradesco S.A. | 60.746.948/0001-12 | ELO Múltiplo Crédito e Débito, ELO Crédito, ELO Débito e ELO Pré Pago | Emissor        |

  @e2eSite
  Esquema do Cenário: Busca de Parceiro sem resultado
    Dado que estou na página de Instituicao de Domicilio
    Quando preencho o campo de busca de instituicao com o valor "<ValorBusca>"
    Então será exibido na tabela de instituicao a mensagem "<Mensagem>"

    Exemplos: 
      | ValorBusca          | Mensagem                                    |
      | Sem Valor Retornado | Sua pesquisa não retornou nenhum resultado! |
