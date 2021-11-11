package pt.lucks.pco.tps.serie3.ex18;

import java.util.ArrayList;
import java.util.List;

public class GrandPrix {
    private String place;
    private List<Driver> drivers;

    public GrandPrix(String place, List<Driver> drivers) {
        this.place = place;
        this.drivers = drivers; // TODO copy?
    }

    public int howManyOfTeam(Team t) {
        int qtd = 0;
        for (Driver d : drivers) {
            if (d.team().equals(t))
                qtd++;
        }

        return qtd;
    }

    public Team hasMoreDrivers() {
        int max = 0;
        int team = 0;
        Team[] teams = Team.values();

        for (int i=0; i<teams.length; i++) {
            int qtd = this.howManyOfTeam(teams[i]);
            if (qtd > max) {
                max = qtd;
                team = i;
            }
        }

        return teams[team];
    }

    public Team driverTeam(String name) {
        for (Driver d : drivers) {
            if (d.name().equals(name))
                return d.team();
        }

        return null;
    }

//    List<Pair<Team, Integer>> BADhowManyEachTeam() {
//        List<Pair<Team, Integer>> quantidades = new ArrayList();
//
//        for (Team t : Team.values()) {
//            quantidades.add(
//                    new Pair(t, this.howManyOfTeam(t))
//            );
//        }
//
//        return quantidades;
//    }

    public List<Pair<Team, Integer>> howManyEachTeam() {
        int[] quantos = new int[Team.values().length];

        for (Driver d : drivers)
            quantos[d.team().ordinal()]++;

        List<Pair<Team, Integer>> result = new ArrayList();
        for (Team t : Team.values())
            result.add(new Pair(t, quantos[t.ordinal()]));

        return result;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Place: ");
        sb.append(this.place);
        sb.append("\nDrivers:");

        for (Driver d : drivers) {
            sb.append("Name: ");
            sb.append(d.name());
            sb.append("\tTeam: ");
            sb.append(d.team());
            sb.append("\n");
        }

        return sb.toString();
    }
}
