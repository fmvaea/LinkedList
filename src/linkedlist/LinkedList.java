package linkedlist;
public class LinkedList {
    public static void main(String[] args) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();

          
            lista.append("Mexico");
            lista.append("peru");
            lista.append("japon");
            System.out.println("tamanio: " + lista.size());   
            
            lista.insert("alemania", 1);                          
           
            System.out.println(lista);
            
            System.out.println("get: " + lista.get(1)); 
 
            System.out.println("remove(1): " + lista.remove(1));
            System.out.println(lista);
            
                     for (String dato : lista) {
                System.out.println(dato);                
            }
 
            lista.clear();
            System.out.println("clear lista: " + lista.size());   
            System.out.println(lista);
           }
}

