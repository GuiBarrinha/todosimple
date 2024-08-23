package models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = User.TABLE_NAME)
public class User {

		public interface CreateUser{
		}
		
		public interface UpdateUser{
		}
		
		public static final String TABLE_NAME = "User";
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", unique = true)
		private Long id;
		
		
		@Column(name = "username", length = 100, nullable = false, unique = true)
		//@Nonnull(groups = CreateUser.class)
		@NotEmpty(groups = CreateUser.class)
		@Size(min = 2, max = 100)
		private String username;
		
		@JsonProperty(access = Access.WRITE_ONLY)
		@Column(name = "password", length = 60, nullable = false)
		//@Nonnull(groups = {CreateUser.class, UpdateUser.class})
		@NotEmpty(groups = {CreateUser.class, UpdateUser.class})
		@Size(min = 8, max = 60)
		private String password;

		//private List<Task> tasks = new ArrayList<Task>();
		
		public User() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public static String getTableName() {
			return TABLE_NAME;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if(this.id == null)
				if(other.id != null)
					return false;
				else if(!this.id.equals(other.id))
					return false;
			return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username)
					&& Objects.equals(this.password, other.password);
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
			return result;
		}


		
		
}
