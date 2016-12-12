/*It is a java bean that has setters and getters for all the data enetered in the form*/
package beans;


	public class StudentBean {

		
		private String id ;
		private String name;
		private String address;
		private String city;
		private String state;
		private String zip;
		private String cellphone;
		private String email;
		private String url;
		private String dos;
		private String camp;
		private String university;
		private String comments;
		private String month;
		private String year;
		private String recommend;
		

	    public String getName() {
	        return name;
	    }

	    public void setName(String Name) {
	        this.name = Name;
	    }
		
		
	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getZip() {
	        return zip;
	    }

	    public void setZip(String zip) {
	        this.zip = zip;
	    }

	    public String getCellphone() {
	        return cellphone;
	    }

	    public void setCellphone(String cellphone) {
	        this.cellphone = cellphone;
	    }

	    public String getURL() {
	        return url;
	    }

	    public void setURL(String url) {
	        this.url = url;
	    }
	    public String getDate() {
	        return dos;
	    }

	    public void setDate(String dos) {
	        this.dos = dos;
	    }

	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCamp() {
			return camp;
		}

		public void setCamp(String camp) {
			this.camp = camp;
		}

		public String getUniversity() {
			return university;
		}

		public void setUniversity(String university) {
			this.university = university;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getRecommend() {
			return recommend;
		}

		public void setRecommend(String recommend) {
			this.recommend = recommend;
		}

}
