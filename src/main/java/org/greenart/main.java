package org.greenart;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.greenart.entity.Member;
import org.greenart.entity.RoleType;
import org.greenart.entity.Team;

public class main {
    public static void main( String[] args ) {
        Member member1 = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");

        Team team1 = new Team("team1","팀1");

        member1.setTeam(team1);
        member2.setTeam(team1);

        Team findTeam1 = member1.getTeam();
        Team findTeam2 = member2.getTeam();

        System.out.println("findTeam1 = " + findTeam1);
        System.out.println("findTeam2 = " + findTeam2);
    }
}
