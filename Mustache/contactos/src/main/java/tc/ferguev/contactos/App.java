package tc.ferguev.contactos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.apache.log4j.BasicConfigurator;

import tc.ferguev.contactos.model.Contacto;
import tc.ferguev.contactos.mustache.MustacheTemplateEngine;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BasicConfigurator.configure();
        port(8080);
        get("/contact", (request, response) -> {
            List<Contacto> contactos = Contacto.obtenerContactos();
            Map map = new HashMap<String,Object>();
            map.put("contactos", contactos);
            map.put("tieneContactos", contactos.size() > 0);
            return new ModelAndView(map,"contactos.mustache");
        }, new MustacheTemplateEngine());
    }

    public static String dataToJson(Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, data);
            return sw.toString();
        } catch (IOException e){
            throw new RuntimeException("IOException from a StringWriter?");
        }
    }
}
