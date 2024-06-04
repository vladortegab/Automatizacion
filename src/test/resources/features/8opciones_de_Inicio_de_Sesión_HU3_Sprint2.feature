#Author: QA Team
#Language: en
@Orden8

Feature: Opciones de Inicio de Sesion con Google y Facebook
Scenario: Iniciar Sesion con Google
    Given que estoy en la pagina de inicio de sesion Orden8
    When hago clic en el boton de inicio de sesion con Google
    Then debo ser redirigido automaticamente al flujo de autenticacion de Google
    And despues de completar el flujo de autenticacion en Google
    Then deberia de redirigirme de vuelta a la pagina de inicio de sesion de manera automatica