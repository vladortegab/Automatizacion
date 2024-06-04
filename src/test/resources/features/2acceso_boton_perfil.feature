#Author: QA Team
#Language: es
@Orden2

Feature: Acceso a la Pestana de Perfil

  Scenario: Visualizar Datos Personales
    Given que el usuario esta autenticado en la plataforma Orden2
    When haga clic en el icono de perfil en la barra de navegacion
    Then se desplegara un menu con varias opciones, incluida la opcion de Perfil
    And al hacer clic en Perfil, se dirigira al usuario a la pestana de perfil
    And se cargaran los datos personales actuales del usuario Nombre, Apellidos, Telefono, Identificacion y Correo Electronico
    And aparece visible el boton de Edicion