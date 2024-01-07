/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.example.TAdyacencia;
import org.example.TArista;
import org.example.TGrafoDirigido;
import org.example.TVertice;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class TGrafoDirigidoTest {
    
    public TGrafoDirigidoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testEliminarArista() {
        System.out.println("eliminarArista");
        ArrayList<TVertice> vertices = new ArrayList<>(8);
        
        TVertice vertice1 = new TVertice("Artigas");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("Canelones");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("Durazno");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("Colonia");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("Punta del Este");
        vertices.add(vertice5);
        TVertice vertice6 = new TVertice("Florida");
        vertices.add(vertice6);
        TVertice vertice7 = new TVertice("Montevideo");
        vertices.add(vertice7);
        TVertice vertice8 = new TVertice("Rocha");
        vertices.add(vertice8);
        

        ArrayList<TArista> aristas = new ArrayList<TArista>(12);
        
        TArista arista1 = new TArista("Artigas", "Canelones", 400);
        aristas.add(arista1);
        TArista arista2 = new TArista("Canelones", "Artigas", 500);
        aristas.add(arista2);
        TArista arista3 = new TArista("Canelones", "Colonia", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("Canelones", "Durazno", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("Canelones", "Punta del Este", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("Colonia", "Montevideo", 180);
        aristas.add(arista6);
        TArista arista7 = new TArista("Florida", "Durazno", 60);
        aristas.add(arista7);
        TArista arista8 = new TArista("Montevideo", "Artigas", 700);
        aristas.add(arista8);
        TArista arista9 = new TArista("Montevideo", "Canelones", 30);
        aristas.add(arista9);
        TArista arista10 = new TArista("Montevideo", "Punta del Este", 130);
        aristas.add(arista10);
        TArista arista11 = new TArista("Punta del Este", "Rocha", 90);
        aristas.add(arista11);
        TArista arista12 = new TArista("Rocha", "Montevideo", 270);
        aristas.add(arista12);
        
        

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        Comparable nomVerticeOrigen = "Florida";
        Comparable nomVerticeDestino = "Durazno";
        boolean expResult = true;
        boolean result = grafo.eliminarArista(nomVerticeOrigen, nomVerticeDestino);
        assertEquals(expResult, result);
    }

    @Test
    public void testExisteArista() {
         System.out.println("existeArista");
        ArrayList<TVertice> vertices = new ArrayList<>(8);
        
        TVertice vertice1 = new TVertice("Artigas");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("Canelones");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("Durazno");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("Colonia");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("Punta del Este");
        vertices.add(vertice5);
        TVertice vertice6 = new TVertice("Florida");
        vertices.add(vertice6);
        TVertice vertice7 = new TVertice("Montevideo");
        vertices.add(vertice7);
        TVertice vertice8 = new TVertice("Rocha");
        vertices.add(vertice8);
        

        ArrayList<TArista> aristas = new ArrayList<TArista>(12);
        
        TArista arista1 = new TArista("Artigas", "Canelones", 400);
        aristas.add(arista1);
        TArista arista2 = new TArista("Canelones", "Artigas", 500);
        aristas.add(arista2);
        TArista arista3 = new TArista("Canelones", "Colonia", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("Canelones", "Durazno", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("Canelones", "Punta del Este", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("Colonia", "Montevideo", 180);
        aristas.add(arista6);
        TArista arista7 = new TArista("Florida", "Durazno", 60);
        aristas.add(arista7);
        TArista arista8 = new TArista("Montevideo", "Artigas", 700);
        aristas.add(arista8);
        TArista arista9 = new TArista("Montevideo", "Canelones", 30);
        aristas.add(arista9);
        TArista arista10 = new TArista("Montevideo", "Punta del Este", 130);
        aristas.add(arista10);
        TArista arista11 = new TArista("Punta del Este", "Rocha", 90);
        aristas.add(arista11);
        TArista arista12 = new TArista("Rocha", "Montevideo", 270);
        aristas.add(arista12);
        
        

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        
        Comparable nomVerticeOrigen = "Florida";
        Comparable nomVerticeDestino = "Durazno";
        boolean expResult = true;
        boolean result = grafo.existeArista(nomVerticeOrigen, nomVerticeDestino);
        assertEquals(expResult, result);
    }

    @Test
    public void testExisteVertice() {
        System.out.println("existeVertice");
        ArrayList<TVertice> vertices = new ArrayList<>(8);
        
        TVertice vertice1 = new TVertice("Artigas");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("Canelones");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("Durazno");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("Colonia");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("Punta del Este");
        vertices.add(vertice5);
        TVertice vertice6 = new TVertice("Florida");
        vertices.add(vertice6);
        TVertice vertice7 = new TVertice("Montevideo");
        vertices.add(vertice7);
        TVertice vertice8 = new TVertice("Rocha");
        vertices.add(vertice8);
        

        ArrayList<TArista> aristas = new ArrayList<TArista>(12);
        
        TArista arista1 = new TArista("Artigas", "Canelones", 400);
        aristas.add(arista1);
        TArista arista2 = new TArista("Canelones", "Artigas", 500);
        aristas.add(arista2);
        TArista arista3 = new TArista("Canelones", "Colonia", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("Canelones", "Durazno", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("Canelones", "Punta del Este", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("Colonia", "Montevideo", 180);
        aristas.add(arista6);
        TArista arista7 = new TArista("Florida", "Durazno", 60);
        aristas.add(arista7);
        TArista arista8 = new TArista("Montevideo", "Artigas", 700);
        aristas.add(arista8);
        TArista arista9 = new TArista("Montevideo", "Canelones", 30);
        aristas.add(arista9);
        TArista arista10 = new TArista("Montevideo", "Punta del Este", 130);
        aristas.add(arista10);
        TArista arista11 = new TArista("Punta del Este", "Rocha", 90);
        aristas.add(arista11);
        TArista arista12 = new TArista("Rocha", "Montevideo", 270);
        aristas.add(arista12);
        
        

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        
        Comparable etiqueta = "Florida";
        boolean expResult = true;
        grafo.existeVertice(etiqueta);
        Map<Comparable, TVertice> mapa = grafo.getVertices();
        boolean result = mapa.values().contains(mapa.get(etiqueta));
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertarArista() {
        System.out.println("insertarArista");
        ArrayList<TVertice> vertices = new ArrayList<>(8);
        
        TVertice vertice1 = new TVertice("Artigas");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("Canelones");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("Durazno");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("Colonia");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("Punta del Este");
        vertices.add(vertice5);
        TVertice vertice6 = new TVertice("Florida");
        vertices.add(vertice6);
        TVertice vertice7 = new TVertice("Montevideo");
        vertices.add(vertice7);
        TVertice vertice8 = new TVertice("Rocha");
        vertices.add(vertice8);
        

        ArrayList<TArista> aristas = new ArrayList<TArista>(12);
        
        TArista arista1 = new TArista("Artigas", "Canelones", 400);
        aristas.add(arista1);
        TArista arista2 = new TArista("Canelones", "Artigas", 500);
        aristas.add(arista2);
        TArista arista3 = new TArista("Canelones", "Colonia", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("Canelones", "Durazno", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("Canelones", "Punta del Este", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("Colonia", "Montevideo", 180);
        aristas.add(arista6);
        TArista arista7 = new TArista("Florida", "Durazno", 60);
        aristas.add(arista7);
        TArista arista8 = new TArista("Montevideo", "Artigas", 700);
        aristas.add(arista8);
        TArista arista9 = new TArista("Montevideo", "Canelones", 30);
        aristas.add(arista9);
        TArista arista10 = new TArista("Montevideo", "Punta del Este", 130);
        aristas.add(arista10);
        TArista arista11 = new TArista("Punta del Este", "Rocha", 90);
        aristas.add(arista11);
        TArista arista12 = new TArista("Rocha", "Montevideo", 270);
        aristas.add(arista12);
        
        

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        TArista arista = new TArista("Florida", "Montevideo", 10);
        grafo.insertarArista(arista);
        boolean expResult = true;
        LinkedList<TAdyacencia> a = grafo.getVertices().get(arista.getEtiquetaOrigen()).getAdyacentes();
        
        boolean result = false;
        
        for (TAdyacencia b : a){
            if (b.getEtiqueta()== arista.getEtiquetaDestino()){
                result = true;
            }
        }
                
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertarVertice_Comparable() {
        ArrayList<TVertice> vertices = new ArrayList<>(8);
        
        TVertice vertice1 = new TVertice("Artigas");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("Canelones");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("Durazno");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("Colonia");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("Punta del Este");
        vertices.add(vertice5);
        TVertice vertice6 = new TVertice("Florida");
        vertices.add(vertice6);
        TVertice vertice7 = new TVertice("Montevideo");
        vertices.add(vertice7);
        TVertice vertice8 = new TVertice("Rocha");
        vertices.add(vertice8);
        

        ArrayList<TArista> aristas = new ArrayList<TArista>(12);
        
        TArista arista1 = new TArista("Artigas", "Canelones", 400);
        aristas.add(arista1);
        TArista arista2 = new TArista("Canelones", "Artigas", 500);
        aristas.add(arista2);
        TArista arista3 = new TArista("Canelones", "Colonia", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("Canelones", "Durazno", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("Canelones", "Punta del Este", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("Colonia", "Montevideo", 180);
        aristas.add(arista6);
        TArista arista7 = new TArista("Florida", "Durazno", 60);
        aristas.add(arista7);
        TArista arista8 = new TArista("Montevideo", "Artigas", 700);
        aristas.add(arista8);
        TArista arista9 = new TArista("Montevideo", "Canelones", 30);
        aristas.add(arista9);
        TArista arista10 = new TArista("Montevideo", "Punta del Este", 130);
        aristas.add(arista10);
        TArista arista11 = new TArista("Punta del Este", "Rocha", 90);
        aristas.add(arista11);
        TArista arista12 = new TArista("Rocha", "Montevideo", 270);
        aristas.add(arista12);
        
        

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        System.out.println("insertarVertice");
        
        boolean expResult = true;
        Comparable etiqueta = "C";
        grafo.insertarVertice(etiqueta);
        Map<Comparable, TVertice> mapa = grafo.getVertices();
        boolean result = mapa.values().contains(mapa.get(etiqueta));
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertarVertice_TVertice() {
        System.out.println("insertarVertice");
        TVertice vertice = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.insertarVertice(vertice);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEtiquetasOrdenado() {
        System.out.println("getEtiquetasOrdenado");
        TGrafoDirigido instance = null;
        Object[] expResult = null;
        Object[] result = instance.getEtiquetasOrdenado();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetVertices() {
        System.out.println("getVertices");
        ArrayList<TVertice> vertices = new ArrayList<>(8);
        
        TVertice vertice1 = new TVertice("Artigas");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("Canelones");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("Durazno");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("Colonia");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("Punta del Este");
        vertices.add(vertice5);
        TVertice vertice6 = new TVertice("Florida");
        vertices.add(vertice6);
        TVertice vertice7 = new TVertice("Montevideo");
        vertices.add(vertice7);
        TVertice vertice8 = new TVertice("Rocha");
        vertices.add(vertice8);
        

        ArrayList<TArista> aristas = new ArrayList<TArista>(12);
        
        TArista arista1 = new TArista("Artigas", "Canelones", 400);
        aristas.add(arista1);
        TArista arista2 = new TArista("Canelones", "Artigas", 500);
        aristas.add(arista2);
        TArista arista3 = new TArista("Canelones", "Colonia", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("Canelones", "Durazno", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("Canelones", "Punta del Este", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("Colonia", "Montevideo", 180);
        aristas.add(arista6);
        TArista arista7 = new TArista("Florida", "Durazno", 60);
        aristas.add(arista7);
        TArista arista8 = new TArista("Montevideo", "Artigas", 700);
        aristas.add(arista8);
        TArista arista9 = new TArista("Montevideo", "Canelones", 30);
        aristas.add(arista9);
        TArista arista10 = new TArista("Montevideo", "Punta del Este", 130);
        aristas.add(arista10);
        TArista arista11 = new TArista("Punta del Este", "Rocha", 90);
        aristas.add(arista11);
        TArista arista12 = new TArista("Rocha", "Montevideo", 270);
        aristas.add(arista12);
        
        

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        Map<Comparable, TVertice> mapa = grafo.getVertices();
        Map<Comparable, TVertice> result = grafo.getVertices();
        assertEquals(mapa, result);
    }

    @Test
    public void testCentroDelGrafo() {
        System.out.println("centroDelGrafo");
        ArrayList<TVertice> vertices = new ArrayList<>(8);
        
        TVertice vertice1 = new TVertice("Artigas");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("Canelones");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("Durazno");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("Colonia");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("Punta del Este");
        vertices.add(vertice5);
        TVertice vertice6 = new TVertice("Florida");
        vertices.add(vertice6);
        TVertice vertice7 = new TVertice("Montevideo");
        vertices.add(vertice7);
        TVertice vertice8 = new TVertice("Rocha");
        vertices.add(vertice8);
        

        ArrayList<TArista> aristas = new ArrayList<TArista>(12);
        
        TArista arista1 = new TArista("Artigas", "Canelones", 400);
        aristas.add(arista1);
        TArista arista2 = new TArista("Canelones", "Artigas", 500);
        aristas.add(arista2);
        TArista arista3 = new TArista("Canelones", "Colonia", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("Canelones", "Durazno", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("Canelones", "Punta del Este", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("Colonia", "Montevideo", 180);
        aristas.add(arista6);
        TArista arista7 = new TArista("Florida", "Durazno", 60);
        aristas.add(arista7);
        TArista arista8 = new TArista("Montevideo", "Artigas", 700);
        aristas.add(arista8);
        TArista arista9 = new TArista("Montevideo", "Canelones", 30);
        aristas.add(arista9);
        TArista arista10 = new TArista("Montevideo", "Punta del Este", 130);
        aristas.add(arista10);
        TArista arista11 = new TArista("Punta del Este", "Rocha", 90);
        aristas.add(arista11);
        TArista arista12 = new TArista("Rocha", "Montevideo", 270);
        aristas.add(arista12);
        
        

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        Comparable expResult = "Artigas";
        Comparable result = grafo.centroDelGrafo();
        assertEquals(expResult, result);
    }

    @Test
    public void testPrecedenciaDefloyd() {
        System.out.println("precedenciaDefloyd");
        TGrafoDirigido instance = null;
        int[][] expResult = null;
        int[][] result = instance.precedenciaDefloyd();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerExcentricidad() {
        System.out.println("obtenerExcentricidad");
        ArrayList<TVertice> vertices = new ArrayList<>(8);
        
        TVertice vertice1 = new TVertice("Artigas");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("Canelones");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("Durazno");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("Colonia");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("Punta del Este");
        vertices.add(vertice5);
        TVertice vertice6 = new TVertice("Florida");
        vertices.add(vertice6);
        TVertice vertice7 = new TVertice("Montevideo");
        vertices.add(vertice7);
        TVertice vertice8 = new TVertice("Rocha");
        vertices.add(vertice8);
        

        ArrayList<TArista> aristas = new ArrayList<TArista>(12);
        
        TArista arista1 = new TArista("Artigas", "Canelones", 400);
        aristas.add(arista1);
        TArista arista2 = new TArista("Canelones", "Artigas", 500);
        aristas.add(arista2);
        TArista arista3 = new TArista("Canelones", "Colonia", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("Canelones", "Durazno", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("Canelones", "Punta del Este", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("Colonia", "Montevideo", 180);
        aristas.add(arista6);
        TArista arista7 = new TArista("Florida", "Durazno", 60);
        aristas.add(arista7);
        TArista arista8 = new TArista("Montevideo", "Artigas", 700);
        aristas.add(arista8);
        TArista arista9 = new TArista("Montevideo", "Canelones", 30);
        aristas.add(arista9);
        TArista arista10 = new TArista("Montevideo", "Punta del Este", 130);
        aristas.add(arista10);
        TArista arista11 = new TArista("Punta del Este", "Rocha", 90);
        aristas.add(arista11);
        TArista arista12 = new TArista("Rocha", "Montevideo", 270);
        aristas.add(arista12);
        
        

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        Comparable etiquetaVertice = "Canelones";
        Comparable expResult = 400.0;
        Comparable result = grafo.obtenerExcentricidad(etiquetaVertice);
        assertEquals(expResult, result);
    }

    @Test
    public void testWarshall() {
        System.out.println("warshall");
        TGrafoDirigido instance = null;
        boolean[][] expResult = new boolean[8][8];
        
        boolean[][] result = instance.warshall();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testEliminarVertice() {
        System.out.println("eliminarVertice");
        Comparable nombreVertice = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.eliminarVertice(nombreVertice);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testContieneCiclos() {
        System.out.println("contieneCiclos");
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.tieneCiclo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBpf_Comparable() {
        System.out.println("bpf");
        Comparable etiquetaOrigen = null;
        TGrafoDirigido instance = null;
        Collection<TVertice> expResult = null;
        Collection<TVertice> result = instance.bpf(etiquetaOrigen);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public <TCamino> void testObtenerCamino() {
        System.out.println("obtenerCamino");
        Comparable etiqueta1 = null;
        Comparable etiqueta2 = null;
        TGrafoDirigido instance = null;
        TCamino expResult = null;
        TCamino result = (TCamino) instance.obtenerCamino(etiqueta1, etiqueta2);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testClasificacionTopologica() {
        System.out.println("clasificacionTopologica");
        TGrafoDirigido instance = null;
        LinkedList<TVertice> expResult = null;
        LinkedList<TVertice> result = instance.clasificacionTopologica();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public <TCaminos> void testTodosLosCaminos() {
        System.out.println("todosLosCaminos");
        Comparable etiquetaOrigen = null;
        Comparable etiquetaDestino = null;
        TGrafoDirigido instance = null;
        TCaminos expResult = null;
        TCaminos result = (TCaminos) instance.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testExisteCamino() {
        System.out.println("existeCamino");
        Comparable etiqueta1 = null;
        Comparable etiqueta2 = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.existeCamino(etiqueta1, etiqueta2);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOrdenParcial() {
        System.out.println("ordenParcial");
        TGrafoDirigido instance = null;
        LinkedList<TVertice> expResult = null;
        LinkedList<TVertice> result = instance.ordenParcial();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBpf_0args() {
        System.out.println("bpf");
        TGrafoDirigido instance = null;
        Collection<TVertice> expResult = null;
        Collection<TVertice> result = instance.bpf();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBpf_TVertice() {
        System.out.println("bpf");
        TVertice verticeOrigen = null;
        TGrafoDirigido instance = null;
        Collection<TVertice> expResult = null;
        Collection<TVertice> result = instance.bpf(verticeOrigen);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testConexionTotal() {
        System.out.println("conexionTotal");
        ArrayList<TVertice> vertices = new ArrayList<>(8);
        
        TVertice vertice1 = new TVertice("A");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("B");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("C");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("D");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("E");
        vertices.add(vertice5);
        TVertice vertice6 = new TVertice("F");
        vertices.add(vertice6);
        TVertice vertice7 = new TVertice("G");
        vertices.add(vertice7);
        

        LinkedList<TArista> aristas = new LinkedList<TArista>();
        
        TArista arista1 = new TArista("A", "B", 10);
        aristas.add(arista1);
        TArista arista3 = new TArista("A", "C", 10);
        aristas.add(arista3);
        TArista arista5 = new TArista("B", "D", 10);
        aristas.add(arista5);
        TArista arista6 = new TArista("B", "E", 10);
        aristas.add(arista6);
        TArista arista2 = new TArista("C", "F", 10);
        aristas.add(arista2);
        TArista arista8 = new TArista("C", "G", 10);
        aristas.add(arista8);
        
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        
        boolean expected = true;
        boolean result = grafo.conexionTotal("A");
                
        assertEquals(expected, result);
    }
    
    @Test
    public void TestCaminoConMenosSaltos() {
        System.out.println("caminoConMenosSaltos");
        
        ArrayList<TVertice> vertices = new ArrayList<>(5);
        TVertice vertice1 = new TVertice("A");
        vertices.add(vertice1);
        TVertice vertice2 = new TVertice("B");
        vertices.add(vertice2);
        TVertice vertice3 = new TVertice("C");
        vertices.add(vertice3);
        TVertice vertice4 = new TVertice("D");
        vertices.add(vertice4);
        TVertice vertice5 = new TVertice("E");
        vertices.add(vertice5);
        
        LinkedList<TArista> aristas = new LinkedList<TArista>();
        
        TArista arista1 = new TArista("A", "B", 10);
        aristas.add(arista1);
        TArista arista3 = new TArista("B", "C", 10);
        aristas.add(arista3);
        TArista arista5 = new TArista("C", "D", 10);
        aristas.add(arista5);
        TArista arista6 = new TArista("D", "E", 10);
        aristas.add(arista6);
        TArista arista2 = new TArista("A", "D", 10);
        aristas.add(arista2);
        
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        
        LinkedList<Comparable> listaEsperada = new LinkedList<>();
        listaEsperada.add("A");
        listaEsperada.add("D");
        listaEsperada.add("E");
        
        LinkedList<Comparable> lista = grafo.caminoConMenosSaltos("A", "E");
        System.out.println("");
        assertEquals(listaEsperada, lista);
    }
}
