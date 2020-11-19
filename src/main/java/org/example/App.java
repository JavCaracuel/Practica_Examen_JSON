package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class App {

    public static ArrayList<Contacto> Agenda = new ArrayList<Contacto>();


    public static void main(String[] args) {

        Leer_fichero();

    }

    public static void Leer_fichero() {

        JSONParser jsonParser = new JSONParser();

        try {


            Object obj = jsonParser.parse(new FileReader("Agenda.json"));

            JSONObject jsonObject = (JSONObject) obj;

            //seleccionamos el objeto que queremos (En nuestro caso solo es 1 dado que solo tenemos 1 agenda)
            JSONArray Agenda_JSON = (JSONArray) jsonObject.get("Agenda");


            // debemos hacer esto si tenemos en el JSON un array que tiene diferentes valores dentro
            Iterator<JSONObject> iterator = Agenda_JSON.iterator();

            while (iterator.hasNext()) {
                Contacto Contacto_aux = new Contacto();
                Contacto_aux.setNombre((String) iterator.next().get("name"));
                Contacto_aux.setCoche((String) iterator.next().get("cars"));
                Contacto_aux.setEdad((long) iterator.next().get("age"));
                Agenda.add(Contacto_aux);
            }


        } catch (Exception e) {

            e.printStackTrace();

        }

        //Read JSON file
    }


}
