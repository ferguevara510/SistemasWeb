package tc.ferguev.contactos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;

import spark.ModelAndView;
import org.apache.log4j.BasicConfigurator;

import tc.ferguev.contactos.model.Contacto;
import tc.ferguev.contactos.mustache.MustacheTemplateEngine;

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
}