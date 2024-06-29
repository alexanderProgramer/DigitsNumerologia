package alexander.packages.com.entities;

import java.util.HashMap;
import java.util.Map;

public class Descriptions {

    private Map<Integer, String > mapDescriptions = new HashMap<>();

    public Descriptions()
    {
        mapDescriptions = settingDescriptionsMap();
    }

    private Map<Integer, String> settingDescriptionsMap() {
        Map<Integer, String> numerologyDescriptions = new HashMap<>();
        numerologyDescriptions.put(1, "Representa la unidad y el poder creativo.");
        numerologyDescriptions.put(2, "Simboliza la dualidad, la cooperación y la relación.");
        numerologyDescriptions.put(3, "Es la expresión creativa, la comunicación y la expansión.");
        numerologyDescriptions.put(4, "Representa la estabilidad, la estructura y la base sólida.");
        numerologyDescriptions.put(5, "Simboliza la libertad, la aventura y el cambio.");
        numerologyDescriptions.put(6, "Es el número de la armonía, la familia y la responsabilidad.");
        numerologyDescriptions.put(7, "Representa la espiritualidad, la intuición y el conocimiento profundo.");
        numerologyDescriptions.put(8, "Es el número de la abundancia, el poder y la autoridad.");
        numerologyDescriptions.put(9, "Simboliza la completitud, la compasión y la espiritualidad elevada.");
        return numerologyDescriptions;
    }

    public Map<Integer, String>getMap()
    {
        return this.mapDescriptions;
    }
    public String getValue(int key)
    {
        return  this.mapDescriptions.get(key);
    }

}
