package ar.edu.unahur.obj2.tdd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.tdd.cajaFuerte.CajaFuerte;

public class CajaFuerteTest {

    @Test
    public void queLaCajaFuerteEsteAbierta(){
        CajaFuerte caja = new CajaFuerte();
        assertTrue(caja.estaAbierta());
    }

    @Test
    public void queSePuedeCerrarCajaFuerteConUnCodigo(){
        CajaFuerte caja = new CajaFuerte();
        caja.cerrar(1234);
        assertFalse(caja.estaAbierta());
    }

    @Test
    public void queSePuedeAbrirCajaFuerteConElCodigoCorrecto(){
        CajaFuerte caja = new CajaFuerte();
        caja.cerrar(1234);
        caja.abrir(1234);
        assertTrue(caja.estaAbierta());
    }

    @Test
    public void queNoPuedaAbrirLaCajaFuerteConElCodigoIncorrecto(){
        CajaFuerte caja = new CajaFuerte();
        caja.cerrar(1234);
        caja.abrir(1111);
        assertFalse(caja.estaAbierta());
    }

    @Test
    public void queNoPuedaCerrarLaCajaFuerteEstandoCerrada(){
        CajaFuerte caja = new CajaFuerte();
        caja.cerrar(1234);
        caja.cerrar(4321);
        caja.abrir(1234);
        assertTrue(caja.estaAbierta());
    }

}


/*

TDD: Rojo -> Verde -> Refactor (azul): cambio el como y no el que

Historia de usuario.

Como huesped del hotel
quiero utilizar una caja fuerte personal en mi habitacion,
para guardar objetos de valor de forma segura durante mi estadia

Criterios de aceptacion.

1. Caja abierta al inicio
    Dado que la caja fuerte ha sido recien creada
    Entonces debe encontrarse en estado abierto

2. Cierre de caja fuerte con codigo
    Dado que la caja fuerte esta abierta
    Cuando se le asigna un codigo al cerrarla
    Entonces debe quedar en estado cerrado

3. Apertura con codigo correcto
    Dado que esta cerrada con un codigo
    Cuando se intenta abrir con ese mismo codigo
    Entonces debe abrirse correctamente

4. No se abre con codigo incorrecto
    Dado que esta cerrada con un codigo
    Cuando se intenta abrir con un codigo diferente
    Entonces no debe abrirse
*/
