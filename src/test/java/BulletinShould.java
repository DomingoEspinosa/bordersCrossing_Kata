import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.Is.is;

public class BulletinShould {

    private String[] wantedCriminals;

    @Test
    public void update_currently_wanted_criminal() {
        Bulletin bulletin = new Bulletin("Wanted by the State: Hubert Popovic");

        wantedCriminals = bulletin.getWantedCriminals();

        assertThat(wantedCriminals[0], is("Hubert Popovic"));
    }

    @Test
    public void update_currently_wanted_criminals() {
        Bulletin bulletin = new Bulletin("Wanted by the State: Hubert Popovic, Igor Fried");

        ArrayList<String> wantedCriminals = new ArrayList();
        wantedCriminals.add("Hubert Popovic");
        wantedCriminals.add("Igor Fried");

        assertThat(bulletin.getWantedCriminals().length, is(wantedCriminals.size()));
    }

    @Test
    public void update_required_vaccinations() {
        Bulletin bulletin = new Bulletin("Citizens of Antegria, Republia, Obristan require polio vaccination");

        Map<String, ArrayList<String>> countryToNecessaryVaccination = new HashMap<String, ArrayList<String>>();
        ArrayList<String> vaccinations = new ArrayList<String>();
        vaccinations.add("polio");
        countryToNecessaryVaccination.put("Antegria", vaccinations);
        countryToNecessaryVaccination.put("Republia", vaccinations);
        countryToNecessaryVaccination.put("Obristan", vaccinations);

        assertThat(countryToNecessaryVaccination.get("Antegria").get(0), is(bulletin.getRequiredVaccinationsFor("Antegria").get(0)));

    }

    @Test
    public void update_required_vaccinations_for_rubeola() {
        Bulletin bulletin = new Bulletin("Citizens of Antegria, Republia, Obristan require Rubeola vaccination");

        Map<String, ArrayList<String>> countryToNecessaryVaccination = new HashMap<String, ArrayList<String>>();
        ArrayList<String> vaccinations = new ArrayList<String>();
        vaccinations.add("Rubeola");
        countryToNecessaryVaccination.put("Antegria", vaccinations);
        countryToNecessaryVaccination.put("Republia", vaccinations);
        countryToNecessaryVaccination.put("Obristan", vaccinations);

        assertThat(countryToNecessaryVaccination.get("Antegria").get(0), is(bulletin.getRequiredVaccinationsFor("Antegria").get(0)));
    }

}
