import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
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

}
