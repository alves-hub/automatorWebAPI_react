#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @cadastroUsuario @regressionSite
Funcionalidade: Cadastro no site Elo
  Eu como portador de um cartão Elo
  Desejo me cadastrar no Site Elo
  Para ter acesso às vantagens do cliente

  Contexto: 
    Dado que estou na tela de cadastro

  Esquema do Cenário: Validação de erros no cenário "<TipoErro>"
    Dado que realizo o preenchimento da tela com os dados "<CPF>", "<Nome>","<DataNascimento>", "<Celular>", "<Email>", "<ConfirmacaoEmail>", "<Senha>", "<RepetirSenha>", "<LiEConcordo>"
    Quando clico no botão Cadastrar
    Então vejo a mensagem de erro "<MensagemErro>"

    Exemplos: 
      | TipoErro                                                 | CPF            | Nome       | DataNascimento | Celular         | Email           | ConfirmacaoEmail | Senha    | RepetirSenha | LiEConcordo | MensagemErro                                        |
      | sem preencher CPF                                        |                | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | CPF inválido!                                       |
      | com CPF inválido                                         | 222.222.222-22 | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | CPF inválido!                                       |
      | sem preencher nome                                       | 379.127.190-32 |            | 12/12/1999     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Por favor, insira Nome e ao menos um Sobrenome.     |
      | preenchendo apenas nome, sem sobrenome                   | 379.127.190-32 | Nome       | 12/12/1999     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Por favor, insira Nome e ao menos um Sobrenome.     |
      | sem preencher data de nascimento                         | 379.127.190-32 | Nome Teste |                | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Data inválida!                                      |
      | com data de nascimento inválida                          | 379.127.190-32 | Nome Teste | 13/13/1999     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Data inválida!                                      |
      | com data menor de 13 anos                                | 379.127.190-32 | Nome Teste | 13/12/2019     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Você deve ser maior de 13 anos                      |
      | com data acima da data atual                             | 379.127.190-32 | Nome Teste | 13/12/2030     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Data de nascimento deve ser anterior ao dia de hoje |
      | sem preencher o celular                                  | 379.127.190-32 | Nome Teste | 12/12/1999     |                 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Por favor, insira um telefone válido.               |
      | preenchendo com celular inválido                         | 379.127.190-32 | Nome Teste | 12/12/1999     | (11) 11111-1111 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Por favor, insira um telefone válido.               |
      | sem preencher e-mail                                     | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 |                 | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Por favor, insira um email válido.                  |
      | preenchendo e-mail inválido                              | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 | email@invalido  | teste@teste.com  | Qwe123?! | Qwe123?!     | true        | Por favor, insira um email válido.                  |
      | sem preencher a confirmação de e-mail                    | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com |                  | Qwe123?! | Qwe123?!     | true        | Os e-mails não coincidem                            |
      | com e-mail de confirmação diferente do e-mail            | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | testee@teste.com | Qwe123?! | Qwe123?!     | true        | Os e-mails não coincidem                            |
      | sem preencher senha                                      | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | teste@teste.com  |          | Qwe123?!     | true        | Campo senha deve ser preenchido!                    |
      | preenchendo senha sem atender os requisitos de segurança | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123!  | Qwe123?!     | true        | A senha não cumpre os requisitos abaixo             |
      | sem preencher a confirmação da senha                     | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! |              | true        | As senhas não coincidem                             |
      | sem marcar a opção Li e concordo                         | 379.127.190-32 | Nome Teste | 12/12/1999     | (99) 99999-9999 | teste@teste.com | teste@teste.com  | Qwe123?! | Qwe123?!     | false       | Campo Obrigatório!                                  |

  @availableSite
  Esquema do Cenário: Validação de preenchimento de CEP com valor "<Situacao>"
    Dado que preencho o campo CEP com valor "<CEP>"
    Quando finalizar o loading da busca do cep
    Entao será preenchido os campos de endereço com os valores "<Endereco>" "<Numero>" "<Complemento>" "<Bairro>" "<Cidade>" "<Estado>"

    Exemplos: 
      | Situacao | CEP       | Endereco   | Numero | Complemento | Bairro        | Cidade    | Estado |
      | inválido | 13500-000 |            |        |             |               |           |        |
      | válido   | 13504-130 | Avenida 38 |        |             | Vila Operária | Rio Claro | SP     |

  Esquema do Cenário: Realização de cadastro com sucesso "<TipoCadastro>"
    Dado que preencho os campos "<CPF>" "<Nome>" "<DataNascimento>" "<Celular>" "<Email>" "<Senha>" "<LiEConcordo>" "<CheckEmail>" "<CheckSMS>"
    E preencho os campos "<CEP>" "<Endereco>" "<Numero>" "<Complemento>" "<Bairro>" "<Cidade>" "<Estado>"
    Quando clico no botão Cadastrar
    Entao será exibido o segundo passo do cadastro
    E o usuário cadastrado será excluido da base via API

    Exemplos: 
      | TipoCadastro          | CPF    | Nome          | DataNascimento | Celular         | CEP       | Endereco   | Numero | Complemento         | Bairro        | Cidade    | Estado | Email                  | Senha    | LiEConcordo | CheckEmail | CheckSMS |
      | com Endereço          | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | false      | false    |
      | sem Endereço          | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 |           |            |        |                     |               |           |        | teste@automatizado.com | Qwe123?! | true        | false      | false    |
      | com optin Email       | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | true       | false    |
      | com optin SMS         | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | false      | true     |
      | com optin Email e SMS | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | true       | true     |

  Esquema do Cenário: Realização de cadastro de usuário com sucesso e validação de erros de cadastro de cartão "<TipoCadastro>"
    Dado que preencho os campos "<CPF>" "<Nome>" "<DataNascimento>" "<Celular>" "<Email>" "<Senha>" "<LiEConcordo>" "<CheckEmail>" "<CheckSMS>"
    E preencho os campos "<CEP>" "<Endereco>" "<Numero>" "<Complemento>" "<Bairro>" "<Cidade>" "<Estado>"
    E avanço para o passo 2
    Quando preencho na tela de cartão os valores "<BinCartao>" "<Mes>" "<Ano>"
    E clico em Finalizar
    Entao vejo a mensagem de erro "<MensagemErro>"
    E o usuário cadastrado será excluido da base via API

    Exemplos: 
      | TipoCadastro                  | CPF    | Nome          | DataNascimento | Celular         | CEP       | Endereco   | Numero | Complemento         | Bairro        | Cidade    | Estado | Email                  | Senha    | LiEConcordo | CheckEmail | CheckSMS | BinCartao | Mes | Ano  | MensagemErro                                           |
      | com vencimento sem ano        | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | false      | false    |    655002 |  04 |      | Por favor selecione a data de vencimento               |
      | com vencimento sem mês        | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | false      | false    |    655002 |     | 2025 | Por favor selecione a data de vencimento               |
      | com número de cartão inválido | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | false      | false    | Invalido  |  06 | 2025 | Confira o número do seu cartão                         |
      | com bin que não é bin Elo     | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | false      | false    |    514009 |  06 | 2025 | Número de cartão inválido. Por favor, tente novamente. |

	@e2eSite @e2eCadastroUsuario
  Esquema do Cenário: Realização de cadastro de usuário com sucesso e "<TipoCadastro>"
    Dado que preencho os campos "<CPF>" "<Nome>" "<DataNascimento>" "<Celular>" "<Email>" "<Senha>" "<LiEConcordo>" "<CheckEmail>" "<CheckSMS>"
    E preencho os campos "<CEP>" "<Endereco>" "<Numero>" "<Complemento>" "<Bairro>" "<Cidade>" "<Estado>"
    E avanço para o passo 2
    Quando preencho na tela de cartão os valores "<BinCartao>" "<Mes>" "<Ano>"
    E clico em Finalizar
    Entao vejo a mensagem de sucesso "<MensagemSucesso>"
    E o botão Navegar no site Elo
    E o usuário cadastrado será excluido da base via API

    Exemplos: 
      | TipoCadastro                          | CPF    | Nome          | DataNascimento | Celular         | CEP       | Endereco   | Numero | Complemento         | Bairro        | Cidade    | Estado | Email                  | Senha    | LiEConcordo | CheckEmail | CheckSMS | BinCartao | Mes | Ano  | MensagemSucesso              |
      | com cadastro de cartão com vencimento | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | false      | false    |    655002 |  06 | 2025 | Cadastro criado com sucesso. |
      | com cadastro de cartão sem vencimento | Random | Fulano De Tal | 16/02/1998     | (19) 99755-4450 | 13504-130 | Avenida 38 |    945 | Esquina com a rua 7 | Vila Operária | Rio Claro | SP     | teste@automatizado.com | Qwe123?! | true        | false      | false    |    655002 |     |      | Cadastro criado com sucesso. |
