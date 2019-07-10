public class Bulletin {
    private String[] wantedCriminals;

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
        this.wantedCriminals = names;
    }

    private boolean containsMoreThanOneCriminal(String updates) {
        return updates.contains(",");
    }

    private boolean containsOnlyOneCriminal(String updates) {
        return updates.contains(":");
    }
}
