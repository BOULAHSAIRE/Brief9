package model;


	import java.time.LocalDate;

	public class Todo {

				    private int id ;
					private String title;
					private String Username;
					private String description;
					private static LocalDate deadline;
					private String Categorie;
					private boolean status ;
					
					protected void Todo(){ 
					
					}

					public Todo(int id , String title,String Username, String description, LocalDate deadline, String Categorie, boolean status) {
						super();
						this.id =id;
						this.title = title;
						this.Username=Username; 
						this.description = description;
						this.deadline = deadline;
						this.Categorie = Categorie;
						this.status = status;
					}

					public Todo(int id2, String title2, String username2, String description2, String categorie2,
							LocalDate deadline2, boolean status2) {
					}

					public String getUsername() {
						return Username;
					}

					public void setUsername(String username) {
						Username = username;
					}

					public int getId() {
						return id;
					}

					public void setId(int id) {
						this.id = id;
					}

					public String getTitle() {
						return title;
					}

					public void setTitle(String title) {
						this.title = title;
					}

					public String getDescription() {
						return description;
					}

					public void setDescription(String description) {
						this.description = description;
					}


					public static LocalDate getDeadline() {
						return deadline;
					}

					public void setDeadline(LocalDate deadline) {
						this.deadline = deadline;
					}

					public String getCategorie() {
						return Categorie;
					}

					public void setCategorie(String categorie) {
						this.Categorie = categorie;
					}

					public boolean isStatus() {
						return status;
					}

					public void setStatus(boolean status) {
						this.status = status;
					}

					@Override
					public String toString() {
						return "Taches [title=" + title + ",Username =" + Username + ", description=" + description + ", deadline=" + deadline
								+ ", Categorie=" + Categorie + ", status=" + status + "]";
					}
		}
					


