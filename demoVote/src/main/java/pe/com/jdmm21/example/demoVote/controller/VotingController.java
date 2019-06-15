package pe.com.jdmm21.example.demoVote.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.jdmm21.example.demoVote.entity.Candidate;
import pe.com.jdmm21.example.demoVote.entity.Citizen;
import pe.com.jdmm21.example.demoVote.repository.CandidateRepo;
import pe.com.jdmm21.example.demoVote.repository.CitizenRepo;

@Controller
public class VotingController {
	
	public static Logger logger = LoggerFactory.getLogger(VotingController.class);
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	
	
	@RequestMapping("/")
	public String goToVote() {
		logger.info("RETURNING VOTE HTML FILE");
		return "vote.html";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(
			@RequestParam String name,Model model, HttpSession session) {
		logger.info("GETTING CITIZEN FORM DB");
		Citizen citizen = citizenRepo.findByName(name);
		session.setAttribute("citizen", citizen);
		if(!citizen.isHasVoted()) {
			List<Candidate> candidates= candidateRepo.findAll();
			model.addAttribute("candidates", candidates);
			return "/permornVoted.html";
		}else {
			return "/alreadyVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id,HttpSession session) {
		Citizen citizen = (Citizen)session.getAttribute("citizen");
		
		if(!citizen.isHasVoted()) {
			citizen.setHasVoted(true);
			Candidate c = candidateRepo.findById(id).get();
			c.setNumberOfVotes(c.getNumberOfVotes()+1);
			candidateRepo.save(c);
			citizenRepo.save(citizen);
			return "voted.html";
		}
		return "alreadyVoted.html";
		
	}

}
