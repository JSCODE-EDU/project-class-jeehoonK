package jscode.jscodeproject.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Bulletin {

    @Id @GeneratedValue
    @Column(name = "bulletin_id")
    private Long id;

    private String title;
    private String text;

    public void update(String title, String text) {
        this.title = title;
        this.text = text;
    }

}
