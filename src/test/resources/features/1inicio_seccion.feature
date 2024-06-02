#Author: QA Team
#Language: en
@Orden1

Feature: Iniciar Sesion con Credenciales Validas.

  Scenario: Iniciar Sesion en la Aplicacion Web.
    Given que estoy en la pagina de inicio de sesion
    When ingreso mi correo electronico y contrasena
    When hago clic en el boton Iniciar Sesion
    Then deberia ver un indicador de carga mientras se verifican mis credenciales
    Then deberia ser redirigido a la pagina principal de la aplicacion

