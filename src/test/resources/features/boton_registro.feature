#Author: QA Team
#Language: es

Feature: Boton de registro

  Scenario: Usuario no registrado accede al boton de registro
    Given que estoy en cualquier pagina de la aplicacion
    When hago clic en el botón de registro
    Then debería ser redirigido a la pagina de registro