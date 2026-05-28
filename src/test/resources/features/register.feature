Feature: Registro de usuario
  Scenario: Registro exitoso
    Given que el usuario ingresa a la pagina
    When selecciona la opcion de registro
    And completa el formulario correctamente
    Then la cuenta debe crearse exitosamente