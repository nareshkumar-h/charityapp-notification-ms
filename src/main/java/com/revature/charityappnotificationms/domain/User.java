package com.revature.charityappnotificationms.domain;

public class User {
    private String email;
    private String applicationName;
    private String name;
    
  
	@Override
	public String toString() {
		return "User [email=" + email + ", applicationName=" + applicationName + ", name=" + name + "]";
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
   
}

