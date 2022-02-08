public enum Location {
    DUNGEON("Dungeon"),
    TAVERN("Tavern"),
    TOWN("Town");

    private String name;

    private Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
