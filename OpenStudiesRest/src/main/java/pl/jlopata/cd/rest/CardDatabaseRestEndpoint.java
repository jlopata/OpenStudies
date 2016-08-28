package pl.jlopata.cd.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pl.jlopata.cd.data.Subject.SubjectDto;
import pl.jlopata.cd.data.card.CardDto;
import pl.jlopata.cd.data.deck.DeckDto;
import pl.jlopata.cd.service.DataService;
import pl.jlopata.cd.utils.ExceptionsHandler.Exceptions.ElementDoesNotExist;

import java.util.List;

@RestController
public class CardDatabaseRestEndpoint {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    public List<SubjectDto> getAllSubjects () {
        return dataService.getAllSubjects();
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    public SubjectDto getSubjectById (@PathVariable Long id) throws ElementDoesNotExist {
        return dataService.getSubjectById(id);
    }

    @RequestMapping(value = "/card", method = RequestMethod.PUT)
    public CardDto createOrUpdateCard(@RequestBody CardDto dto) {
        return dataService.createOrUpdateCard(dto);
    }
    
    @RequestMapping(value = "/deck", method = RequestMethod.PUT)
    public DeckDto createOrUpdateDeck(@RequestBody DeckDto dto) {
        return dataService.createOrUpdateDeck(dto);
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubjectById(@PathVariable Long id) throws ElementDoesNotExist {
        dataService.deleteSubjectById(id);
    }
}
