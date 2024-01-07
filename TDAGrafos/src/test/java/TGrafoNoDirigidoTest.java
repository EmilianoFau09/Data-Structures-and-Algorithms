/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.example.TArista;
import org.example.TGrafoNoDirigido;
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
public class TGrafoNoDirigidoTest {
    
    public TGrafoNoDirigidoTest() {
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
    public void testInsertarArista() {
        System.out.println("insertarArista");
        TArista arista = new TArista("A", "F", 5);
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
        

        LinkedList<TArista> aristas = new LinkedList<TArista>();
        
        TArista arista1 = new TArista("A", "B", 400);
        aristas.add(arista1);
        TArista arista3 = new TArista("B", "E", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("A", "C", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("D", "C", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("B", "E", 90);
        aristas.add(arista6);
        TArista arista7 = new TArista("A", "E", 90);
        aristas.add(arista7);
        


        
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        grafo.insertarArista(arista);
        boolean expResult = true;
        Map<Comparable, TVertice> map = grafo.getVertices();
        
        boolean result = map.get("A").conectadoCon(map.get("E"));
        assertEquals(expResult, result);
    }

    @Test
    public void testPrim() {
        System.out.println("Prim");
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
        
        TArista arista1 = new TArista("A", "C", 10);
        aristas.add(arista1);
        TArista arista3 = new TArista("C", "E", 30);
        aristas.add(arista3);
        TArista arista4 = new TArista("G", "C", 10);
        aristas.add(arista4);
        TArista arista5 = new TArista("F", "C", 100);
        aristas.add(arista5);
        TArista arista6 = new TArista("F", "D", 5);
        aristas.add(arista6);
        TArista arista7 = new TArista("A", "E", 90);
        aristas.add(arista7);
        TArista arista9 = new TArista("G", "F", 10);
        aristas.add(arista9);
        TArista arista2 = new TArista("B", "C", 90);
        aristas.add(arista2);
        TArista arista8 = new TArista("B", "D", 5);
        aristas.add(arista8);
        
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        System.out.println("Costo viejo: "+ grafo.getCosto());
               
                
        TGrafoNoDirigido nuevoGrafo = grafo.Prim();
        
        int expected = 35;
        int result = (int) nuevoGrafo.getCosto();
        
           
        assertEquals(expected, result);
    }

    @Test
    public void testKruskal() {
        System.out.println("Kruskal");
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
        
        TArista arista1 = new TArista("A", "C", 10);
        aristas.add(arista1);
        TArista arista3 = new TArista("C", "E", 30);
        aristas.add(arista3);
        TArista arista4 = new TArista("G", "C", 10);
        aristas.add(arista4);
        TArista arista5 = new TArista("F", "C", 100);
        aristas.add(arista5);
        TArista arista6 = new TArista("F", "D", 5);
        aristas.add(arista6);
        TArista arista7 = new TArista("A", "E", 90);
        aristas.add(arista7);
        TArista arista9 = new TArista("G", "F", 10);
        aristas.add(arista9);
        TArista arista2 = new TArista("B", "C", 90);
        aristas.add(arista2);
        TArista arista8 = new TArista("B", "D", 5);
        aristas.add(arista8);
        
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        System.out.println("Costo viejo: "+ grafo.getCosto());
               
                
        TGrafoNoDirigido nuevoGrafo = grafo.Kruskal();
        
        int expected = 35;
        int result = (int) nuevoGrafo.getCosto()/2;
        
           
        assertEquals(expected, result);
    }

    @Test
    public void testBea() {
        System.out.println("bea");
        Comparable etiquetaOrigen = "A";
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
        
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        Collection<TVertice> expResult = new LinkedList<>();
        Map<Comparable, TVertice> map = grafo.getVertices();
        expResult.add(map.get("A"));
        expResult.add(map.get("B"));
        expResult.add(map.get("C"));
        expResult.add(map.get("D"));
        expResult.add(map.get("E"));
        expResult.add(map.get("F"));
        expResult.add(map.get("G"));
        
        
        Collection<TVertice> result = grafo.bea(etiquetaOrigen);
        
        assertEquals(expResult, result);
    }

    @Test
    public void testPuntosArticulacion() {
        System.out.println("puntosArticulacion");
        LinkedList<TVertice> nuevaListaV = new LinkedList();
        LinkedList<TArista> nuevaListaA = new LinkedList();
        
        TVertice v1 = new TVertice("A");
        nuevaListaV.add(v1);
        TVertice v2 = new TVertice("B");
        nuevaListaV.add(v2);
        TVertice v3 = new TVertice("C");
        nuevaListaV.add(v3);
        TVertice v4 = new TVertice("D");
        nuevaListaV.add(v4);
        TVertice v5 = new TVertice("E");
        nuevaListaV.add(v5);
        TVertice v6 = new TVertice("F");
        nuevaListaV.add(v6);

        
        TArista ar1 = new TArista("A", "B", 1);
        TArista ar2 = new TArista("A", "E", 1);
        TArista ar3 = new TArista("B", "D", 1);
        TArista ar4 = new TArista("B", "C", 1);
        TArista ar5 = new TArista("F", "E", 1);
        TArista ar6 = new TArista("F", "B", 1);
        TArista ar7 = new TArista("F", "D", 1);
        TArista ar8 = new TArista("C", "D", 1);

        
        
        nuevaListaA.add(ar1);
        nuevaListaA.add(ar2);
        nuevaListaA.add(ar3);
        nuevaListaA.add(ar4);
        nuevaListaA.add(ar5);
        nuevaListaA.add(ar6);
        nuevaListaA.add(ar7);
        nuevaListaA.add(ar8);
//        nuevaListaA.add(ar10);
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(nuevaListaV, nuevaListaA);
        
        if (grafo.puntosArticulacion("A").size()==0){
            System.out.println("No tiene puntos");
            
        }else{
            System.out.println(" tiene puntos");
        }
    }

    @Test
    public void testEsConexo() {
        System.out.println("esConexo");
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
        
        TArista arista1 = new TArista("A", "B", 400);
        aristas.add(arista1);
        TArista arista3 = new TArista("B", "E", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("A", "E", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("E", "C", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("B", "D", 90);
        aristas.add(arista6);
        TArista arista7 = new TArista("C", "F", 90);
        aristas.add(arista7);
        TArista arista8 = new TArista("C", "G", 10);
        aristas.add(arista8);

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        boolean expResult = true;
        boolean result = grafo.esConexo();
        assertEquals(expResult, result);
    }

    @Test
    public void testContieneCiclos() {
        System.out.println("contieneCiclos");
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
        
        TArista arista1 = new TArista("A", "B", 400);
        aristas.add(arista1);
        TArista arista3 = new TArista("B", "E", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("A", "E", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("E", "C", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("B", "D", 90);
        aristas.add(arista6);
        TArista arista7 = new TArista("C", "F", 90);
        aristas.add(arista7);
        TArista arista8 = new TArista("C", "G", 10);
        aristas.add(arista8);
        TArista arista9 = new TArista("C", "A", 10);
        aristas.add(arista9);

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        boolean expResult = true;
        boolean result = grafo.contieneCiclos();
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerVerticesANivel() {
        System.out.println("obtenerVerticesANivel");
        
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
        TVertice vertice8 = new TVertice("H");
        vertices.add(vertice8);
        TVertice vertice9 = new TVertice("I");
        vertices.add(vertice9);
        

        LinkedList<TArista> aristas = new LinkedList<TArista>();
        
        TArista arista1 = new TArista("A", "B", 10);
        aristas.add(arista1);
        TArista arista3 = new TArista("A", "C", 30);
        aristas.add(arista3);
        TArista arista4 = new TArista("A", "D", 10);
        aristas.add(arista4);
        TArista arista5 = new TArista("A", "E", 100);
        aristas.add(arista5);
        TArista arista6 = new TArista("C", "F", 5);
        aristas.add(arista6);
        TArista arista7 = new TArista("C", "G", 90);
        aristas.add(arista7);
        TArista arista9 = new TArista("D", "H", 10);
        aristas.add(arista9);
        TArista arista2 = new TArista("D", "I", 90);
        aristas.add(arista2);
        
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        
        TVertice origen = grafo.getVertices().get("A");
        int nivel = 1;
        
        boolean expResult = true;
        LinkedList<TVertice> lista = grafo.obtenerVerticesANivel(origen, nivel);
        
        for (TVertice a : lista){
            System.out.println(a.getEtiqueta());
        }
        boolean result = false;
        
        if (lista.get(0).getEtiqueta().compareTo("B") == 0 && lista.get(1).getEtiqueta().compareTo("C") == 0){
            result = true;
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerNivelDeVertice() {
        System.out.println("obtenerNivelDeVertice");
        
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
        

        LinkedList<TArista> aristas = new LinkedList<TArista>();
        
        TArista arista1 = new TArista("A", "B", 400);
        aristas.add(arista1);
        TArista arista3 = new TArista("B", "E", 200);
        aristas.add(arista3);
        TArista arista4 = new TArista("A", "C", 170);
        aristas.add(arista4);
        TArista arista5 = new TArista("D", "C", 90);
        aristas.add(arista5);
        TArista arista6 = new TArista("B", "E", 90);
        aristas.add(arista6);
        
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        TVertice origen = vertice1;
        TVertice destino = vertice5;
        int expResult = 2;
        int result = grafo.obtenerNivelDeVertice(origen, destino);
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerTodosLosCaminos() {
        
        System.out.println("obtenerTodosLosCaminos");
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
        
        TArista arista1 = new TArista("A", "C", 10);
        aristas.add(arista1);
        TArista arista3 = new TArista("C", "E", 30);
        aristas.add(arista3);
        TArista arista4 = new TArista("G", "C", 10);
        aristas.add(arista4);
        TArista arista5 = new TArista("F", "C", 100);
        aristas.add(arista5);
        TArista arista6 = new TArista("F", "D", 5);
        aristas.add(arista6);
        TArista arista7 = new TArista("A", "E", 90);
        aristas.add(arista7);
        TArista arista9 = new TArista("G", "F", 10);
        aristas.add(arista9);
        TArista arista2 = new TArista("B", "C", 90);
        aristas.add(arista2);
        TArista arista8 = new TArista("B", "D", 5);
        aristas.add(arista8);
        
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        Comparable etiquetaOrigen = "A";
        Comparable etiquetaDestino = "G";
        TCaminos caminos = grafo.obtenerTodosLosCaminos(etiquetaOrigen, etiquetaDestino);
        System.out.println("Hay " + caminos.cantidadCaminos());
        for (TCamino camino : caminos.getCaminos()) {
            System.out.println("A imprimir camino");
            System.out.print(etiquetaOrigen + " ");
            for (Comparable claveV : camino.getOtrosVertices()) {
                System.out.print(claveV.toString() + " ");
            }
            System.out.print(etiquetaDestino + " ");
            System.out.println("");
        }
        
        assertEquals(3, caminos.cantidadCaminos());
    }

    @Test
    public void testBuscarCamino() {
        System.out.println("buscarCamino");
        Comparable vOrigen = "A";
        Comparable vDestino = "G";
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
        
        TArista arista1 = new TArista("A", "C", 10);
        aristas.add(arista1);
        TArista arista3 = new TArista("C", "E", 30);
        aristas.add(arista3);
        TArista arista4 = new TArista("G", "C", 10);
        aristas.add(arista4);
        TArista arista5 = new TArista("F", "C", 100);
        aristas.add(arista5);
        TArista arista6 = new TArista("F", "D", 5);
        aristas.add(arista6);
        TArista arista7 = new TArista("A", "E", 90);
        aristas.add(arista7);
        TArista arista9 = new TArista("G", "F", 10);
        aristas.add(arista9);
        TArista arista2 = new TArista("B", "C", 90);
        aristas.add(arista2);
        TArista arista8 = new TArista("B", "D", 5);
        aristas.add(arista8);
        
        
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        TCamino camino = grafo.buscarCamino(vOrigen, vDestino);
        System.out.println(camino.imprimirEtiquetas());
        
        
        Double result = camino.getCostoTotal();
        Double expected = 20.0;
        assertEquals(expected.intValue(), result.intValue());
    }
    
    @Test
    public void TestListarHastaNivel(){
            System.out.println("listarHastaNivel");
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
        TVertice vertice8 = new TVertice("H");
        vertices.add(vertice8);
        TVertice vertice9 = new TVertice("I");
        vertices.add(vertice9);
        

        LinkedList<TArista> aristas = new LinkedList<TArista>();
        
        TArista arista1 = new TArista("A", "B", 10);
        aristas.add(arista1);
        TArista arista3 = new TArista("A", "C", 30);
        aristas.add(arista3);
        TArista arista4 = new TArista("A", "D", 10);
        aristas.add(arista4);
        TArista arista5 = new TArista("A", "E", 100);
        aristas.add(arista5);
        TArista arista6 = new TArista("C", "F", 5);
        aristas.add(arista6);
        TArista arista7 = new TArista("C", "G", 90);
        aristas.add(arista7);
        TArista arista9 = new TArista("D", "H", 10);
        aristas.add(arista9);
        TArista arista2 = new TArista("D", "I", 90);
        aristas.add(arista2);
        
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        grafo.listarHastaNivel(2, grafo.getVertices().get("A"));
    }   
}
