package com.amsidh.mvc.hashing;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashingUsingBCryptUtil {
public static void main(String[] args) {
	
	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder(10);
	System.out.println(bcrypt.encode("********"));
}
}
