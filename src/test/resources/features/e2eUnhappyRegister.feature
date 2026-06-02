@e2e @unhappy @register
Feature: Registro con datos no válidos en Automation Exercise

  Background:
    Given que el usuario abre la pagina de Automation Exercise

  Scenario Outline: E2E - No permite registrar un correo ya existente
    When el usuario intenta registrarse con nombre "<nombre>" y correo "<correo>"
    Then debe mostrarse el mensaje de correo existente

    Examples:
      | nombre | correo            |
      | Ana    | example@gmail.com |
      #| Pedro  | example1@gmail.com |
      #| Laura  | example2@gmail.com |

  Scenario Outline: E2E - No permite continuar si faltan name o email
    When el usuario intenta registrarse sin diligenciar el campo "<campo>"
    Then el navegador no debe permitir continuar con la creacion de la cuenta

    Examples:
      | campo |
      | name  |
      | email |

  Scenario Outline: E2E - Probar validaciones del formulario sin crear cuenta
    When el usuario completa el formulario dejando vacio el campo "<campo>"
    Then no debe mostrarse la confirmacion de creacion de cuenta

    Examples:
      | campo        |
      | password     |
      | first_name   |
      #| last_name    |
      #| address      |
      #| state        |
      #| city         |
      #| zipcode      |
      #| mobile_number |
