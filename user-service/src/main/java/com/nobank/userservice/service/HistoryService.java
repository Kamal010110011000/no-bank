package com.nobank.userservice.service;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobank.userservice.model.Account;
import com.nobank.userservice.model.History;
import com.nobank.userservice.model.User;
import com.nobank.userservice.repository.UserRepository;

@Service
public class HistoryService {
	
	@Autowired
	private UserRepository userRepository;
	

	public User updateHistoryByAc(String me, String other,double amount) {

		long ac = Long.parseLong(other);
		User user = userRepository.findByAccount_AcNo(ac);
		User userMe = userRepository.findByEmail(me);
		
		LinkedList<History> historyList = user.getHistory();
		LinkedList<History> historyListMe = userMe.getHistory();
		
		//account updated
		Account account = user.getAccount();
		Account accountMe = userMe.getAccount();
		account.setBalance(account.getBalance()+amount);
		accountMe.setBalance(accountMe.getBalance()-amount);
		user.setAccount(account);
		userMe.setAccount(accountMe);
		
		//update History
		
		History history = new History(LocalDateTime.now(),amount,me,History.TransferType.Credit);
		History historyMe = new History(LocalDateTime.now(),amount,user.getEmail(),History.TransferType.Debit);
		historyList.addFirst(history);
		historyListMe.addFirst(historyMe);
		user.setHistory(historyList);
		userMe.setHistory(historyListMe);
		
		userRepository.save(user);
		userRepository.save(userMe);
		
		return userMe;
	}

	public User updateHistoryByEmail(String me,String other, double amount) {
		
		User user = userRepository.findByEmail(other);
		User userMe = userRepository.findByEmail(me);
		
		LinkedList<History> historyList =user.getHistory();
		LinkedList<History> historyListMe =userMe.getHistory();
		
		//account updated
		Account account = user.getAccount();
		Account accountMe = userMe.getAccount();
		
		account.setBalance(account.getBalance()+amount);
		accountMe.setBalance(accountMe.getBalance()-amount);
		user.setAccount(account);
		userMe.setAccount(accountMe);
		
		//update History
		
		History history = new History(LocalDateTime.now(),amount,me,History.TransferType.Credit);
		History historyMe = new History(LocalDateTime.now(),amount,other,History.TransferType.Debit);
		historyList.addFirst(history);
		historyListMe.addFirst(historyMe);
		user.setHistory(historyList);
		userMe.setHistory(historyListMe);
		
		userRepository.save(user);
		userRepository.save(userMe);
		
		System.out.println(user.toString());
		System.out.println(userMe.toString());
		
		return userMe;
	}

	
	public void AddHistory(History history, String email) {
		User user = userRepository.findByEmail(email);
		LinkedList<History> hist =user.getHistory();
		hist.addFirst(history);
		user.setHistory(hist);
		userRepository.save(user);
	}


}
