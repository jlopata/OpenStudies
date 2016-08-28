package pl.jlopata.cd.data.deck;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jlopata.cd.data.card.Card;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeckDto implements Serializable{

	private static final long serialVersionUID = -4884892047716024883L;
	
	private Long id;
	private String name;
	private String owner;
	
}
