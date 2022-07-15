package com.manage.OEMS.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.OEMS.exception.ResourceNotFoundException;
import com.manage.OEMS.model.Member;
import com.manage.OEMS.service.MemberService;
import com.manage.OEMS.service.NotificationService;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
	
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	NotificationService notificationService;
	
	// POST Request Handler for new Registration
	@PostMapping("/add")
	public Member addMember(@RequestBody Member member) {
		
		this.memberService.addMember(member);
		
		notificationService.notificationOnRegistration(member);
		
		return member;
	}
	
	
	// GET Request handler for Login, It returns data if any found in database.
	@GetMapping("/{username}/{password}")
    public Member Authenticate(@PathVariable(value = "username") String username,@PathVariable(value = "password") String password)
        throws ResourceNotFoundException {
		
		try {
			return memberService.Authenticate(username,password);
		}
		catch(Exception e){
			throw new ResourceNotFoundException("Resource with given value is not found");
		}
	  
    }
    
    // Get Member
    @GetMapping("/getMember/{memberId}")
    public Member getMember(@PathVariable("memberId") int memberId) {
    	 return memberService.getMember(memberId);
    }
    
    // Update Request
    @PutMapping("/updateMember/{member}")
    public int updateMember(@PathVariable("member") Member member) {
   	 return memberService.updateMember(member);
   }
    
    // Delete Request
    @DeleteMapping("/deleteMember/{memberId}")
    public int deleteMember(@PathVariable("memberId") int memberId) {
    	return memberService.deleteMember(memberId);
      }
    
    // Get All Users
    @GetMapping("/getAllUsers")
    public List<Member> getAllUsers() {
      	  return memberService.getAllUsers();
      }
    
    // Get All Organizers
    @GetMapping("/getAllOrganizers")
    public List<Member> getAllMembers() {
      	  return memberService.getAllMembers();
      }
		
}
