package jscode.jscodeproject.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Bulletin {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bulletin_id")
    private Long id;

    private String title;
    private String text;


    public void update(String title, String text) {
        this.title = title;
        this.text = text;
    }

}
