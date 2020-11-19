package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class App {

    public static ArrayList<Contacto> Agenda = new ArrayList<Contacto>();


    public static void main(String[] args) {

        Leer_fichero();
        for (int i = 0; i < Agenda.size(); i++) {

            System.out.println(Agenda.get(i).getNombre());
            System.out.println(Agenda.get(i).getCoche());
            System.out.println(Agenda.get(i).getEdad());


        }
    }

    public static void Leer_fichero() {

        JSONParser jsonParser = new JSONParser();

        String Nombre_aux;
        String Coche_aux;
        long Edad_aux;


        try {


            Object obj = jsonParser.parse(new FileReader("Agenda.json"));

            JSONObject jsonObject = (JSONObject) obj;

            //seleccionamos el objeto que queremos (En nuestro caso solo es 1 dado que solo tenemos 1 agenda)
            JSONArray Agenda_JSON = (JSONArray) jsonObject.get("Agenda");


            // debemos hacer esto si tenemos en el JSON un array que tiene diferentes valores dentro
            Iterator<JSONObject> iterator = Agenda_JSON.iterator();

            while (iterator.hasNext()) {
                Contacto Contacto_aux = new Contacto();
               JSONObject Objeto_aux= iterator.next();
                Contacto_aux.setNombre((String) Objeto_aux.get("name"));
                Contacto_aux.setCoche((String) Objeto_aux.get("cars"));
                Contacto_aux.setEdad((long) Objeto_aux.get("age"));
                Agenda.add(Contacto_aux);
            }



        } catch (Exception e) {

            e.printStackTrace();

        }

        //Read JSON file
    }
    public static void Escribir_JSON(){

        JSONObject obj1 = new JSONObject();

        JSONArray arraycoches = new JSONArray();
        JSONObject obj2 = new JSONObject();
        JSONObject obj3 = new JSONObject();
        JSONObject obj4 = new JSONObject();

        obj2.put("nombre","Fer");
        obj2.put("edad", 21);
        obj2.put("coche", "mercedes refachero");
        arraycoches.add(obj2);
        obj1.put("amigos", arraycoches);

        obj3.put("nombre","Edu");
        obj3.put("edad", 20);
        obj3.put("coche", "none");
        arraycoches.add(obj3);

        obj4.put("nombre","javi");
        obj4.put("edad", 20);
        obj4.put("coche", "azul refachero");
        arraycoches.add(obj4);
        obj1.put("amigos", arraycoches);

        // Write file
        try(FileWriter file = new FileWriter("amigos.json")){
            file.write(obj1.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }



    }


}
