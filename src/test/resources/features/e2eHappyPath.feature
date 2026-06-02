@e2e @happy
Feature: Compra de articulo en Automation Exercise

  Background:
    Given que el usuario abre la pagina de Automation Exercise

  Scenario: E2E - Registro, seleccion de producto y pago exitoso
    When el usuario crea un usuario nuevo
    And completa el formulario de registro con sus datos personales
    And confirma la creacion de la cuenta
    And navega a la seccion de productos
    And agrega el producto Blue Top al carrito
    And procede al carrito de compras
    And procede al checkout
    And ingresa los datos de pago
    Then la orden de compra debe confirmarse exitosamente
