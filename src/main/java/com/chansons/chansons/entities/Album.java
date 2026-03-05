package com.chansons.chansons.entities;



import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idalb;
	private String nomalb;
	private String descriptionalb;
	
	@JsonIgnore
	@OneToMany(mappedBy = "album")
	private List<Chanson> chansons;
	public Album() {}
	public Album(String nomalb, String descriptionalb) {
		this.nomalb = nomalb;
		this.descriptionalb = descriptionalb;
	}


    public Long getIdalb() {
        return idalb;
    }

    public void setIdalb(Long idalb) {
        this.idalb = idalb;
    }

    public String getNomAlb() {
        return nomalb;
    }

    public String getDescriptionAlb() {
        return descriptionalb;
    }
	public void setNomAlb(String nomalb) {
		this.nomalb = nomalb;
	}

	public void setDescriptionAlb(String descriptionalb) {
		this.descriptionalb = descriptionalb;
	}

}

