#Author: QA Team
#Language: en
@Orden7

Feature:Creacion de Barra de Navegacion
 Scenario: Funcionalidad de la Barra de Navegacion
    Given que estoy en una pagina de la aplicacion web
    When observo la barra de navegacion
    Then deberia haber una indicacion visual clara del elemento activo
    And deberia ver la barra de navegacion
    And deberia estar ubicada en la parte superior de la pagina
    And deberia ver enlaces a los diferentes modulos de la aplicacion web