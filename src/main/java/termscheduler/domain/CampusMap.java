package termscheduler.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class CampusMap {

    private final Map<String, Building> buildings = new HashMap<>();

    public CampusMap() {
        buildings.put("63", new Building("63", "Building 63", 137, 243));
        buildings.put("26", new Building("26", "Building 26", 65, 269));
        buildings.put("75", new Building("75", "Building 75", 107, 302));
        buildings.put("1",  new Building("1",  "Building 1", 88, 337));
        buildings.put("55", new Building("55", "Building 55", 55, 355));
        buildings.put("2",  new Building("2",  "Building 2", 121, 312));
        buildings.put("3",  new Building("3",  "Building 3", 134, 329));
        buildings.put("16", new Building("16", "Building 16", 168, 339));
        buildings.put("4",  new Building("4",  "Building 4", 192, 348));
        buildings.put("15", new Building("15", "Building 15", 134, 425));
        buildings.put("5",  new Building("5",  "Building 5", 208, 363));
        buildings.put("6",  new Building("6",  "Building 6", 243, 392));
        buildings.put("7",  new Building("7",  "Building 7", 239, 419));
        buildings.put("14", new Building("14", "Building 14", 203, 471));
        buildings.put("17", new Building("17", "Building 17", 253, 460));
        buildings.put("8",  new Building("8",  "Building 8", 287, 453));
        buildings.put("80", new Building("80", "Building 80", 281, 389));
        buildings.put("68", new Building("68", "Building 68", 265, 331));
        buildings.put("79", new Building("79", "Building 79", 284, 359));
        buildings.put("59", new Building("59", "Building 59", 306, 380));
        buildings.put("40", new Building("40", "Building 40", 309, 277));
        buildings.put("39", new Building("39", "Building 39", 347, 296));
        buildings.put("9",  new Building("9",  "Building 9", 299, 475));
        buildings.put("19", new Building("19", "Building 19", 239, 522));
        buildings.put("20", new Building("20", "Building 20", 267, 562));
        buildings.put("10", new Building("10", "Building 10", 301, 517));
        buildings.put("11", new Building("11", "Building 11", 350, 579));
        buildings.put("24", new Building("24", "Building 24", 395, 573));
        buildings.put("22", new Building("22", "Building 22", 399, 533));
        buildings.put("21", new Building("21", "Building 21", 333, 502));
        buildings.put("76", new Building("76", "Building 76", 442, 528));
        buildings.put("78", new Building("78", "Building 78", 519, 513));
        buildings.put("27", new Building("27", "Building 27", 564, 556));
        buildings.put("42", new Building("42", "Building 42", 503, 260));
        buildings.put("66", new Building("66", "Building 66", 450, 63));
        buildings.put("57", new Building("57", "Building 57", 539, 55));
        buildings.put("58", new Building("58", "Building 58", 522, 27));
    }

    /**
     * Returns the Building object given its code .
     */
    public Building getBuildingByCode(String code) {
        return buildings.get(code);
    }

    /**
     * Returns all known buildings.
     */
    public Collection<Building> getAllBuildings() {
        return buildings.values();
    }
}
