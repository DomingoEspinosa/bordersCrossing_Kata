import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bulletin {
    private String[] wantedCriminals;
    private Map<String, ArrayList<String>> requiredVaccinationsForCountries = new HashMap<String, ArrayList<String>>();

    public Bulletin(String updates) {
        parseBulletinCriminals(updates);
    }

    public String[] getWantedCriminals() {
        return this.wantedCriminals;
    }

    private void parseBulletinCriminals(String updates) {
        String[] names = new String[1];
        if (containsMoreThanOneCriminal(updates)) {
            names = updates.split(",");
        }
        if (containsOnlyOneCriminal(updates)) {
            names[0] = updates.substring(updates.indexOf(':') + 1).trim();
        }
        if (containsVaccinationWord(updates)){
            String vacination = updates.substring(updates.lastIndexOf("require") + 7, updates.indexOf("vaccination")).trim();
            ArrayList<String> vaccinations = new ArrayList<String>();
            vaccinations.add(vacination);

            String countries = updates.substring(updates.indexOf("of")+2, updates.indexOf("require")).trim();
            String[] listCountries = countries.split(",");

            for (String country: listCountries){
                requiredVaccinationsForCountries.put(country, vaccinations);
            }

        }
        this.wantedCriminals = names;
    }

    private boolean containsVaccinationWord(String updates) {
        return updates.contains("vaccination");
    }

    private boolean containsMoreThanOneCriminal(String updates) {
        return updates.contains(",");
    }

    private boolean containsOnlyOneCriminal(String updates) {
        return updates.contains(":");
    }

    public ArrayList<String> getRequiredVaccinationsFor(String country) {
        return requiredVaccinationsForCountries.get(country);
    }
}
