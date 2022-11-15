package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
@Service //bu sınıf business nesnesidir.
public class LanguageManager implements LanguageService {
	LanguageRepository languageRepository;
		
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}


	@Override
	public List<Language> getAll() {
		
		return languageRepository.getAll();
	}

	@Override
	public void add(Language language) throws Exception {
		if(language.getLanguageName().isEmpty())
			throw new Exception("Dil ismi boş geçilemez...");
		else if(repeatController(language.getLanguageName())) {
			throw new Exception("Dil ismi tekrar edemez...");
		}
		else {languageRepository.add(language);}
		
		
		
	}
	private boolean repeatController(String name){
		for(Language language:languageRepository.getAll()) {
			if(language.getLanguageName().equals(name)) {
				return true;
			}
			
		}
		return false;
		
	}


	@Override
	public void delete(Language language) {
		languageRepository.delete(language);
		
	}


	@Override
	public void update(Language language, int id) {
		languageRepository.update(language, id);
		
	}


	@Override
	public Language getById(int id) {
		return languageRepository.getById(id);
	}


	




}
