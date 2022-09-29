Feature: Valida tela de Login

  Scenario: Realiza a pesquisa pelo primeiro item da lista CSV de produtos valido
    Given acesso a home de produtos
    When  realizo uma busca pelo item "0" da lista de produtos
    Then vejo se o produto pesquisado foi encontrado com o nome "limpa vidros"

    Scenario: Realiza a pesquisa pelo segundo item da lista CSV de produtos valido
      Given acesso a home de produtos
      When  realizo uma busca pelo item "1" da lista de produtos
      Then vejo se o produto pesquisado foi encontrado com o nome "iphone 8 plus"

  Scenario: Realiza a pesquisa pelo terceiro item da lista CSV de produtos invalido
    Given acesso a home de produtos
    When  realizo uma busca pelo item "1" da lista de produtos
    Then vejo se a mensagem de erro foi encontrada "Não encontramos anuncios"

  Scenario: Realiza a pesquisa por todos os itens da lista CSV de produto
    Given acesso a home de produtos
    When  realizo varias buscas por todos os itens da lista
    Then vejo se os resultados encontrados tiveram os valores "limpa vidros, iphone 8 plus, Não encontramos anuncios"