package com.openclassrooms.escalade.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.escalade.dao.GrimpeurDao;
import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Role;
import com.openclassrooms.escalade.utils.Encrypter;
import com.openclassrooms.escalade.utils.GmailSender;
import com.openclassrooms.escalade.utils.Tools;

@Service
public class GrimpeurServiceImpl implements GrimpeurService {

	@Autowired
	private GrimpeurDao grimpeurDao;

	@Override
	@Transactional
	public Grimpeur findById(int grimpeurId) {
		return grimpeurDao.findById(grimpeurId);
	}

	@Override
	@Transactional
	public List<Grimpeur> findAll() {
		List<Grimpeur> grimpeurs = grimpeurDao.findAll();
		return grimpeurs;
	}
	
	@Override
	@Transactional
	public Grimpeur findByIdEmailPassword(String email, String password) throws NotFoundException, NoSuchAlgorithmException {
		
		Grimpeur utilisateur = grimpeurDao.findByIdEmailPassword(email, Tools.md5Hash(password)); 
		
		if(utilisateur == null) {
			throw new NotFoundException();
		}
		
		return utilisateur;
		
	}
	
	@Override
	@Transactional
	public Grimpeur findByNameEmail(String name, String email) throws NotFoundException {
		
		Grimpeur utilisateur;
		try {
		
			utilisateur = grimpeurDao.findByNameEmail(name, email);
		
		} catch (EmptyResultDataAccessException e1) {
			throw new NotFoundException();
		}
		
		
		return utilisateur;
		
	}
	
	@Override
	@Transactional
	public Grimpeur findByDataNameEmail(String data) throws NotFoundException {
		
		Grimpeur utilisateur;
		
		// Décrypt
		
		String dataDecrypted =   Encrypter.decryptBF(data);
		String name = null;
		String email = null;
		
		String paramsValuePair[] = dataDecrypted.split("&");
		
		for (int i=0;i<paramsValuePair.length;i++) {
			
			String param[] = paramsValuePair[i].split("=");
			
			//Nom
			if(param[0].equals("NOM")) if(param.length ==2) name= param[1]; else name= "";
			
			//Email
			if(param[0].equals("EMAIL")) if(param.length ==2) email= param[1]; else email= "";
		}
		
		
		
		try {
		
			utilisateur = grimpeurDao.findByNameEmail(name, email);
		
		} catch (EmptyResultDataAccessException e1) {
			throw new NotFoundException();
		}
		
		
		return utilisateur;
		
	}
	
	@Override
	@Transactional
	public void sendEmailInitPassword(Grimpeur grimpeur) throws MessagingException {

		GmailSender sender = new GmailSender();
		StringBuilder sb = new StringBuilder();
		sb.append("email=").append(grimpeur.getEmail()).append("&nom=").append(grimpeur.getNom());
		sender.setSender("escalade.p3@gmail.com", "Escalade2018");
		sender.addRecipient(grimpeur.getEmail());
		sender.setSubject("Escalade : Initialisation du mot de passe");
		sender.setBody("Pour initialiser votre mot de passe, cliquez sur le lien suivant : http://localhost:8080/escalade/grimpeur_init_password.action?data=" + Encrypter.encryptBF(sb.toString().toUpperCase()));
		//sender.addAttachment("TestFile.txt");
		sender.send();
	}
	
	@Override
	@Transactional
	public int initPassword(Grimpeur grimpeur) throws NoSuchAlgorithmException {
		
		// Cryptage du mot de passe
		// Hashage du mot de passe
		grimpeur.setMotpasse(Tools.md5Hash(grimpeur.getMotpasse()));
		return grimpeurDao.initPassword(grimpeur);
	}
	
	@Override
	@Transactional
	public int create(Grimpeur grimpeur) throws NoSuchAlgorithmException {
		
		Grimpeur grimpeurTmp;
		try {
			// Tester si le grimpeur existe déja
			grimpeurTmp = grimpeurDao.findByNameEmail(grimpeur.getNom(), grimpeur.getEmail()); 
		} catch (EmptyResultDataAccessException e1) {
			// Si le grimpeur n'existe pas
			grimpeurTmp = new Grimpeur();
			
			//Le role par défaut
			if(grimpeur.getRole() != Role.ADMIN) {
				grimpeur.setRole(Role.USER);
			}
			
			// Hashage du mot de passe
			grimpeur.setMotpasse(Tools.md5Hash(grimpeur.getMotpasse()));
			grimpeurTmp.setId(grimpeurDao.create(grimpeur));
		}
		
		// Mettre à jour le topo par son id
		grimpeur.setId(grimpeurTmp.getId());
		
		return grimpeurTmp.getId();
		
	}

	@Override
	@Transactional
	public int update(Grimpeur grimpeur) throws NoSuchAlgorithmException {
		// Hashage du mot de passe
		grimpeur.setMotpasse(Tools.md5Hash(grimpeur.getMotpasse()));
		return grimpeurDao.update(grimpeur);
	}

	@Override
	@Transactional
	public int delete(int grimpeurId) {
		return grimpeurDao.delete(grimpeurId);
	}

}
