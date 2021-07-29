#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @avisoDePrivacidade @regressionSite
Funcionalidade: Aviso de Privacidade
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Aviso de Privacidade
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Aviso de Privacidade
    Dado que acessei a página Aviso de Privacidade
    Entao a pagina Aviso de Privacidade é apresentada contendo os textos "<Titulo>" e "<Subtitulo>"

    Exemplos: 
      | Titulo                  | Subtitulo                                                                                                                                                                                                                                                                                                                                                                                          |
      | Política de privacidade | Esta Política de Privacidade busca informar como a Elo Serviços S.A. (“Elo”), por meio de seu website http://www.elo.com.br, doravante denominado apenas como ‘website’, coleta, usa e compartilha as informações de seus Usuários. O website é publicado e mantido pela Elo localizada na Alameda Xingu, 512 - 5º andar -Barueri/SP, devidamente inscrita no CNPJ/MF sob o nº 09.227.084/0001-75. |
