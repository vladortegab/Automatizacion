#Author: QA Team
#Language: es
@Orden6

Feature: Asignacion de permisos de administrador
Scenario: Asignar permisos de administrador a un usuario registrado
    Given que el usuario esta autenticado en la plataforma Orden6
    When  me dirijo a la pestana de asignacion de roles
    Then asigno permisos de administrador a un usuario registrado
    And el usuario seleccionado ahora debe tener permisos de administrador