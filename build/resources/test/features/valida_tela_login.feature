Feature: Valida tela de Login

  Scenario: Realiza login com cliente valido
    Given acesso a home de produtos
    When  realizo uma busca pelo primeiro produto da lista de produtos
    Then vejo se o produto pesquisado foi encontrado
