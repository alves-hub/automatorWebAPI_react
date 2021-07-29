#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @meusCartoes @regressionSite
Funcionalidade: Meus Cartões
  Eu como usuario do site Elo 
  Desejo validar o acesso a página e funcionalidades de Meus Cartões
  Para poder aproveitar todos os benefícios

  Contexto: 
    Dado que estou no site Elo
    E fiz login com usuário "086.660.064-71" e senha "Qwe123?!"

  @availableSite
  Cenario: Validar disponibilidade da página Meus Cartoes
    Entao a página Meus Cartões é exibida com o onboarding

  Esquema do Cenário: Validação de mensagem de erro realizando cadastro de cartão "<TipoCadastro>"
    Dado que cliquei no botão de adicionar cartão
    Quando preencho no modal de cartão os valores "<BinCartao>" "<Mes>" "<Ano>"
    E clico no botão Adicionar este cartão
    Entao vejo no modal de cadastro de cartão a mensagem de erro "<MensagemErro>"

    Exemplos: 
      | TipoCadastro                  | BinCartao | Mes | Ano  | MensagemErro                                           |
      | com vencimento sem ano        |    655002 |  04 |      | Por favor selecione a data de vencimento               |
      | com vencimento sem mês        |    655002 |     | 2025 | Por favor selecione a data de vencimento               |
      | com número de cartão inválido | Invalido  |  06 | 2025 | Confira o número do seu cartão                         |
      | com bin que não é bin Elo     |    514009 |  06 | 2025 | Número de cartão inválido. Por favor, tente novamente. |

  @e2eSite @e2eCartao
  Esquema do Cenário: Realização de cadastro de cartão "<TipoCadastro>" com sucesso
    Dado que cliquei no botão de adicionar cartão
    Quando preencho no modal de cartão os valores "<BinCartao>" "<Mes>" "<Ano>"
    E clico no botão Adicionar este cartão
    Entao o cartão é adicionado com sucesso e é automaticamente selecionado no select de cartão, exibindo os 4 últimos dígitos
    E o cartão será excluido via api

    Exemplos: 
      | TipoCadastro   | BinCartao | Mes | Ano  |
      | com vencimento |    655002 |  06 | 2025 |
      | sem vencimento |    655002 |     |      |
