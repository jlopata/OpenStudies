package pl.jlopata.cd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import pl.jlopata.cd.data.Subject.Subject;
import pl.jlopata.cd.data.Subject.SubjectDto;
import pl.jlopata.cd.data.Subject.SubjectRepository;
import pl.jlopata.cd.data.card.Card;
import pl.jlopata.cd.data.card.CardDto;
import pl.jlopata.cd.data.card.CardRepository;
import pl.jlopata.cd.data.deck.Deck;
import pl.jlopata.cd.data.deck.DeckDto;
import pl.jlopata.cd.data.deck.DeckRepository;
import pl.jlopata.cd.utils.ExceptionsHandler.Exceptions.ElementDoesNotExist;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private DeckRepository deckRepository;

	private Logger logger = LoggerFactory.getLogger(DataService.class);

	public List<SubjectDto> getAllSubjects() {
		List<Subject> subjects = subjectRepository.findAll();
		List<SubjectDto> subjectDtos = subjects.stream().map(Subject::asDto).collect(Collectors.toList());

		logger.info("getMySubjects called");

		return subjectDtos;
	}

	public SubjectDto getSubjectById(Long id) throws ElementDoesNotExist {
		try {
			SubjectDto subjectDto = subjectRepository.findOne(id).asDto();
			logger.info("getSubjectById with id: {}", id);
			return subjectDto;
		} catch (NullPointerException e) {
			throw new ElementDoesNotExist("Element with id " + id + " doesn't exist!");
		}
	}

	public SubjectDto createOrUpdateSubject(SubjectDto subjectDto) {
		Subject subject = subjectRepository.save(Subject.builder().id(subjectDto.getId()).name(subjectDto.getName())
				.description(subjectDto.getDescription()).build());
		logger.info("createOrUpdateSubject with id: {}", subject.getId());
		return subject.asDto();
	}

	public void deleteSubjectById(Long id) throws ElementDoesNotExist {
		try {
			subjectRepository.delete(id);
			logger.info("deleteSubjectById with id: {}", id);
		} catch (EmptyResultDataAccessException e) {
			throw new ElementDoesNotExist("Element with id " + id + " doesn't exist!");
		}
	}

	public CardDto createOrUpdateCard(CardDto dto) {
		Card card = cardRepository.save(Card.builder().name(dto.getName()).cost(dto.getCost()).id(dto.getId())
				.strength(dto.getStrength()).hitpoints(dto.getHitpoints()).type(dto.getType()).build());
		return card.asDto();
	}

	public DeckDto createOrUpdateDeck(DeckDto dto) {
		Deck deck = deckRepository.save(
				Deck.builder().cards(dto.getCards()).id(dto.getId()).name(dto.getName()).owner(dto.getOwner()).build());
		return deck.asDto();
	}

}
