#Author: QA Team
#Language: en
@Orden3

Feature: Botón de Registro en la Barra de Navegación
Scenario: Usuario no registrado accede al boton de registro
    Given que estoy en cualquier pagina de la aplicacion
    When  estoy en la pagina de inicio de sesion
    And hago clic en el boton de registro
    Then deberia ser redirigido a la pagina de registro