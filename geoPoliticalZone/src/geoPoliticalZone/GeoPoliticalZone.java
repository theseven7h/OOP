package geoPoliticalZone;

public enum GeoPoliticalZone {
    NORTH_CENTRAL("Benue", "FCT", "Kogi", "Kwara", "Nassarawa", "Niger", "Plateau"),
    NORTH_EAST("Adamawa", "Bauchi", "Borno", "Gombe", "Taraba", "Yobe"),
    NORTH_WEST("Kaduna", "Katsina", "Kano", "Kebbi", "Sokoto", "Jigawa", "Zamfara"),
    SOUTH_EAST("Abia", "Anambra", "Ebonyi", "Enugu", "Imo"),
    SOUTH_SOUTH("Akwa-Ibom", "Bayelsa", "Cross-River", "Delta", "Edo", "Rivers"),
    SOUTH_WEST("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo")
    ;

    private String[] states;

    GeoPoliticalZone(String... states) {
        this.states = states;
    }

    public String[] getStates() {
        return states;
    }

    public void setStates(String[] states) {
        this.states = states;
    }

    public static String getZone(String userState) {
        for(GeoPoliticalZone zone : GeoPoliticalZone.values()) {
            for(String state : zone.getStates()) {
                if(state.equalsIgnoreCase(userState)) {
                    return zone.name();
                }
            }
        }
        return userState + " not found";
    }
}
