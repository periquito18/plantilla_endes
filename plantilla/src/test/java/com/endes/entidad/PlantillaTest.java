package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Pruebas unitarias para la clase Plantilla.
 */
class PlantillaTest {
    private Plantilla plantilla;

    @BeforeEach
    @DisplayName("Inicialización de la plantilla de empleados")
    void setUp() {
        plantilla = new Plantilla();
    }

    /**
     * Prueba que verifica que no se puedan contratar empleados con el mismo DNI.
     */
    @Test
    @DisplayName("No permite contratar empleados con el mismo DNI")
    void testContratarEmpleado_Duplicado() {
        Empleado tecnico1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1);
        Empleado tecnico2 = new Tecnico("11111111H", "Carlos", "Pérez", 1200.0, 2); // Mismo DNI que el primero

        // Se permite el primer contrato
        assertDoesNotThrow(() -> plantilla.contratarEmpleado(tecnico1));

        // Intentar contratar otro empleado con el mismo DNI debería lanzar una excepción
        Exception ex = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(tecnico2));

        // Verificar el mensaje de la excepción
        assertEquals("El empleado con DNI 11111111H ya está contratado", ex.getMessage());
    }
    
    @Test
    @DisplayName("Da un error si el dni o algún otro atributo de empleado es null")
    void testContratarEmpleadoNull() {
    	//Empleado tecnico3 = new Tecnico(null, null, null, null, 0);
    	Exception ex = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(null));
    	assertEquals("No se puede contratar un empleado nulo", ex.getMessage());
    }
    
    @Test
    @DisplayName("Probamos el método getEmpleadosPorNombre")
    void testGetEmpleadoPorNombre() {
    	Empleado tecnico4 = new Tecnico("22222222G", "Lola", "Ferran", 1000.00, 1);
    	//Empleado tecnico5 = new Tecnico("33333333I", "Guillermo", "Martinez", 1000.00, 1);
    	plantilla.contratarEmpleado(tecnico4);
    	//plantilla.contratarEmpleado(tecnico5);
    	assertEquals("Lola", plantilla.getEmpleadosPorNombre("Lola"));
    }
}