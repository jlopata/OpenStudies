package pl.jlopata.cd.data.deck;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.mapping.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jlopata.cd.data.card.Card;
import pl.jlopata.cd.data.card.Type;
import pl.jlopata.cd.data.card.Card.CardBuilder;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Deck {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String owner;
	private List cards;
	
	public DeckDto asDto() {
		return DeckDto.builder().id(id).name(name).owner(owner).cards(cards.).build();
	}
	
}
