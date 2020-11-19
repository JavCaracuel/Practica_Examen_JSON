package org.example;





import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class App 
{

   public static ArrayList<Contacto> Agenda = new ArrayList<Contacto>();


    public static void main( String[] args ){

        Leer_fichero();

    }

    public static void Leer_fichero() {

        JSONParser jsonParser = new JSONParser();

        try {


            Object obj = jsonParser.parse(new FileReader("Agenda.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray Agenda = (JSONArray) jsonObject.get("Agenda");


            for(int i=0;i<Agenda.size();i++){

                System.out.println(jsonObject);


            }

        }catch (Exception e){

            e.printStackTrace();

        }

            //Read JSON file
    }


}
