package org.example;




import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;



import com.sun.deploy.security.ruleset.RuleSetParser;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{

   public static ArrayList<Contacto> Agenda = new ArrayList<Contacto>();


    public static void main( String[] args ){

        Leer_fichero();

    }

    public static void Leer_fichero() {

        JSONParser jsonParser = new JSONParser();

        try {


            Object obj = jsonParser.parse(new FileReader(".json"));

        }catch (Exception e){

            e.printStackTrace();

        }

            //Read JSON file
    }


}
