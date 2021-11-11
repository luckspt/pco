package pt.lucks.pco.tps.serie3.ex18;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TestGrandPrix {
    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<Driver>();
        drivers.add(new Driver("Verstappen",Team.RED_BULL));
        drivers.add(new Driver("Hamilton",Team.MERCEDES));
        drivers.add(new Driver("Norris",Team.MC_LAREN));
        drivers.add(new Driver("Bottas",Team.MERCEDES));
        drivers.add(new Driver("Leclerc",Team.FERRARI));

        System.out.println(drivers.get(1).toString());
        System.out.println();

        GrandPrix gp = new GrandPrix("Portugal", drivers);

        System.out.println(gp.toString());
        System.out.println("RedBull drivers: " +
                gp.howManyOfTeam(Team.RED_BULL));
        System.out.println("Team with more drivers: " +
                gp.hasMoreDrivers());
        System.out.println("Norris' team: " +
                gp.driverTeam("Norris"));
        Instant start = Instant.now();
        List<Pair<Team,Integer>> lista = gp.howManyEachTeam();
        Instant end = Instant.now();
        System.out.println("Tempo: " + Duration.between(start, end));
        System.out.println("Com BADhowManyEachTeam: " + lista.toString());

        start = Instant.now();
        lista = gp.howManyEachTeam();
        end = Instant.now();
        System.out.println("Tempo: " + Duration.between(start, end));
        System.out.println("Com howManyEachTeam: " + lista.toString());

    }
}

//	System.out.println(p.quantosPorTipo());
