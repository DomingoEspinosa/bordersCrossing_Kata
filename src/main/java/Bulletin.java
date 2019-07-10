import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bulletin {
    private String[] wantedCriminals = new String[1];
    private Map<String, ArrayList<String>> requiredVaccinationsForCountries = new HashMap<String, ArrayList<String>>();
    private final String VACCINE_REGEX = "(.*require\\s)(.*)(\\s.*vaccination)";
    private final String COUNTRIES_REGEX = "(Citizens of\\s)(.*)(\\s.*require)";


    public Bulletin(String updates) {
        parseBulletin(updates);
    }

    public String[] getWantedCriminals() {
        return this.wantedCriminals;
    }

    private void parseBulletin(String updates) {
        parseCriminals(updates);
        parseVaccinations(updates);
    }

    private void parseCriminals(String updates) {
        if (containsMoreThanOneCriminal(updates)) {
            wantedCriminals = updates.split(",");
        }
        if (containsOnlyOneCriminal(updates)) {
            wantedCriminals[0] = updates.substring(updates.indexOf(':') + 1).trim();
        }
    }

    private void parseVaccinations(String updates) {
        if (containsVaccinationWord(updates)) {
            ArrayList<String> vaccinations = new ArrayList<String>();

            String vaccine = applyRegexOn(updates, VACCINE_REGEX );
            vaccinations.add(vaccine);

            String countries = applyRegexOn(updates, COUNTRIES_REGEX);
            String[] listCountries = countries.split(",");

            for (String country : listCountries) {
                requiredVaccinationsForCountries.put(country, vaccinations);
            }

        }
    }

    private String applyRegexOn(String updates, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(updates);
        String result = "";
        if (matcher.find()){
            result = matcher.group(2);
        }
        return result;
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
