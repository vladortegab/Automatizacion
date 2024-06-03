#Author: QA Team
#Language: es
@Orden4

Feature: Validación de formulario de registro
Scenario: Verificar campos obligatorios en el formulario de registro
    Given que estoy en la pagina de registro
    When se registren los datos requeridos para el registro del usuario Nombre, Apellidos, Telefono, Identificacion, Correo Electronico y Contrasena
    Then intento enviar el formulario completo con todos los campos obligatorios
    And deberia ingresar satisfactoriamente a la interfaz de usuario registrado