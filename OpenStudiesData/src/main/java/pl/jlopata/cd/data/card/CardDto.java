package pl.jlopata.cd.data.card;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto implements Serializable{

	private static final long serialVersionUID = 4725174766577354318L;
	
	private Long id;
	private String name;
	private int cost;
	private int strength;
	private int hitpoints;
	private Type type;
	
}
