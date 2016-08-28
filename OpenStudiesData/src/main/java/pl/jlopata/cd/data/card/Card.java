package pl.jlopata.cd.data.card;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.mapping.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private int cost;
	private int strength;
	private int hitpoints;
	private Type type;

	public CardDto asDto() {
		return CardDto.builder().id(id).name(name).cost(cost).strength(strength).hitpoints(hitpoints).type(type).build();
	}

}
