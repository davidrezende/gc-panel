package br.com.gc.api.service;

import br.com.gc.api.model.*;
import br.com.gc.api.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CharacterService {
    public final CharacterRepository characterRepository;

    public Optional<ArrayList<Characters>> getCharacters(Integer loginUID) throws Exception {
        log.info("Searching characters for this loginID:: " + loginUID );
        return characterRepository.findByLoginUID(loginUID);
    }

    public Optional<Characters> getCharacter(Integer loginUID, Integer charType) throws Exception {
        log.info("Find character by loginID:: " + loginUID + " ; CharType::"+ charType );
        return characterRepository.findByLoginUIDAndCharType(loginUID, charType);
    }

//    @Modifying(clearAutomatically = true)
    public Characters updateCharacter(Characters character) throws Exception {
        log.info("Updating character by loginID:: " + character.getLoginUID() + " ; CharType::"+ character.getCharType() );
        return characterRepository.save(character);
    }

}
