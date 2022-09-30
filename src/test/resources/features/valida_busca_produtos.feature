Feature: valida busca de produtos

  Scenario: Realiza a pesquisa pelo primeiro item da lista CSV de produtos valido
    Given acesso a home de produtos
    When realizo uma busca pelo item "0" da lista de produtos
    Then vejo se o produto pesquisado foi encontrado com o nome "limpa vidros" na lista de resultados

    Scenario: Realiza a pesquisa pelo segundo item da lista CSV de produtos valido
      Given acesso a home de produtos
      When  realizo uma busca pelo item "1" da lista de produtos
      Then vejo se o produto pesquisado foi encontrado com o nome "iphone 8 plus" na lista de resultados

  Scenario: Realiza a pesquisa pelo terceiro item da lista CSV de produtos invalido
    Given acesso a home de produtos
    When  realizo uma busca pelo item "2" da lista de produtos
    Then vejo se a mensagem de erro foi encontrada "Não encontramos anúncios"