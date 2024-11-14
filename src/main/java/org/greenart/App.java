package org.greenart;

import jakarta.persistence.*;
import org.greenart.entity.Member;
import org.greenart.entity.RoleType;
import org.greenart.entity.Team;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
//
//            Member member = new Member();
//            member.setId("01");
//            member.setUsername("abc");
//            member.setAge(10);
//            member.setEmail("abc@gmail.com");
//            member.setRoleType(RoleType.ADMIN);
//            em.persist(member);

            Team team1 = new Team("team1", "팀1");
            em.persist(team1);

            Member member1 =  new Member("member1", "회원1");
            Member member2 = new Member("member2", "회원2");
            member1.setTeam(team1);
            member2.setTeam(team1);
            team1.getMembers().add(member1);
            team1.getMembers().add(member2);

            em.persist(member1);
            em.persist(member2);

            em.flush();
            em.clear();

            Team findteam = em.find(Team.class, "team1");
            List<Member> members = findteam.getMembers();
            System.out.println(members);



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }


}
