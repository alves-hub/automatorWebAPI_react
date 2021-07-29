#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @auxilioEmergencial @regressionSite
Funcionalidade: Auxilio Emergencial
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Auxilio Emergencial (Caixa TEM)

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Auxilio Emergencial
    Dado que acessei a página Auxilio Emergencial
    Entao a pagina Auxilio Emergencial é apresentada contendo o texto "<Texto>"

    Exemplos: 
      | Pagina | Texto                                                         |
      | Geral  | Pague suas compras com seu cartão Elo no aplicativo CAIXA Tem |

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página interna do Auxilio Emergencial - "<Pagina>"
    Dado que acessei a página Auxilio Emergencial
    E clico no link Onde comprar da opção "<Opcao>"
    Entao a pagina Auxilio Emergencial - "<Pagina>" é apresentada contendo os textos "<Texto1>" e "<Texto2>"

    Exemplos: 
      | Pagina         | Opcao                 | Texto1                | Texto2                                         |
      | Débito Virtual | Cartão Débito Virtual | Cartão Débito Virtual | Compre em sites e aplicativos sem sair de casa |
      | Na Maquininha  | Pague na maquininha   | Pague na maquininha   | Compre em lojas perto de sua casa              |

  @leadsAuxilioEmergencial
  Esquema do Cenario: Validar mensagen de erro no preenchimento de Leads na página de Auxílio Emergencial "<Tipo>"
    Dado que estou na página de Auxílio Emergencial
    E cliquei no banner de Leads da página Auxílio Emergencial
    Quando preencher os campos com os valores "<CPF>", "<Nome>", "<DataNascimento>", "<Celular>", "<Email>", "<RecebeEmail>" e "<RecebeSMS>"
    E clicar no botão Enviar do Leads de Auxílio Emergencial
    Entao será exibido a mensagem de erro "<MensagemErro>"

    Exemplos: 
      | Tipo                                   | CPF            | Nome       | DataNascimento | Celular         | Email           | RecebeEmail | RecebeSMS | MensagemErro                                        |
      | sem preencher CPF                      |                | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | true        | true      | CPF inválido!                                       |
      | com CPF inválido                       | 222.222.222-22 | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | true        | true      | CPF inválido!                                       |
      | sem preencher nome                     | 379.127.190-32 |            | 12/12/1999     | (99) 99999-9999 | teste@teste.com | true        | true      | Por favor, insira Nome e ao menos um Sobrenome.     |
      | preenchendo apenas nome, sem sobrenome | 379.127.190-32 | Nome       | 12/12/1999     | (99) 99999-9999 | teste@teste.com | true        | true      | Por favor, insira Nome e ao menos um Sobrenome.     |
      | sem preencher data de nascimento       | 379.127.190-32 | Nome Teste |                | (99) 99999-9999 | teste@teste.com | true        | true      | Data inválida!                                      |
      | com data de nascimento inválida        | 379.127.190-32 | Nome Teste | 13/13/1999     | (99) 99999-9999 | teste@teste.com | true        | true      | Data inválida!                                      |
      | com data menor de 13 anos              | 379.127.190-32 | Nome Teste | 13/12/2019     | (99) 99999-9999 | teste@teste.com | true        | true      | Você deve ser maior de 13 anos                      |
      | com data acima da data atual           | 379.127.190-32 | Nome Teste | 13/12/2030     | (99) 99999-9999 | teste@teste.com | true        | true      | Data de nascimento deve ser anterior ao dia de hoje |
      | sem preencher o celular                | 379.127.190-32 | Nome Teste | 12/12/1999     |                 | teste@teste.com | true        | true      | Por favor, insira um telefone válido.               |
      | preenchendo com celular inválido       | 379.127.190-32 | Nome Teste | 12/12/1999     | (11) 11111-1111 | teste@teste.com | true        | true      | Por favor, insira um telefone válido.               |
      | sem preencher e-mail                   | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 |                 | true        | true      | Por favor, insira um email válido.                  |
      | preenchendo e-mail inválido            | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 | email@invalido  | true        | true      | Por favor, insira um email válido.                  |
      | sem marcar opção Email ou SMS          | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | false       | false     | É obrigatório marcar ao menos uma opção             |

  @e2eSite @leadsAuxilioEmergencial @e2eLeadsAuxilioEmergencial
  Esquema do Cenario: Validar o preenchimento de Leads na página de Auxílio Emergencial com sucesso
    Dado que estou na página de Auxílio Emergencial
    E cliquei no banner de Leads da página Auxílio Emergencial
    Quando preencher os campos com os valores "<CPF>", "<Nome>", "<DataNascimento>", "<Celular>", "<Email>", "<RecebeEmail>" e "<RecebeSMS>"
    E clicar no botão Enviar do Leads de Auxílio Emergencial
    Entao será exibido a mensagem de sucesso "<MensagemSucesso1>" e "<MensagemSucesso2>"

    Exemplos: 
      | CPF            | Nome        | DataNascimento | Celular         | Email           | RecebeEmail | RecebeSMS | MensagemSucesso1            | MensagemSucesso2                             |
      | 275.657.405-86 | Teste Leads | 10/12/1988     | (19) 99872-7875 | teste@leads.com | true        | true      | Cadastro feito com sucesso! | Em breve, você receberá as novidades da Elo. |
