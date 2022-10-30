package com.securityLearn.registration.token;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.securityLearn.appuser.AppUser;

@Entity
public class ConfirmationToken {
	
	 @SequenceGenerator(
	            name = "confirmation_token_sequence",
	            sequenceName = "confirmation_token_sequence",
	            allocationSize = 1
	    )
	    @Id
	    @GeneratedValue(
	            strategy = GenerationType.SEQUENCE,
	            generator = "confirmation_token_sequence"
	    )
	    private Long id;

	    @Column(nullable = false)
	    private String token;

	    @Column(nullable = false)
	    private LocalDateTime createdAt;

	    @Column(nullable = false)
	    private LocalDateTime expiresAt;

	    private LocalDateTime confirmedAt;
	    
	    
	    

	    public ConfirmationToken() {
			super();
		}
	    
	    

		@ManyToOne
	    @JoinColumn(
	            nullable = false,
	            name = "app_user_id"
	    )
	    private AppUser appUser;

	    public ConfirmationToken(String token,
	                             LocalDateTime createdAt,
	                             LocalDateTime expiresAt,
	                             AppUser appUser) {
	        this.token = token;
	        this.createdAt = createdAt;
	        this.expiresAt = expiresAt;
	        this.appUser = appUser;
	    }

		public Long getId() {
			return id;
		}

		public String getToken() {
			return token;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public LocalDateTime getExpiresAt() {
			return expiresAt;
		}

		public LocalDateTime getConfirmedAt() {
			return confirmedAt;
		}

		public AppUser getAppUser() {
			return appUser;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public void setExpiresAt(LocalDateTime expiresAt) {
			this.expiresAt = expiresAt;
		}

		public void setConfirmedAt(LocalDateTime confirmedAt) {
			this.confirmedAt = confirmedAt;
		}

		public void setAppUser(AppUser appUser) {
			this.appUser = appUser;
		}
	   
		
		
         
	    
}
