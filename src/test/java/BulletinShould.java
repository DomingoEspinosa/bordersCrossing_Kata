import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BulletinShould {
    @Test
    public void update_currently_wanted_criminal() {
        Bulletin bulletin = new Bulletin("Wanted by the State: Hubert Popovic");
        assertThat(bulletin.getWantedCriminals(), is("Hubert Popovic"));
    }


}
