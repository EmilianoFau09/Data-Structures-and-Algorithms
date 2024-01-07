package org.example;

import java.util.Iterator;
import java.util.LinkedList;

class HashMap<T> {
    public int size;
    public LinkedList<TNodo>[] map;

    @SuppressWarnings("unchecked")
    public HashMap(int size) {
        this.size = size;
        this.map = new LinkedList[size];
    }

    private int getHash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public int insert(String key, String value) {
        int iterations = 0;
        int hash = getHash(key);
        TNodo entry = new TNodo(key, value);

        if (map[hash] == null) {
            map[hash] = new LinkedList<>();
            map[hash].add(entry);
            return iterations + 1;
        } else {
            for (TNodo e : map[hash]) {
                iterations++;
                if (e.getKey().equals(key)) {
                    e.setValue(value);
                    return iterations;
                }
            }
            map[hash].add(entry);
            return iterations;
        }
    }
    public int insert(TNodo nodo) {
        int iterations = 0;
        int hash = getHash(nodo.getKey());

        if (map[hash] == null) {
            map[hash] = new LinkedList<>();
            map[hash].add(nodo);
            return iterations + 1;
        } else {
            for (TNodo e : map[hash]) {
                iterations++;
                if (e.getKey().equals(nodo.getKey())) {
                    e.setValue(nodo.getValue());
                    return iterations;
                }
            }
            map[hash].add(nodo);
            return iterations;
        }
    }

    public T search(String key) {
        int hash = getHash(key);

        if (map[hash] != null) {
            for (TNodo entry : map[hash]) {
                if (entry.getKey().equals(key)) {
                    return (T) entry.getValue();
                }
            }
        }
        return null;
    }

    public int searchIterations(String key) {
        int iterations = 0;
        int hash = getHash(key);
        if (map[hash] != null) {
            for (TNodo entry : map[hash]) {
                iterations++;
                if (entry.getKey().equals(key)) {
                    return iterations;
                }
            }
        }
        return -1;
    }

    public void delete(String key) {
        int hash = getHash(key);

        if (map[hash] != null) {
            for (TNodo entry : map[hash]) {
                if (entry.getKey().equals(key)) {
                    map[hash].remove(entry);
                    return;
                }
            }
        }
    }

    public void printAll() {
        for (LinkedList<TNodo> entries : map) {
            if (entries != null) {
                for (TNodo entry : entries) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }
    }

    private void resizeMap() {
        int newSize = size * 2;  // Nuevo tamaño del mapa

        // Crear una nueva tabla hash con el nuevo tamaño
        LinkedList<TNodo>[] newMap = new LinkedList[newSize];

        // Reinsertar todos los elementos existentes en la nueva tabla hash
        for (LinkedList<TNodo> entries : map) {
            if (entries != null) {
                for (TNodo entry : entries) {
                    int newHash = getHash(entry.getKey());
                    if (newMap[newHash] == null) {
                        newMap[newHash] = new LinkedList<>();
                    }
                    newMap[newHash].add(entry);
                }
            }
        }

        // Actualizar el tamaño y la referencia a la nueva tabla hash
        size = newSize;
        map = newMap;
    }

    public void removeNullValues() {
        for (LinkedList<TNodo> entries : map) {
            if (entries != null) {
                Iterator<TNodo> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    TNodo entry = iterator.next();
                    if (entry.getValue() == null) {
                        iterator.remove();
                    }
                }
            }
        }
    }

    public HashMap intercambiarClavesValores() throws Exception {
        HashMap result = new HashMap<>(size);
        for (LinkedList<TNodo> entries : map) {
            if (entries != null) {
                Iterator<TNodo> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    TNodo entry = iterator.next();
                    String key = entry.getKey();
                    String value = (String) entry.getValue();

                    if (result.search(value) != null) {
                        throw new Exception("Se encontró un valor duplicado en el mapa de entrada.");
                    }
                    result.insert(value, key);
                }
            }
        }
        return result;
    }
    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        for (LinkedList<TNodo> listaPorHash : map){
            if (listaPorHash != null){
                return false;
            }
        }
        return true;
    }
    public String claves(){
        StringBuilder sb = new StringBuilder();
        for (LinkedList<TNodo> listaPorHash : map){
            if (listaPorHash != null){
                for (TNodo nodo : listaPorHash){
                    if (nodo != null){
                        sb.append(nodo.getKey() + " - ");
                    }
                }
            }

        }
        return sb.toString();
    }
    public String valores(){
        StringBuilder sb = new StringBuilder();
        for (LinkedList<TNodo> listaPorHash : map){
            if (listaPorHash != null){
                for (TNodo nodo : listaPorHash){
                    if (nodo != null) {
                        sb.append(nodo.getValue().toString() + " - ");
                    }
                }
            }
        }
        return sb.toString();
    }
    public String elementos(){
        StringBuilder sb = new StringBuilder();
        for (LinkedList<TNodo> listaPorHash : map){
            if (listaPorHash != null) {
                for (TNodo nodo : listaPorHash) {
                    if (nodo != null) {
                        sb.append(nodo.getKey() + " " + nodo.getValue().toString() + " - ");
                    }
                }
            }
        }
        return sb.toString();
    }
}

