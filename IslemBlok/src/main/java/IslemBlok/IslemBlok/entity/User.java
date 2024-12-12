package IslemBlok.IslemBlok.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import IslemBlok.IslemBlok.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User implements UserDetails{
	
	@Enumerated(EnumType.STRING)
	Role role;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	 @Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
	     return List.of(new SimpleGrantedAuthority(role.name()));
	 }

	 @Override
	 public boolean isAccountNonExpired() {
	     return true;
	 }

	 @Override
	 public boolean isAccountNonLocked() {
	     return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	      return true;
	  }

	  @Override
	  public boolean isEnabled() {
	      return true;
	  }
	
	
	
	
	
}
