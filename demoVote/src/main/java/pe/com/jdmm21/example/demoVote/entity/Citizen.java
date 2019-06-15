package pe.com.jdmm21.example.demoVote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "citizens")
@Entity
public class Citizen {
	
	
	
	public Citizen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Citizen(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "citizen_name")
	private String name;
	
	@Column
	private boolean hasVoted;
	


	public boolean isHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
