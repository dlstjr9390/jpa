package org.greenart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Member {

    @Id
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team; // 팀의 참조 보관

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public void changeTeam(Team team) {
        if(this.team != null){
            this.team.getMembers().remove(this);
        }

        this.team = team;
        team.getMembers().add(this);
    }

}
