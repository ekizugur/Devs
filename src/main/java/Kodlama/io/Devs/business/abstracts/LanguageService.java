package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();
	Language getById(int id);
	void add(Language language) throws Exception;
	void update(Language language, int id);
	void delete(Language language);

}
