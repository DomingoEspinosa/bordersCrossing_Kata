public class Bulletin {
    private String[] wantedCriminals;

    public Bulletin(String updates) {
        parseBulletinCriminals(updates);
    }


    public String[] getWantedCriminals() {
        System.out.println(this.wantedCriminals);
        return this.wantedCriminals;
    }

    private void parseBulletinCriminals(String updates) {
        String[] names = new String[1];
        if (updates.contains(",")){
            names = updates.split(",");
        }
        if (updates.contains(":")){
            names[0] = updates.substring(updates.indexOf(":")+1).trim();
        }
        this.wantedCriminals = names;
    }
}
